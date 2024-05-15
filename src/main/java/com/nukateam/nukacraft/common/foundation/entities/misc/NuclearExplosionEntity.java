package com.nukateam.nukacraft.common.foundation.entities.misc;

import com.nukateam.nukacraft.common.data.utils.ACMath;
import mod.azure.azurelib.animatable.GeoEntity;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimatableManager;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.util.AzureLibUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.network.PlayMessages;

import java.util.Stack;

import static com.nukateam.nukacraft.common.registery.EntityTypes.NUCLEAR_EXPLOSION;
import static com.nukateam.nukacraft.common.registery.ModParticles.MUSHROOM_CLOUD;
import static mod.azure.azurelib.core.animation.RawAnimation.begin;

public class NuclearExplosionEntity extends SimpleEntity implements GeoEntity {
    public static final int LIFE_TIME = 20;
    private static final EntityDataAccessor<Float> SIZE = SynchedEntityData.defineId(NuclearExplosionEntity.class, EntityDataSerializers.FLOAT);
    private final AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);
    private boolean spawnedParticle = false;
    private Stack<BlockPos> destroyingChunks = new Stack<>();

    public NuclearExplosionEntity(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    public NuclearExplosionEntity(PlayMessages.SpawnEntity spawnEntity, Level level) {
        this(NUCLEAR_EXPLOSION.get(), level);
        this.setBoundingBox(this.makeBoundingBox());
    }

    private static BlockPos containing(double p_275310_, double p_275414_, double p_275737_) {
        return new BlockPos(Mth.floor(p_275310_), Mth.floor(p_275414_), Mth.floor(p_275737_));
    }

    @Override
    public void tick() {
        super.tick();
        int chunksAffected = (int) Math.ceil(this.getSize());
        int radius = chunksAffected * 15;
        showParticles(radius);

        if (tickCount > LIFE_TIME && destroyingChunks.isEmpty()) {
            this.remove(RemovalReason.DISCARDED);
        } else {
            if (!level().isClientSide) {
                if (destroyingChunks.isEmpty()) {
                    var center = this.blockPosition();
                    int chunks = chunksAffected;
                    for (int i = -chunks; i <= chunks; i++) {
                        for (int j = -chunks; j <= chunks; j++) {
                            for (int k = -chunks; k <= chunks; k++) {
                                destroyingChunks.push(center.offset(i * 16, j * 2, k * 16));
                            }
                        }
                    }
                    destroyingChunks.sort((blockPos1, blockPos2) -> Double.compare(blockPos2.distManhattan(this.blockPosition()), blockPos1.distManhattan(this.blockPosition())));
                } else {
                    int tickChunkCount = Math.min(destroyingChunks.size(), 3);
                    for (int i = 0; i < tickChunkCount; i++) {
                        removeChunk(radius);
                    }
                }
            }

            var killBox = this.getBoundingBox().inflate(radius + radius * 0.5F, radius * 0.6, radius + radius * 0.5F);
            var flingStrength = getSize() * 0.33F;
            var maximumDistance = radius + radius * 0.5F + 1;

            for (var entity : this.level().getEntitiesOfClass(LivingEntity.class, killBox)) {
                var dist = entity.distanceTo(this);
                var damage = calculateDamage(dist, maximumDistance);
                var vec3 = entity.position().subtract(this.position()).add(0, 0.3, 0).normalize();
                entity.setDeltaMovement(vec3.scale(damage * 0.1F * flingStrength));
                if (damage > 0) {
                    entity.hurt(this.damageSources().inFire(), damage);
                }
                //entity.addEffect(new MobEffectInstance(IRRADIATED.get(), 48000, getSize() <= 1.5F ? 1 : 2, false, false, true));
            }
        }
    }

    @Override
    public boolean isOnFire() {
        return false;
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(SIZE, 1.0F);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        var controller = new AnimationController<>(this, "explosionController", 0,
                event -> event.setAndContinue(begin().thenPlayAndHold("explosion")));
        controller.setAnimationSpeed(1);
        controllers.add(controller);
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    public float getSize() {
        return this.entityData.get(SIZE);
    }

    public void setSize(float f) {
        this.entityData.set(SIZE, f);
    }

    private boolean isDestroyable(BlockState state) {
        return state.getBlock().getExplosionResistance() < 1000;
    }

    private float calculateDamage(float dist, float max) {
        float revert = (max - dist) / max;
        float baseDmg = this.getSize() <= 1.5F ? 100 : 100 + (this.getSize() - 1.5F) * 400;
        return revert * baseDmg;
    }

    private void showParticles(int radius) {
        if (!spawnedParticle) {
            spawnedParticle = true;
            int particleY = (int) Math.ceil(this.getY());
            while (particleY > level().getMinBuildHeight()
                    && particleY > this.getY() - radius / 2F && isDestroyable(level().
                    getBlockState(containing(this.getX(), particleY, this.getZ())))) {
                particleY--;
            }
            level().addAlwaysVisibleParticle(MUSHROOM_CLOUD.get(),
                    true, this.getX(), particleY + 2, this.getZ(), this.getSize(), 0, 0);
        }
    }

    private void removeChunk(int radius) {
        var chunkCorner = destroyingChunks.pop();
        var carve = new BlockPos.MutableBlockPos();
        var carveBelow = new BlockPos.MutableBlockPos();
        carve.set(chunkCorner);
        carveBelow.set(chunkCorner);
        var itemDropModifier = 0.025F / Math.min(1, this.getSize());

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                for (int y = 15; y >= 0; y--) {
                    carve.set(chunkCorner.getX() + x, Mth.clamp(chunkCorner.getY() + y, level().getMinBuildHeight(), level().getMaxBuildHeight()), chunkCorner.getZ() + z);
                    float widthSimplexNoise = (ACMath.sampleNoise3D(carve.getX(), carve.getY(), carve.getZ(), radius) - 0.5F) * 0.45F + 0.55F;
                    double yDist = ACMath.smin(0.6F - Math.abs(this.blockPosition().getY() - carve.getY()) / (float) radius, 0.6F, 0.2F);
                    double distToCenter = carve.distToLowCornerSqr(this.blockPosition().getX(), carve.getY() - 1, this.blockPosition().getZ());
                    double targetRadius = yDist * (radius + widthSimplexNoise * radius) * radius;
                    if (distToCenter <= targetRadius) {
                        BlockState state = level().getBlockState(carve);
                        if ((!state.isAir() || !state.getFluidState().isEmpty()) && isDestroyable(state)) {
                            carveBelow.set(carve.getX(), carve.getY() - 1, carve.getZ());
                            if (random.nextFloat() < itemDropModifier && state.getFluidState().isEmpty()) {
                                level().destroyBlock(carve, true);
                            } else {
                                level().setBlockAndUpdate(carve, Blocks.AIR.defaultBlockState());
                            }
                        }
                    }
                }
                if (random.nextFloat() < 0.15 && !level().getBlockState(carveBelow).isAir()) {
                    level().setBlockAndUpdate(carveBelow.above(), Blocks.FIRE.defaultBlockState());
                }
            }
        }
    }
}

package com.dayton.nukacraft.common.foundation.entities;

import com.dayton.nukacraft.common.data.utils.ACMath;
import mod.azure.azurelib.animatable.GeoEntity;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimatableManager;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.util.AzureLibUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;

import java.util.Stack;

import static com.dayton.nukacraft.common.foundation.entities.EntityTypes.NUCLEAR_EXPLOSION;
import static com.dayton.nukacraft.common.registery.ModParticles.*;
import static mod.azure.azurelib.core.animation.RawAnimation.begin;

public class NuclearExplosionEntity extends Entity implements GeoEntity {
    public static final int LIFE_TIME = 140;
    private final AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);

    private boolean spawnedParticle = false;
    private Stack<BlockPos> destroyingChunks = new Stack<>();
    private static final EntityDataAccessor<Float> SIZE = SynchedEntityData.defineId(NuclearExplosionEntity.class, EntityDataSerializers.FLOAT);

    public NuclearExplosionEntity(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    public NuclearExplosionEntity(PlayMessages.SpawnEntity spawnEntity, Level level) {
        this(NUCLEAR_EXPLOSION.get(), level);
        this.setBoundingBox(this.makeBoundingBox());
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return (Packet<ClientGamePacketListener>) NetworkHooks.getEntitySpawningPacket(this);
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
            if (!getLevel().isClientSide) {
                if (destroyingChunks.isEmpty()) {
                    BlockPos center = this.blockPosition();
                    int chunks = chunksAffected;
                    for (int i = -chunks; i <= chunks; i++) {
                        for (int j = -chunks; j <= chunks; j++) {
                            for (int k = -chunks; k <= chunks; k++) {
                                destroyingChunks.push(center.offset(i * 16, j * 16, k * 16));
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
            for (LivingEntity entity : this.getLevel().getEntitiesOfClass(LivingEntity.class, killBox)) {
                var dist = entity.distanceTo(this);
                var damage = calculateDamage(dist, maximumDistance);
                var vec3 = entity.position().subtract(this.position()).add(0, 0.3, 0).normalize();
                entity.setDeltaMovement(vec3.scale(damage * 0.1F * flingStrength));
//                if (damage > 0) {
//                    if (entity.getType().is(RESISTS_RADIATION)) {
//                        damage *= 0.25F;
//                    }
//                    entity.hurt(causeNukeDamage(getLevel().registryAccess()), damage);
//                }
                //entity.addEffect(new MobEffectInstance(IRRADIATED.get(), 48000, getSize() <= 1.5F ? 1 : 2, false, false, true));
            }
        }
    }



    @Override
    protected void defineSynchedData() {
        this.entityData.define(SIZE, 1.0F);
    }

    @Override protected void readAdditionalSaveData(CompoundTag compoundTag) {}
    @Override protected void addAdditionalSaveData(CompoundTag compoundTag) {}

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
        return /*!state.is(UNMOVEABLE) &&*/ state.getBlock().getExplosionResistance() < 1000;
    }

    private static BlockPos containing(double p_275310_, double p_275414_, double p_275737_) {
        return new BlockPos(Mth.floor(p_275310_), Mth.floor(p_275414_), Mth.floor(p_275737_));
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
            while (particleY > getLevel().getMinBuildHeight()
                    && particleY > this.getY() - radius / 2F && isDestroyable(getLevel().
                    getBlockState(containing(this.getX(), particleY, this.getZ())))) {
                particleY--;
            }
//            getLevel().addAlwaysVisibleParticle(MUSHROOM_CLOUD.get(),
//                    true, this.getX(), particleY + 2, this.getZ(), this.getSize(), 0, 0);
        }
    }

    private void removeChunk(int radius) {
        BlockPos chunkCorner = destroyingChunks.pop();
        BlockPos.MutableBlockPos carve = new BlockPos.MutableBlockPos();
        BlockPos.MutableBlockPos carveBelow = new BlockPos.MutableBlockPos();
        carve.set(chunkCorner);
        carveBelow.set(chunkCorner);
        float itemDropModifier = 0.025F / Math.min(1, this.getSize());
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                for (int y = 15; y >= 0; y--) {
                    carve.set(chunkCorner.getX() + x, Mth.clamp(chunkCorner.getY() + y, getLevel().getMinBuildHeight(), getLevel().getMaxBuildHeight()), chunkCorner.getZ() + z);
                    float widthSimplexNoise1 = (ACMath.sampleNoise3D(carve.getX(), carve.getY(), carve.getZ(), radius) - 0.5F) * 0.45F + 0.55F;
                    double yDist = ACMath.smin(0.6F - Math.abs(this.blockPosition().getY() - carve.getY()) / (float) radius, 0.6F, 0.2F);
                    double distToCenter = carve.distToLowCornerSqr(this.blockPosition().getX(), carve.getY() - 1, this.blockPosition().getZ());
                    double targetRadius = yDist * (radius + widthSimplexNoise1 * radius) * radius;
                    if (distToCenter <= targetRadius) {
                        BlockState state = getLevel().getBlockState(carve);
                        if ((!state.isAir() || !state.getFluidState().isEmpty()) && isDestroyable(state)) {
                            carveBelow.set(carve.getX(), carve.getY() - 1, carve.getZ());
                            if (random.nextFloat() < itemDropModifier && state.getFluidState().isEmpty()) {
                                getLevel().destroyBlock(carve, true);
                            } else {
                                getLevel().setBlockAndUpdate(carve, Blocks.AIR.defaultBlockState());
                            }
                        }
                    }
                }
                if (random.nextFloat() < 0.15 && !getLevel().getBlockState(carveBelow).isAir()) {
                    getLevel().setBlockAndUpdate(carveBelow.above(), Blocks.FIRE.defaultBlockState());
                }
            }
        }
    }
}

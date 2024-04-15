package com.nukateam.nukacraft.common.foundation.entities.misc;

import com.nukateam.nukacraft.common.data.utils.ExplosionType;
import com.nukateam.nukacraft.common.settings.ExplosionTypes;
import mod.azure.azurelib.core.animation.AnimatableManager;
import mod.azure.azurelib.core.animation.AnimationController;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import static com.jetug.chassis_core.common.util.helpers.MathHelper.getFraction;
import static mod.azure.azurelib.core.animation.RawAnimation.begin;

public class NuclearExplosionEffectEntity extends SimpleGeoEntity {
    private static final int explosionFade = 40;
    private static final int tremorFade = 30;
    private static final int WORLD_MIN_Y = -64;
    private final int lifeTime;
    public int darkSkyFor;
    public int tremorFor;
    public int muteNonNukeSoundsFor;
    public int renderNukeFlashFor;
    public float prevNukeFlashAmount = 0;
    public float nukeFlashAmount = 0;
    public float masterVolumeNukeModifier = 0.0F;
    private ExplosionType explosionType = ExplosionTypes.MINI_NUKE;
    private boolean initialized = false;

    public NuclearExplosionEffectEntity(EntityType<?> entityType, Level level) {
        super(entityType, level);
        noCulling = true;
        darkSkyFor = 70;
        muteNonNukeSoundsFor = 50;
        lifeTime = explosionType.getDuration();
        tremorFor = explosionType.getTremorDuration();
        renderNukeFlashFor = explosionType.getFlashDuration();
    }

    @Override
    public boolean isOnFire() {
        return false;
    }

    public void setType(ExplosionType explosionType) {
        this.explosionType = explosionType;
        initialized = true;
//        setPos(getBlockPos());
    }

    public ExplosionType getExplosionType() {
        return explosionType;
    }

    public float getOpacity() {
        var fadeLeft = lifeTime - tickCount;
        return fadeLeft > explosionFade ? 1 : (float) getFraction(fadeLeft, explosionFade);
    }

    public float getTremorIntensity() {
        if (tickCount > explosionType.getTremorDuration()) return 0;

        var tremorLeft = explosionType.getTremorDuration() - tickCount;
        return tremorLeft > tremorFade ? 1 : (float) getFraction(tremorLeft, tremorFade);
    }

    private int sub(int s) {
        if (s > 0) return --s;
        return s;
    }

    @OnlyIn(Dist.CLIENT)
    public double getDistanceToPlayer() {
        var minecraft = Minecraft.getInstance();
        assert minecraft.player != null;
        return minecraft.player.getPosition(minecraft.getFrameTime())
                .distanceTo(getPosition(minecraft.getFrameTime()));
    }

    public BlockPos getBlockPos() {
        var pos = position();
        pos = pos.subtract(0, 1, 0);
        var posI = new Vec3i((int)pos.x, (int)pos.y, (int)pos.z);
        return new BlockPos(posI);
    }

    private Vec3i toVec3I(Vec3 vec){
        return new Vec3i((int)vec.x, (int)vec.y, (int)vec.z);
    }

    public Vec3 getExplosionPos() {
        var pos = position();

        while (level().isEmptyBlock(new BlockPos(toVec3I(pos))) && pos.y >= WORLD_MIN_Y)
            pos = pos.subtract(0, 1, 0);

        return pos;
    }

    @Override
    public void tick() {
        super.tick();

        if (initialized && level().isEmptyBlock(getBlockPos()))
            setPos(getExplosionPos());

        if (tickCount > lifeTime) this.remove(RemovalReason.DISCARDED);

        prevNukeFlashAmount = nukeFlashAmount;
        darkSkyFor = sub(darkSkyFor);
        tremorFor = sub(tremorFor);

        if (muteNonNukeSoundsFor > 0) {
            muteNonNukeSoundsFor--;
            if (masterVolumeNukeModifier < 1.0F) {
                masterVolumeNukeModifier += 0.1F;
            }
        } else if (masterVolumeNukeModifier > 0.0F) {
            masterVolumeNukeModifier -= 0.1F;
        }
        if (renderNukeFlashFor > 0) {
            if (nukeFlashAmount < 1F)
                nukeFlashAmount = Math.min(nukeFlashAmount + 0.4F, 1F);
            renderNukeFlashFor--;
        } else if (nukeFlashAmount > 0F) {
            nukeFlashAmount = Math.max(nukeFlashAmount - 0.05F, 0F);
        }
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        var controller = new AnimationController<>(this, "explosionController", 0,
                event -> event.setAndContinue(begin().thenPlayAndHold("explosion")));
        controller.setAnimationSpeed(1);
        controllers.add(controller);
    }
}

package com.dayton.nukacraft.common.foundation.entities;

import mod.azure.azurelib.core.animation.*;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;


import static com.jetug.chassis_core.common.util.helpers.MathHelper.*;
import static mod.azure.azurelib.core.animation.RawAnimation.*;

public class NuclearExplosionEffectEntity extends SimpleGeoEntity{
    private static final int explosionFade = 40;
    private static final int tremorFade = 30;
    private static final int WORLD_MIN_Y = -64;
    private final int lifeTime;
    private ExplosionType explosionType = ExplosionType.MINI_NUKE;
    private boolean initialized = false;

    public int darkSkyFor;
    public int tremorFor;
    public int muteNonNukeSoundsFor;
    public int renderNukeFlashFor;
    public float prevNukeFlashAmount = 0;
    public float nukeFlashAmount = 0;
    public float masterVolumeNukeModifier = 0.0F;


    public NuclearExplosionEffectEntity(EntityType<?> entityType, Level level) {
        super(entityType, level);
        noCulling = true;
        darkSkyFor = 70;
        muteNonNukeSoundsFor = 50;
        lifeTime = explosionType.getDuration();
        tremorFor = explosionType.getTremorDuration();
        renderNukeFlashFor = explosionType.getFlashDuration();
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
        return fadeLeft > explosionFade ? 1 : (float)getFraction(fadeLeft, explosionFade);
    }

    public float getTremorIntensity(){
        if(tickCount > explosionType.getTremorDuration()) return 0;

        var tremorLeft = explosionType.getTremorDuration() - tickCount;
        return tremorLeft > tremorFade ? 1 : (float)getFraction(tremorLeft, tremorFade);
    }

    private int sub(int s){
        if(s > 0) return --s;
        return s;
    }

    public double getDistanceToPlayer(){
        var minecraft = Minecraft.getInstance();
        assert minecraft.player != null;
        return minecraft.player.getPosition(minecraft.getFrameTime())
                .distanceTo(getPosition(minecraft.getFrameTime()));
    }

    public BlockPos getBlockPos(){
        var pos = getPosition(0);
        pos = pos.subtract(0,1,0);

        return new BlockPos(pos);
    }

    public Vec3 getExplosionPos(){
        var pos = getPosition(0);

        while (level.isEmptyBlock(new BlockPos(pos)) && pos.y >= WORLD_MIN_Y){
            pos = pos.subtract(0,1,0);
        }

        return pos;
    }

    @Override
    public void tick() {
        super.tick();

        if(initialized && level.isEmptyBlock(getBlockPos()))
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

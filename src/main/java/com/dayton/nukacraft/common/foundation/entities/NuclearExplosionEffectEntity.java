package com.dayton.nukacraft.common.foundation.entities;

import mod.azure.azurelib.core.animation.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

import static com.jetug.chassis_core.common.util.helpers.MathHelper.*;
import static mod.azure.azurelib.core.animation.RawAnimation.*;

public class NuclearExplosionEffectEntity extends SimpleGeoEntity{
    public static final int SHAKE_DISTANCE = 45;

    private static final int fadeTime = 40;
    private static final int tremorTime = 30;
    private static final int lifeTime = 140;
    private static final ExplosionType explosionType = ExplosionType.MINI_NUKE;

    public int renderNukeSkyDarkFor;
    public int tremorFor;
    public int muteNonNukeSoundsFor;
    public int renderNukeFlashFor;
    public float prevNukeFlashAmount = 0;
    public float nukeFlashAmount = 0;
    public float prevPossessionStrengthAmount = 0;
    public float possessionStrengthAmount = 0;
    public float masterVolumeNukeModifier = 0.0F;

    public NuclearExplosionEffectEntity(EntityType<?> entityType, Level level) {
        super(entityType, level);
        noCulling = true;
        renderNukeSkyDarkFor = 70;
        muteNonNukeSoundsFor = 50;
        tremorFor = explosionType.getTremorDuration();
        renderNukeFlashFor = explosionType.getFlashDuration();
    }

    public ExplosionType getExplosionType() {
        return explosionType;
    }

    public float getOpacity() {
        var fadeLeft = lifeTime - tickCount;
        return fadeLeft > fadeTime ? 1 : (float)getFraction(fadeLeft, fadeTime);
    }

    public float getTremorIntensity(){
        var tremorLeft = lifeTime - tickCount;
        return tremorLeft > tremorTime ? 1 : (float)getFraction(tremorLeft, tremorTime);
    }

    private void sub(float s){
        if(s > 0) s--;
    }

    @Override
    public void tick() {
        super.tick();
        if (tickCount > lifeTime) this.remove(RemovalReason.DISCARDED);

        prevNukeFlashAmount = nukeFlashAmount;

        sub(renderNukeSkyDarkFor);
        sub(tremorFor);

        if (muteNonNukeSoundsFor > 0) {
            muteNonNukeSoundsFor--;
            if (masterVolumeNukeModifier < 1.0F) {
                masterVolumeNukeModifier += 0.1F;
            }
        } else if (masterVolumeNukeModifier > 0.0F) {
            masterVolumeNukeModifier -= 0.1F;
        }
        if (renderNukeFlashFor > 0) {
            if (nukeFlashAmount < 1F) {
                nukeFlashAmount = Math.min(nukeFlashAmount + 0.4F, 1F);
            }
            renderNukeFlashFor--;
        } else if (nukeFlashAmount > 0F) {
            nukeFlashAmount = Math.max(nukeFlashAmount - 0.05F, 0F);
        }
        else if (possessionStrengthAmount > 0F) {
            possessionStrengthAmount = Math.max(possessionStrengthAmount - 0.05F, 0F);
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

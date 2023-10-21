package com.dayton.nukacraft.common.foundation.entities;

import com.dayton.nukacraft.client.models.endity.core.ClientProxy;
import com.dayton.nukacraft.common.registery.ACSoundRegistry;
import mod.azure.azurelib.core.animation.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import static mod.azure.azurelib.core.animation.RawAnimation.*;

public class NuclearExplosionEffectEntity extends SimpleGeoEntity{
    public static final int LIFE_TIME = 140;
    public  int renderNukeSkyDarkFor = 0;
    public int muteNonNukeSoundsFor = 0;
    public int renderNukeFlashFor = 0;
    public float prevNukeFlashAmount = 0;
    public float nukeFlashAmount = 0;
    public float prevPossessionStrengthAmount = 0;
    public float possessionStrengthAmount = 0;
    public float masterVolumeNukeModifier = 0.0F;

    public NuclearExplosionEffectEntity(EntityType<?> entityType, Level level) {
        super(entityType, level);
        noCulling = true;
        renderNukeFlashFor = 16;
    }

    @Override
    public void tick() {
        super.tick();
        renderNukeSkyDarkFor = 70;
        muteNonNukeSoundsFor = 50;

        if (tickCount > LIFE_TIME) {
            this.remove(RemovalReason.DISCARDED);
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

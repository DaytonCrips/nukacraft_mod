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

    public NuclearExplosionEffectEntity(EntityType<?> entityType, Level level) {
        super(entityType, level);
        noCulling = true;
    }

    @Override
    public void tick() {
        super.tick();
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

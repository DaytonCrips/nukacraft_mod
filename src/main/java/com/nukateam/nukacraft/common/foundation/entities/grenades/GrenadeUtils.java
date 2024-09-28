package com.nukateam.nukacraft.common.foundation.entities.grenades;

import com.nukateam.ntgl.common.foundation.entity.ProjectileEntity;
import com.nukateam.ntgl.common.foundation.world.ProjectileExplosion;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Explosion;

public class GrenadeUtils {
    public static void createFireExplosion(Entity entity, float radius, boolean forceNone)
    {
        var world = entity.level();
        if(world.isClientSide())
            return;

        world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.FIRE_EXTINGUISH, SoundSource.PLAYERS, 1.0F, 1.0F);
        world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.GLASS_BREAK, SoundSource.PLAYERS, 1.0F, 1.0F);
        var source = entity instanceof ProjectileEntity projectile ? entity.damageSources().explosion(entity, projectile.getShooter()) : null;
        Explosion.BlockInteraction mode = Explosion.BlockInteraction.KEEP;
        Explosion explosion = new ProjectileExplosion(world, entity, source, null, entity.getX(), entity.getY(), entity.getZ(), radius, true, mode);

        if(net.minecraftforge.event.ForgeEventFactory.onExplosionStart(world, explosion))
            return;

        // Do explosion logic
        explosion.explode();
        explosion.finalizeExplosion(true);

    }
}

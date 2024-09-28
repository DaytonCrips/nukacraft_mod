package com.nukateam.nukacraft.common.foundation.items.guns;

import com.nukateam.ntgl.common.foundation.entity.ThrowableGrenadeEntity;
import com.nukateam.ntgl.common.foundation.init.ModSounds;
import com.nukateam.ntgl.common.foundation.item.GrenadeItem;
import com.nukateam.nukacraft.common.foundation.entities.misc.FireGrenadeEntity;
import com.nukateam.nukacraft.common.foundation.entities.misc.FlameFloaterGrenadeEntity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class FlameFloaterGrenadeItem  extends GrenadeItem {
    public FlameFloaterGrenadeItem(Item.Properties properties, int maxCookTime) {
        super(properties, maxCookTime);
    }

    @Override
    public ThrowableGrenadeEntity create(Level world, LivingEntity entity, int timeLeft) {
        return new FlameFloaterGrenadeEntity(world, entity, timeLeft);
    }

    @Override
    protected void onThrown(Level world, ThrowableGrenadeEntity entity) {
        world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), ModSounds.ITEM_GRENADE_PIN.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
    }
}

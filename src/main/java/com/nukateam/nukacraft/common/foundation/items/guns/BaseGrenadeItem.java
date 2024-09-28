package com.nukateam.nukacraft.common.foundation.items.guns;

import com.nukateam.ntgl.common.foundation.entity.ThrowableGrenadeEntity;
import com.nukateam.ntgl.common.foundation.init.ModSounds;
import com.nukateam.ntgl.common.foundation.item.GrenadeItem;
import com.nukateam.nukacraft.common.data.interfaces.GrenadeFactory;
import com.nukateam.nukacraft.common.foundation.entities.misc.BaseballGrenadeEntity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class BaseGrenadeItem<T extends ThrowableGrenadeEntity> extends GrenadeItem {
    private final GrenadeFactory<T> grenadeFactory;

    public BaseGrenadeItem(Properties properties, int maxCookTime, GrenadeFactory<T> factory) {
        super(properties, maxCookTime);
        this.grenadeFactory = factory;
    }

    @Override
    public ThrowableGrenadeEntity create(Level world, LivingEntity entity, int timeLeft) {
        return grenadeFactory.get(world, entity, timeLeft);
    }

    @Override
    protected void onThrown(Level world, ThrowableGrenadeEntity entity) {
        world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), ModSounds.ITEM_GRENADE_PIN.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
    }
}

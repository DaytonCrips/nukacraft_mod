package com.nukateam.nukacraft.common.foundation.items.guns;

import com.nukateam.ntgl.common.foundation.entity.ThrowableGrenadeEntity;
import com.nukateam.ntgl.common.foundation.init.ModSounds;
import com.nukateam.ntgl.common.foundation.item.GrenadeItem;
import com.nukateam.nukacraft.common.data.interfaces.GrenadeFactory;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class BaseGrenadeItem<T extends ThrowableGrenadeEntity> extends GrenadeItem {
    private final GrenadeFactory<T> grenadeFactory;
    private Supplier<SoundEvent> soundEvent = ModSounds.ITEM_GRENADE_PIN;

    public BaseGrenadeItem(Properties properties, int maxCookTime, GrenadeFactory<T> factory) {
        super(properties, maxCookTime);
        this.grenadeFactory = factory;
    }

    public BaseGrenadeItem(Properties properties, int maxCookTime, GrenadeFactory<T> factory, @Nullable Supplier<SoundEvent> soundEvent) {
        this(properties, maxCookTime, factory);
        this.soundEvent = soundEvent;
    }

    @Override
    public void onUseTick(Level level, LivingEntity player, ItemStack stack, int count) {
        if (!this.canCook()) return;

        int duration = this.getUseDuration(stack) - count;
        if (soundEvent != null && duration == 10)
            player.level().playLocalSound(
                    player.getX(),
                    player.getY(),
                    player.getZ(),
                    soundEvent.get(),
                    SoundSource.PLAYERS,
                    1.0F, 1.0F, false);
    }

    @Override
    public ThrowableGrenadeEntity create(Level world, LivingEntity entity, int timeLeft) {
        return grenadeFactory.get(world, entity, timeLeft);
    }

//    @Override
//    protected void onThrown(Level world, ThrowableGrenadeEntity entity) {
//        if(soundEvent != null)
//            world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), soundEvent, SoundSource.PLAYERS, 1.0F, 1.0F);
//    }
}

package com.nukateam.nukacraft.common.foundation.items.guns;

import com.nukateam.ntgl.Config;
import com.nukateam.ntgl.common.foundation.entity.ThrowableGrenadeEntity;
import com.nukateam.ntgl.common.foundation.entity.ThrowableItemEntity;
import com.nukateam.ntgl.common.foundation.init.ModSounds;
import com.nukateam.ntgl.common.foundation.item.GrenadeItem;
import com.nukateam.nukacraft.common.foundation.entities.misc.BaseballGrenadeEntity;
import com.nukateam.nukacraft.common.foundation.entities.misc.CocktailMolotovEntity;
import com.nukateam.nukacraft.common.registery.EntityTypes;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

import static com.nukateam.ntgl.common.foundation.entity.ProjectileEntity.createExplosion;
import static com.nukateam.nukacraft.common.registery.items.ModWeapons.BASEBALL_GRENADE;

public class CocktailMolotovItem  extends GrenadeItem {
    public CocktailMolotovItem(Properties properties, int maxCookTime) {
        super(properties, maxCookTime);
    }

    @Override
    public ThrowableGrenadeEntity create(Level world, LivingEntity entity, int timeLeft) {
        return new CocktailMolotovEntity(world, entity, timeLeft);
    }

    @Override
    protected void onThrown(Level world, ThrowableGrenadeEntity entity) {
        world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), ModSounds.ITEM_GRENADE_PIN.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
    }
}

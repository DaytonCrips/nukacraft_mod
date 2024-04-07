package com.nukateam.nukacraft.common.foundation.entities.misc;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.ItemFrame;
import net.minecraft.world.level.Level;

public class WeaponDisplay extends ItemFrame {

    public WeaponDisplay(EntityType<? extends WeaponDisplay> weaponDisplayEntityType, Level level) {
        super(weaponDisplayEntityType, level);
    }
}

package com.dayton.nukacraft.common.foundation.items.custom.frame;

import com.jetug.chassis_core.common.foundation.item.ChassisEquipment;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.dayton.nukacraft.common.data.constants.PowerArmorPrats.JETPACK;

public class Jetpack extends ChassisEquipment {
    public Jetpack(Properties pProperties) {
        super(pProperties, JETPACK);
    }
}
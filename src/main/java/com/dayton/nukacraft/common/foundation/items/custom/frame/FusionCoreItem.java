package com.dayton.nukacraft.common.foundation.items.custom.frame;

import com.jetug.chassis_core.common.foundation.item.ChassisEquipment;
import net.minecraft.world.item.Item;

import static com.dayton.nukacraft.common.data.constants.PowerArmorPrats.FUSION_CORE;

public class FusionCoreItem extends ChassisEquipment {
    public FusionCoreItem(Item.Properties pProperties) {
        super(pProperties, FUSION_CORE);
    }
}
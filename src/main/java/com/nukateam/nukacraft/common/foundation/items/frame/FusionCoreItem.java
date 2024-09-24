package com.nukateam.nukacraft.common.foundation.items.frame;

import com.jetug.chassis_core.common.foundation.item.ChassisEquipment;
import com.nukateam.ntgl.common.base.NetworkAmmoManager;
import com.nukateam.ntgl.common.base.config.Ammo;
import com.nukateam.ntgl.common.foundation.item.interfaces.IAmmo;
import net.minecraft.world.item.Item;

import static com.nukateam.nukacraft.common.data.constants.PowerArmorPrats.FUSION_CORE;

public class FusionCoreItem extends ChassisEquipment implements IAmmo {
    private Ammo ammo;

    public FusionCoreItem(Item.Properties pProperties) {
        super(pProperties, FUSION_CORE);
    }

    @Override
    public Ammo getAmmo() {
        return ammo;
    }

    @Override
    public void setAmmo(NetworkAmmoManager.Supplier supplier) {
        this.ammo = supplier.getAmmo();
    }
}
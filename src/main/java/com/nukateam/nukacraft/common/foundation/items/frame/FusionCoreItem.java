package com.nukateam.nukacraft.common.foundation.items.frame;

import com.jetug.chassis_core.common.foundation.item.ChassisEquipment;
import com.nukateam.ntgl.common.base.NetworkManager;
import com.nukateam.ntgl.common.base.config.Ammo;
import com.nukateam.ntgl.common.foundation.item.interfaces.IAmmo;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.jetug.chassis_core.common.foundation.item.StackUtils.getVariant;
import static com.nukateam.nukacraft.common.data.constants.PowerArmorPrats.FUSION_CORE;

public class FusionCoreItem extends ChassisEquipment implements IAmmo<Ammo> {
    private Ammo ammo;

    public FusionCoreItem(Item.Properties pProperties) {
        super(pProperties, FUSION_CORE);
    }

    @Override
    public Ammo getAmmo() {
        return ammo;
    }

    @Override
    public void setConfig(NetworkManager.Supplier supplier) {
        this.ammo = (Ammo) supplier.getConfig();
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> list, TooltipFlag isAdvanced) {
        super.appendHoverText(stack, level, list, isAdvanced);
        list.add(Component.translatable("§3NeM: " + (stack.getMaxDamage() - stack.getDamageValue()) + "/" + stack.getMaxDamage()));


    }
}
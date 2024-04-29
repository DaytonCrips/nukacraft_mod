package com.nukateam.nukacraft.common.foundation.items.consumables;

import com.nukateam.nukacraft.common.data.utils.RadiationUtils;
import com.nukateam.nukacraft.common.registery.items.ModFood;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.nukateam.nukacraft.common.foundation.items.consumables.RadItem.showRadiation;

public class RadNamedItem extends ItemNameBlockItem {
    protected final float radiation;

    public RadNamedItem(float radiation, Block block, Item.Properties prop) {
        super(block, prop);
        this.radiation = radiation;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (entity instanceof Player && !level.isClientSide) {
            RadiationUtils.addRadiation(entity, this.radiation);

            if (stack.getItem() == ModFood.CRACKBERRY.get())
                entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0, false, false));
            if (stack.getItem() == ModFood.XANDER_ROOT.get())
                entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 0, false, false));
        }
        return super.finishUsingItem(stack, level, entity);
    }

    @Override
    public void appendHoverText(ItemStack item, @Nullable Level level, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(item, level, list, flag);
        showRadiation(list, radiation);

        if (item.getItem() == ModFood.CRACKBERRY.get()) {
            list.add(Component.translatable("tooltip.nukacraft.fire_res").append("§9(0:10)"));
        }
    }
}
package com.dayton.nukacraft.common.foundation.items;

import com.dayton.guns.common.foundation.enchantment.EnchantmentTypes;
import com.dayton.nukacraft.common.foundation.blocks.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModItemTabs {
    public static final CreativeModeTab NUKA_MATERIAL = new CreativeModeTab("nuka_material") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.ADVMAG.get());
        }
    };
    public static final CreativeModeTab NUKA_BLOCKS = new CreativeModeTab("nuka_blocks") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.BTITAN_ORE.get());
        }
    };

    public static final CreativeModeTab NUKA_FOOD = new CreativeModeTab("nuka_foods") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.NUKACOLA.get());
        }
    };

    public static final CreativeModeTab NUKA_WEAPONS = new CreativeModeTab("nuka_equip") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModGuns.ROUND10MM.get());
        }
    }.setEnchantmentCategories(EnchantmentTypes.GUN, EnchantmentTypes.SEMI_AUTO_GUN);

    public static final CreativeModeTab NUKA_ARMOR = new CreativeModeTab("nuka_armor") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(PowerArmorItems.T45_HELMET.get());
        }
    };
//    public static final CreativeModeTab NUKA_ARMOR = new CreativeModeTab("nuka_armor") {
//        @Override
//        public ItemStack makeIcon() {
//            return new ItemStack(ModArmorItems.WOOD2_BODY.get());
//        }
//    };
}

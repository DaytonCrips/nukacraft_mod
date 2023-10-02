package com.dayton.nukacraft.common.foundation.items;

import com.dayton.nukacraft.common.foundation.blocks.ModBlocksClass;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModItemTabs {
    public static final CreativeModeTab NUKA_MATERIAL = new CreativeModeTab("nuka_material") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItemsClass.ADVMAG.get());
        }
    };
    public static final CreativeModeTab NUKA_BLOCKS = new CreativeModeTab("nuka_blocks") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocksClass.BTITAN_ORE.get());
        }
    };

    public static final CreativeModeTab NUKA_FOOD = new CreativeModeTab("nuka_foods") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItemsClass.NUKACOLA.get());
        }
    };
    public static final CreativeModeTab NUKA_EQUIP = new CreativeModeTab("nuka_equip") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItemsClass.ROUND10MM.get());
        }
    };
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

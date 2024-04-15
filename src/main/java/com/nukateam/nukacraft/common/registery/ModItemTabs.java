package com.nukateam.nukacraft.common.registery;

import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.registery.items.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.Field;

public class ModItemTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NukaCraftMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> NUKA_MATERIAL = CREATIVE_MODE_TABS.register("nuka_material",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ADVMAG.get()))
                    .title(Component.translatable("itemGroup.nuka_material"))
                    .displayItems((params, output) -> registerItems(output, ModItems.ITEMS))
                    .build());
    

    public static final RegistryObject<CreativeModeTab> NUKA_BLOCKS = CREATIVE_MODE_TABS.register("nuka_blocks",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ADVMAG.get()))
                    .title(Component.translatable("itemGroup.nuka_blocks"))
                    .displayItems((params, output) -> registerItems(output, ModBlockItems.ITEMS))
                    .build());    

    public static final RegistryObject<CreativeModeTab> NUKA_FOOD = CREATIVE_MODE_TABS.register("nuka_foods",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ADVMAG.get()))
                    .title(Component.translatable("itemGroup.nuka_foods"))
                    .displayItems((params, output) -> registerItems(output, ModFood.ITEMS))
                    .build());
    
    
    public static final RegistryObject<CreativeModeTab> NUKA_WEAPONS = CREATIVE_MODE_TABS.register("nuka_equip",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ADVMAG.get()))
                    .title(Component.translatable("itemGroup.nuka_equip"))
                    .displayItems((params, output) -> registerItems(output, ModFood.ITEMS))
                    .build());
    
    
    public static final RegistryObject<CreativeModeTab> NUKA_ARMOR = CREATIVE_MODE_TABS.register("nuka_armor",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ADVMAG.get()))
                    .title(Component.translatable("itemGroup.nuka_armor"))
                    .displayItems((params, output) -> registerItems(output, ModArmorItems.ITEMS))
                    .build());

    public static final RegistryObject<CreativeModeTab> POWER_ARMOR = CREATIVE_MODE_TABS.register("power_armor",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ADVMAG.get()))
                    .title(Component.translatable("itemGroup.power_armor"))
                    .displayItems((params, output) -> registerItems(output, PowerArmorItems.ITEMS))
                    .build());

    
    private static void registerItems(CreativeModeTab.Output output,  DeferredRegister<Item> register) {
        for(var entry: register.getEntries()){
            output.accept(entry.get());
        }
    }

    private static void registerModMaterials(CreativeModeTab.Output output, Class<?> modItemsClass) {
        var fields = modItemsClass.getFields();

        try {
            for (var field: fields) {
                var obj = field.get(null);
                if (obj instanceof RegistryObject<?>) {
                    var item = (RegistryObject<Item>) obj;

                    output.accept(item.get());
                }
            }
        } catch (Exception e) {
            NukaCraftMod.LOGGER.error(e.getMessage(), e);
        }

    }

//    public static final CreativeModeTab NUKA_ARMOR = new CreativeModeTab("nuka_armor") {
//        @Override
//        public ItemStack makeIcon() {
//            return new ItemStack(ModArmorItems.WOOD2_BODY.get());
//        }
//    };

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}

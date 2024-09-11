package com.nukateam.nukacraft.common.registery;

import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.data.enums.PowerArmorPart;
import com.nukateam.nukacraft.common.registery.items.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraft.world.item.CreativeModeTab.*;

public class ModItemTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NukaCraftMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> NUKA_MATERIAL = CREATIVE_MODE_TABS.register("nuka_material",
            () -> builder().icon(() -> new ItemStack(ModItems.ADVMAG.get()))
                    .title(Component.translatable("itemGroup.nuka_material"))
                    .displayItems((params, output) -> registerItems(output, ModItems.ITEMS))
                    .build());


    public static final RegistryObject<CreativeModeTab> NUKA_BLOCKS = CREATIVE_MODE_TABS.register("nuka_blocks",
            () -> builder().icon(() -> new ItemStack(ModBlocks.BLUETILE.get()))
                    .title(Component.translatable("itemGroup.nuka_blocks"))
                    .displayItems((params, output) -> registerItems(output, ModBlockItems.ITEMS))
                    .build());

    public static final RegistryObject<CreativeModeTab> NUKA_FOOD = CREATIVE_MODE_TABS.register("nuka_foods",
            () -> builder().icon(() -> new ItemStack(ModFood.NUKA_COLA.get()))
                    .title(Component.translatable("itemGroup.nuka_foods"))
                    .displayItems((params, output) -> registerItems(output, ModFood.ITEMS))
                    .build());


    public static final RegistryObject<CreativeModeTab> NUKA_WEAPONS = CREATIVE_MODE_TABS.register("nuka_equip",
            () -> builder().icon(() -> new ItemStack(ModWeapons.ROUND10MM.get()))
                    .title(Component.translatable("itemGroup.nuka_equip"))
                    .displayItems(ModItemTabs::getWeaponTab)
                    .build());


    public static final RegistryObject<CreativeModeTab> NUKA_ARMOR = CREATIVE_MODE_TABS.register("nuka_armor",
            () -> builder().icon(() -> new ItemStack(PowerArmorItems.T45_SET.get(PowerArmorPart.HELMET).get()))
                    .title(Component.translatable("itemGroup.nuka_armor"))
                    .displayItems(ModItemTabs::getArmorTab)
                    .build());

    private static void getArmorTab(ItemDisplayParameters itemDisplayParameters, Output output) {
        registerItems(output, PowerArmorItems.ITEMS);
        registerItems(output, ModArmorItems.ITEMS);
    }

    private static void getWeaponTab(ItemDisplayParameters itemDisplayParameters, Output output) {
        registerItems(output, ModWeapons.ITEMS);
        registerItems(output, WeaponAttachments.ITEMS);
    }

//    public static final RegistryObject<CreativeModeTab> POWER_ARMOR = CREATIVE_MODE_TABS.register("power_armor",
//            () -> builder().icon(() -> new ItemStack(PowerArmorItems.T45_SET.get(PowerArmorPart.HELMET).get()))
//                    .title(Component.translatable("itemGroup.power_armor"))
//                    .displayItems((params, output) -> registerItems(output, PowerArmorItems.ITEMS))
//                    .build());

    private static void registerItems(Output output, DeferredRegister<Item> register) {
        for (var entry : register.getEntries()) {
            output.accept(entry.get());
        }
    }

    private static void registerModMaterials(Output output, Class<?> modItemsClass) {
        var fields = modItemsClass.getFields();

        try {
            for (var field : fields) {
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

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}

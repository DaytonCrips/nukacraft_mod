package com.nukateam.nukacraft.common.registery.items;

import com.mojang.datafixers.util.Pair;
import com.jetug.chassis_core.common.data.constants.ChassisPart;
import com.jetug.chassis_core.common.foundation.ChassisArmorMaterial;
import com.jetug.chassis_core.common.foundation.item.ChassisItem;
import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.data.annotation.DataGen;
import com.nukateam.nukacraft.common.data.enums.PowerArmorPart;
import com.nukateam.nukacraft.common.data.utils.PowerArmorStorage;
import com.nukateam.nukacraft.common.foundation.entities.misc.PowerArmorFrame;
import com.nukateam.nukacraft.common.foundation.items.frame.ArmorPart;
import com.nukateam.nukacraft.common.foundation.items.frame.Jetpack;
import com.nukateam.nukacraft.common.registery.EntityTypes;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

import static com.nukateam.nukacraft.common.foundation.materials.PowerArmorMaterials.*;

public class PowerArmorItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NukaCraftMod.MOD_ID);

    @DataGen
    public static final RegistryObject<Item> FRAME_ITEM = ITEMS.register("power_armor_frame", () ->
            new ChassisItem<>(new Item.Properties().fireResistant(), EntityTypes.POWER_ARMOR_FRAME, PowerArmorFrame::new)
    );

    @DataGen
    public static final RegistryObject<Item> JETPACK = ITEMS.register("jetpack", () ->
            new Jetpack(new Item.Properties().fireResistant())
    );

    @DataGen(path = "power_armor/t45")
    public static final PowerArmorStorage T45_SET = registerArmorSet("t45", T45);
    @DataGen(path = "power_armor/t51")
    public static final PowerArmorStorage T51_SET = registerArmorSet("t51", T51);
    @DataGen(path = "power_armor/t60")
    public static final PowerArmorStorage T60_SET = registerArmorSet("t60", T60);
    @DataGen(path = "power_armor/x01")
    public static final PowerArmorStorage X01_SET = registerArmorSet("x01", X01);
    @DataGen(path = "power_armor/x02")
    public static final PowerArmorStorage X02_SET = registerArmorSet("x02", X02);
    @DataGen(path = "power_armor/x02_cryo")
    public static final PowerArmorStorage X02_CRYO_SET = registerArmorSet("x02_cryo", X02_CRYO);
    @DataGen(path = "power_armor/raider")
    public static final PowerArmorStorage RAIDER_SET = registerArmorSet("raider", RAIDER);
    @DataGen(path = "power_armor/excavator")
    public static final PowerArmorStorage EXCAVATOR_SET = registerArmorSet("excavator", EXCAVATOR);

    private static RegistryObject<Item> registerArmor(String name, String slot, ChassisArmorMaterial material) {
        return ITEMS.register(name, () -> new ArmorPart(material, slot));
    }

    private static PowerArmorStorage registerArmorSet(String name, ChassisArmorMaterial material) {
        var armorSet = new PowerArmorStorage();
        var armorSlots = List.of(
                Pair.of(PowerArmorPart.HELMET   , ChassisPart.HELMET          ),
                Pair.of(PowerArmorPart.BODY     , ChassisPart.BODY_ARMOR      ),
                Pair.of(PowerArmorPart.RIGHT_ARM, ChassisPart.RIGHT_ARM_ARMOR ),
                Pair.of(PowerArmorPart.LEFT_ARM , ChassisPart.LEFT_ARM_ARMOR  ),
                Pair.of(PowerArmorPart.RIGHT_LEG, ChassisPart.RIGHT_LEG_ARMOR ),
                Pair.of(PowerArmorPart.LEFT_LEG , ChassisPart.LEFT_LEG_ARMOR  )
        );

        for (var slot : armorSlots) {
            var item = registerArmor(name + "_" + slot.getFirst().getName(), slot.getSecond(), material);
            armorSet.put(slot.getFirst(), item);
        }

        return armorSet;
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

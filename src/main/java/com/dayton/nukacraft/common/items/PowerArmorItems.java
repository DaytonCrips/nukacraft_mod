package com.dayton.nukacraft.common.items;

import com.dayton.nukacraft.NukaCraftMod;
import com.dayton.nukacraft.common.items.custom.armor.ArmorPart;
import com.jetug.chassis_core.common.data.enums.ChassisPart;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.dayton.nukacraft.common.materials.PowerArmorMaterials.*;

public class PowerArmorItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NukaCraftMod.MOD_ID);

    //T45
    public static final RegistryObject<Item> T45_HELMET = ITEMS.register("t45_helmet", () ->
            new ArmorPart(T45, ChassisPart.HELMET));

    public static final RegistryObject<ArmorPart> T45_BODY = ITEMS.register("t45_body", () ->
            new ArmorPart(T45, ChassisPart.BODY_ARMOR));

    public static final RegistryObject<ArmorPart> T45_RIGHT_ARM = ITEMS.register("t45_right_arm", () ->
            new ArmorPart(T45, ChassisPart.RIGHT_ARM_ARMOR));

    public static final RegistryObject<ArmorPart> T45_LEFT_ARM = ITEMS.register("t45_left_arm", () ->
            new ArmorPart(T45, ChassisPart.LEFT_ARM_ARMOR));

    public static final RegistryObject<ArmorPart> T45_RIGHT_LEG = ITEMS.register("t45_right_leg", () ->
            new ArmorPart(T45, ChassisPart.RIGHT_LEG_ARMOR));

    public static final RegistryObject<ArmorPart> T45_LEFT_LEG = ITEMS.register("t45_left_leg", () ->
            new ArmorPart(T45, ChassisPart.LEFT_LEG_ARMOR));

    //T51
    public static final RegistryObject<Item> T51_HELMET = ITEMS.register("t51_helmet", () ->
            new ArmorPart(T51, ChassisPart.HELMET));

    public static final RegistryObject<ArmorPart> T51_BODY = ITEMS.register("t51_body", () ->
            new ArmorPart(T51, ChassisPart.BODY_ARMOR));

    public static final RegistryObject<ArmorPart> T51_RIGHT_ARM = ITEMS.register("t51_right_arm", () ->
            new ArmorPart(T51, ChassisPart.RIGHT_ARM_ARMOR));

    public static final RegistryObject<ArmorPart> T51_LEFT_ARM = ITEMS.register("t51_left_arm", () ->
            new ArmorPart(T51, ChassisPart.LEFT_ARM_ARMOR));

    public static final RegistryObject<ArmorPart> T51_RIGHT_LEG = ITEMS.register("t51_right_leg", () ->
            new ArmorPart(T51, ChassisPart.RIGHT_LEG_ARMOR));

    public static final RegistryObject<ArmorPart> T51_LEFT_LEG = ITEMS.register("t51_left_leg", () ->
            new ArmorPart(T51, ChassisPart.LEFT_LEG_ARMOR));

    public static final RegistryObject<Item> T60_HELMET = ITEMS.register("t60_helmet", () ->
            new ArmorPart(T51, ChassisPart.HELMET));

    //T60
    public static final RegistryObject<ArmorPart> T60_BODY = ITEMS.register("t60_body", () ->
            new ArmorPart(T60, ChassisPart.BODY_ARMOR));

    public static final RegistryObject<ArmorPart> T60_RIGHT_ARM = ITEMS.register("t60_right_arm", () ->
            new ArmorPart(T60, ChassisPart.RIGHT_ARM_ARMOR));

    public static final RegistryObject<ArmorPart> T60_LEFT_ARM = ITEMS.register("t60_left_arm", () ->
            new ArmorPart(T60, ChassisPart.LEFT_ARM_ARMOR));

    public static final RegistryObject<ArmorPart> T60_RIGHT_LEG = ITEMS.register("t60_right_leg", () ->
            new ArmorPart(T60, ChassisPart.RIGHT_LEG_ARMOR));

    public static final RegistryObject<ArmorPart> T60_LEFT_LEG = ITEMS.register("t60_left_leg", () ->
            new ArmorPart(T60, ChassisPart.LEFT_LEG_ARMOR));

    public static final RegistryObject<Item> RAIDER_HELMET = ITEMS.register("raider_helmet", () ->
            new ArmorPart(T60, ChassisPart.HELMET));

    //RAIDER
    public static final RegistryObject<ArmorPart> RAIDER_BODY = ITEMS.register("raider_body", () ->
            new ArmorPart(RAIDER, ChassisPart.BODY_ARMOR));

    public static final RegistryObject<ArmorPart> RAIDER_RIGHT_ARM = ITEMS.register("raider_right_arm", () ->
            new ArmorPart(RAIDER, ChassisPart.RIGHT_ARM_ARMOR));

    public static final RegistryObject<ArmorPart> RAIDER_LEFT_ARM = ITEMS.register("raider_left_arm", () ->
            new ArmorPart(RAIDER, ChassisPart.LEFT_ARM_ARMOR));

    public static final RegistryObject<ArmorPart> RAIDER_RIGHT_LEG = ITEMS.register("raider_right_leg", () ->
            new ArmorPart(RAIDER, ChassisPart.RIGHT_LEG_ARMOR));

    public static final RegistryObject<ArmorPart> RAIDER_LEFT_LEG = ITEMS.register("raider_left_leg", () ->
            new ArmorPart(RAIDER, ChassisPart.LEFT_LEG_ARMOR));

    //EXCAVATOR
    public static final RegistryObject<Item> EXC_HELMET = ITEMS.register("exc_helmet", () ->
            new ArmorPart(EXCAVATOR, ChassisPart.HELMET));

    public static final RegistryObject<ArmorPart> EXC_BODY = ITEMS.register("exc_body", () ->
            new ArmorPart(EXCAVATOR, ChassisPart.BODY_ARMOR));

    public static final RegistryObject<ArmorPart> EXC_RIGHT_ARM = ITEMS.register("exc_right_arm", () ->
            new ArmorPart(EXCAVATOR, ChassisPart.RIGHT_ARM_ARMOR));

    public static final RegistryObject<ArmorPart> EXC_LEFT_ARM = ITEMS.register("exc_left_arm", () ->
            new ArmorPart(EXCAVATOR, ChassisPart.LEFT_ARM_ARMOR));

    public static final RegistryObject<ArmorPart> EXC_RIGHT_LEG = ITEMS.register("exc_right_leg", () ->
            new ArmorPart(EXCAVATOR, ChassisPart.RIGHT_LEG_ARMOR));

    public static final RegistryObject<ArmorPart> EXC_LEFT_LEG = ITEMS.register("exc_left_leg", () ->
            new ArmorPart(EXCAVATOR, ChassisPart.LEFT_LEG_ARMOR));

    public static void register(IEventBus eventBus) { ITEMS.register(eventBus); }
}

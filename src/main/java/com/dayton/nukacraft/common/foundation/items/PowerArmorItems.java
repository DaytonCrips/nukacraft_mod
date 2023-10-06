package com.dayton.nukacraft.common.foundation.items;

import com.dayton.nukacraft.*;
import com.dayton.nukacraft.common.foundation.entities.EntityTypes;
import com.dayton.nukacraft.common.foundation.entities.PowerArmorFrame;
import com.dayton.nukacraft.common.foundation.items.custom.frame.ArmorPart;
import com.dayton.nukacraft.common.foundation.items.custom.frame.Jetpack;
import com.jetug.chassis_core.common.data.constants.ChassisPart;
import com.jetug.chassis_core.common.foundation.item.ChassisItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.dayton.nukacraft.common.foundation.items.ModItemTabs.NUKA_ARMOR;
import static com.dayton.nukacraft.common.foundation.materials.PowerArmorMaterials.*;

public class PowerArmorItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NukaCraftMod.MOD_ID);

    public static final RegistryObject<Item> FRAME_ITEM = ITEMS.register("frame_item",  () ->
        new ChassisItem<>(new Item.Properties().tab(NUKA_ARMOR), EntityTypes.POWER_ARMOR_FRAME, PowerArmorFrame::new)
    );

    public static final RegistryObject<Item> JETPACK = ITEMS.register("jetpack",  () ->
        new Jetpack(new Item.Properties().tab(NUKA_ARMOR))
    );

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

    //T60
    public static final RegistryObject<Item> T60_HELMET = ITEMS.register("t60_helmet", () ->
            new ArmorPart(T60, ChassisPart.HELMET));

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

    //X01
    public static final RegistryObject<Item> X01_HELMET = ITEMS.register("x01_helmet", () ->
            new ArmorPart(X01, ChassisPart.HELMET));

    public static final RegistryObject<ArmorPart> X01_BODY = ITEMS.register("x01_body", () ->
            new ArmorPart(X01, ChassisPart.BODY_ARMOR));

    public static final RegistryObject<ArmorPart> X01_RIGHT_ARM = ITEMS.register("x01_right_arm", () ->
            new ArmorPart(X01, ChassisPart.RIGHT_ARM_ARMOR));

    public static final RegistryObject<ArmorPart> X01_LEFT_ARM = ITEMS.register("x01_left_arm", () ->
            new ArmorPart(X01, ChassisPart.LEFT_ARM_ARMOR));

    public static final RegistryObject<ArmorPart> X01_RIGHT_LEG = ITEMS.register("x01_right_leg", () ->
            new ArmorPart(X01, ChassisPart.RIGHT_LEG_ARMOR));

    public static final RegistryObject<ArmorPart> X01_LEFT_LEG = ITEMS.register("x01_left_leg", () ->
            new ArmorPart(X01, ChassisPart.LEFT_LEG_ARMOR));

    //X02
    public static final RegistryObject<Item> X02_HELMET = ITEMS.register("x02_helmet", () ->
            new ArmorPart(X02, ChassisPart.HELMET));

    public static final RegistryObject<ArmorPart> X02_BODY = ITEMS.register("x02_body", () ->
            new ArmorPart(X02, ChassisPart.BODY_ARMOR));

    public static final RegistryObject<ArmorPart> X02_RIGHT_ARM = ITEMS.register("x02_right_arm", () ->
            new ArmorPart(X02, ChassisPart.RIGHT_ARM_ARMOR));

    public static final RegistryObject<ArmorPart> X02_LEFT_ARM = ITEMS.register("x02_left_arm", () ->
            new ArmorPart(X02, ChassisPart.LEFT_ARM_ARMOR));

    public static final RegistryObject<ArmorPart> X02_RIGHT_LEG = ITEMS.register("x02_right_leg", () ->
            new ArmorPart(X02, ChassisPart.RIGHT_LEG_ARMOR));

    public static final RegistryObject<ArmorPart> X02_LEFT_LEG = ITEMS.register("x02_left_leg", () ->
            new ArmorPart(X02, ChassisPart.LEFT_LEG_ARMOR));

    //X02
    public static final RegistryObject<Item> X02_CRYO_HELMET = ITEMS.register("x02_cryo_helmet", () ->
            new ArmorPart(X02_CRYO, ChassisPart.HELMET));

    public static final RegistryObject<ArmorPart> X02_CRYO_BODY = ITEMS.register("x02_cryo_body", () ->
            new ArmorPart(X02_CRYO, ChassisPart.BODY_ARMOR));

    public static final RegistryObject<ArmorPart> X02_CRYO_RIGHT_ARM = ITEMS.register("x02_cryo_right_arm", () ->
            new ArmorPart(X02_CRYO, ChassisPart.RIGHT_ARM_ARMOR));

    public static final RegistryObject<ArmorPart> X02_CRYO_LEFT_ARM = ITEMS.register("x02_cryo_left_arm", () ->
            new ArmorPart(X02_CRYO, ChassisPart.LEFT_ARM_ARMOR));

    public static final RegistryObject<ArmorPart> X02_CRYO_RIGHT_LEG = ITEMS.register("x02_cryo_right_leg", () ->
            new ArmorPart(X02_CRYO, ChassisPart.RIGHT_LEG_ARMOR));

    public static final RegistryObject<ArmorPart> X02_CRYO_LEFT_LEG = ITEMS.register("x02_cryo_left_leg", () ->
            new ArmorPart(X02_CRYO, ChassisPart.LEFT_LEG_ARMOR));

    //RAIDER
    public static final RegistryObject<Item> RAIDER_HELMET = ITEMS.register("raider_helmet", () ->
            new ArmorPart(RAIDER, ChassisPart.HELMET));

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

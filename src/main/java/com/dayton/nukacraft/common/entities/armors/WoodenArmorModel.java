package com.dayton.nukacraft.common.entities.armors;

import com.dayton.nukacraft.NukaCraftMod;
import com.dayton.nukacraft.common.items.custom.armor.WoodenArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WoodenArmorModel extends AnimatedGeoModel<WoodenArmorItem> {

    @Override
    public ResourceLocation getModelLocation(WoodenArmorItem object) {
        return new ResourceLocation(NukaCraftMod.MOD_ID, "geo/cloths/woodenarmor.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(WoodenArmorItem object) {
        String skin = object.getSkin();
        return switch (skin) {
            case "oak" ->
                    new ResourceLocation(NukaCraftMod.MOD_ID, "textures/models/armor/oak_armor_texture.png");
            case "dark_oak" ->
                    new ResourceLocation(NukaCraftMod.MOD_ID, "textures/models/armor/dark_oak_armor_texture.png");
            case "birch" ->
                    new ResourceLocation(NukaCraftMod.MOD_ID, "textures/models/armor/birch_armor_texture.png");
            case "spruce" ->
                    new ResourceLocation(NukaCraftMod.MOD_ID, "textures/models/armor/spruce_armor_texture.png");
            case "jungle" ->
                    new ResourceLocation(NukaCraftMod.MOD_ID, "textures/models/armor/jungle_armor_texture.png");
            case "acacia" ->
                    new ResourceLocation(NukaCraftMod.MOD_ID, "textures/models/armor/acacia_armor_texture.png");
            case "warped" ->
                    new ResourceLocation(NukaCraftMod.MOD_ID, "textures/models/armor/crimson_armor_texture.png");
            case "crimson" ->
                    new ResourceLocation(NukaCraftMod.MOD_ID, "textures/models/armor/warped_armor_texture.png");
            default ->
                    new ResourceLocation(NukaCraftMod.MOD_ID, "textures/models/armor/oak_armor_texture.png");
        };
    }

    @Override
    public ResourceLocation getAnimationFileLocation(WoodenArmorItem animatable) {
        return new ResourceLocation(NukaCraftMod.MOD_ID, "animations/armor_default_animation.json");
    }
}

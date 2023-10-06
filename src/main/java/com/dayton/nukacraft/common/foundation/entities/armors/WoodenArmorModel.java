package com.dayton.nukacraft.common.foundation.entities.armors;

import com.dayton.nukacraft.common.foundation.items.custom.armor.WoodenArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

import static com.dayton.nukacraft.common.data.utils.Resources.nukaResource;

public class WoodenArmorModel extends AnimatedGeoModel<WoodenArmorItem> {

    @Override
    public ResourceLocation getModelLocation(WoodenArmorItem object) {
        return nukaResource("geo/cloths/woodenarmor.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(WoodenArmorItem object) {
        String skin = object.getSkin();
        return switch (skin) {
            case "dark_oak" ->
                    nukaResource("textures/armor/dark_oak_armor_texture.png");
            case "birch" ->
                    nukaResource("textures/armor/birch_armor_texture.png");
            case "spruce" ->
                    nukaResource("textures/armor/spruce_armor_texture.png");
            case "jungle" ->
                    nukaResource("textures/armor/jungle_armor_texture.png");
            case "acacia" ->
                    nukaResource("textures/armor/acacia_armor_texture.png");
            case "warped" ->
                    nukaResource("textures/armor/crimson_armor_texture.png");
            case "crimson" ->
                    nukaResource("textures/armor/warped_armor_texture.png");
            default ->
                    nukaResource("textures/armor/oak_armor_texture.png");
        };
    }

    @Override
    public ResourceLocation getAnimationFileLocation(WoodenArmorItem animatable) {
        return nukaResource( "animations/armor_default_animation.json");
    }
}

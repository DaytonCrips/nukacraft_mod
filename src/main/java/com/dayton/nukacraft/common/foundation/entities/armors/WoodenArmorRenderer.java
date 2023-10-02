package com.dayton.nukacraft.common.foundation.entities.armors;

import com.dayton.nukacraft.common.foundation.items.custom.armor.WoodenArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class WoodenArmorRenderer extends GeoArmorRenderer<WoodenArmorItem> {
    public WoodenArmorRenderer() {
        super(new WoodenArmorModel());
        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorRightArm";
        this.leftArmBone = "armorLeftArm";
        this.rightLegBone = "armorLeftLeg";
        this.leftLegBone = "armorRightLeg";
        this.rightBootBone = "armorLeftBoot";
        this.leftBootBone = "armorRightBoot";
    }
}

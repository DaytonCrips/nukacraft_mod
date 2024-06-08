package com.nukateam.nukacraft.common.data.enums;

public enum PowerArmorPart {
    HELMET("helmet"),
    BODY("torso"),
    LEFT_ARM("left_arm"),
    RIGHT_ARM("right_arm"),
    LEFT_LEG("left_leg"),
    RIGHT_LEG("right_leg");

    private final String name;

    PowerArmorPart(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

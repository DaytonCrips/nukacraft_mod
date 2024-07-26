package com.nukateam.nukacraft.common.foundation.variants;

import java.util.Arrays;
import java.util.Comparator;

public enum SecuritronVariant {
    MARK1   ("mark1"  , false),
    MARK2   ("mark2"  , true),
    YES_MAN ("yes_man", false),
//    VICTOR  ("victor" , false),
    BERSERK ("berserk", true),
    DAMAGED ("damaged", false);

    private static final SecuritronVariant[] BY_ID = Arrays
            .stream(values())
            .sorted(Comparator.comparingInt(SecuritronVariant::ordinal))
            .toArray(SecuritronVariant[]::new);

    private final String texture;
    private final Boolean isUpgraded;

    SecuritronVariant(String texture, Boolean isUpgraded) {
        this.texture = texture;
        this.isUpgraded = isUpgraded;
    }

    public static SecuritronVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }

    public String getTexture() {
        return texture;
    }

    public Boolean isUpgraded() {
        return isUpgraded;
    }
}

package com.nukateam.nukacraft.common.foundation.variants;

import java.util.Arrays;
import java.util.Comparator;

public enum SecuritronVariant {
    MARK1   ("mark1"  , false, 1.0f),
    MARK2   ("mark2"  , true , 1.0f),
    YES_MAN ("yes_man", false, 1.0f),
    VICTOR  ("victor" , false, 1.0f),
    MUGGY   ("muggy"  , false, 0.4f),
    BERSERK ("berserk", true , 1.5f),
    DAMAGED ("damaged", false, 1.5f);

    private static final SecuritronVariant[] BY_ID = Arrays
            .stream(values())
            .sorted(Comparator.comparingInt(SecuritronVariant::ordinal))
            .toArray(SecuritronVariant[]::new);

    private final String texture;
    private final Boolean isUpgraded;
    private final Float scale;

    SecuritronVariant(String texture, Boolean isUpgraded, Float scale) {
        this.texture = texture;
        this.isUpgraded = isUpgraded;
        this.scale = scale;
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

    public Float getScale() {
        return scale;
    }
}

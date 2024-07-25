package com.nukateam.nukacraft.common.foundation.variants;

import java.util.Arrays;
import java.util.Comparator;

public enum SecuritronVariant {
    MARK1(0, "mark1"),
    MARK2(1, "mark2"),
    YES_MAN(2, "yes_man"),
    VICTOR(3, "victor");

    private static final SecuritronVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.comparingInt(SecuritronVariant::getId)).toArray(SecuritronVariant[]::new);
    private final int id;
    private final String texture;

    SecuritronVariant(int pId, String texture) {
        this.id = pId;
        this.texture = texture;
    }

    public static SecuritronVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }

    public int getId() {
        return this.id;
    }

    public String getTexture() {
        return texture;
    }
}

package com.nukateam.nukacraft.common.foundation.variants;

import java.util.Arrays;
import java.util.Comparator;

public enum DeathclawVariant {
    NORMAL1(0, "deathclaw"),
    NORMAL2(1, "deathclaw2"),
    NORMAL3(2, "deathclaw3");

    private static final DeathclawVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.comparingInt(DeathclawVariant::getId)).toArray(DeathclawVariant[]::new);
    private final int id;
    private final String texture;

    DeathclawVariant(int pId, String texture) {
        this.id = pId;
        this.texture = texture;
    }

    public static DeathclawVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }

    public int getId() {
        return this.id;
    }

    public String getTexture() {
        return texture;
    }
}

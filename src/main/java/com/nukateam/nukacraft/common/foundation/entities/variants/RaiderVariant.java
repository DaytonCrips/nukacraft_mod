package com.nukateam.nukacraft.common.foundation.entities.variants;

import java.util.Arrays;
import java.util.Comparator;

public enum RaiderVariant {
    GHOUL1(0),
    MALE1(1),
    MALE2(2),
    MALE3(3),
    MALE4(4),
    MALE5(5);

    private static final RaiderVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.comparingInt(RaiderVariant::getId)).toArray(RaiderVariant[]::new);
    private final int id;

    RaiderVariant(int pId) {
        this.id = pId;
    }

    public static RaiderVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }

    public int getId() {
        return this.id;
    }
}

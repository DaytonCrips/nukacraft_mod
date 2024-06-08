package com.nukateam.nukacraft.common.data.enums;

public enum ResourceType {
    ITEM("item"),
    BLOCK("block");

    private final String path;

    ResourceType(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
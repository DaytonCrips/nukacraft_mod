package com.nukateam.nukacraft.common.data.annotation;

public enum ItemParent {
    GENERATED("item/generated"),
    HANDHELD("item/handheld"),
    ENTITY("builtin/entity");

    private final String path;

    ItemParent(String path){
        this.path = path;
    }

    public String getPath(){
        return path;
    }
}

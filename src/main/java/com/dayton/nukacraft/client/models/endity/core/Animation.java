package com.dayton.nukacraft.client.models.endity.core;

public class Animation {
    /** @deprecated */
    @Deprecated
    private int id;
    private int duration;

    private Animation(int duration) {
        this.duration = duration;
    }

    /** @deprecated */
    @Deprecated
    public static Animation create(int id, int duration) {
        Animation animation = create(duration);
        animation.id = id;
        return animation;
    }

    public static Animation create(int duration) {
        return new Animation(duration);
    }

    /** @deprecated */
    @Deprecated
    public int getID() {
        return this.id;
    }

    public int getDuration() {
        return this.duration;
    }
}
package com.nukateam.nukacraft.common.data.constants;

public class ExplosionType{
    private float size;
    private int duration;
    private int flashDuration;
    private int tremorDuration;
    private double tremorDistance;
    private double flashDistance;
    private float tremorIntensity;

    public static ExplosionType MINI_NUKE = new ExplosionType()
            .size(1)
            .duration(140)
            .tremorDistance(45)
            .tremorDuration(120)
            .tremorIntensity(1.5f)
            .flashDistance(50)
            .flashDuration(16);


    public ExplosionType size(float size) {
        this.size = size;
        return this;
    }

    public ExplosionType duration(int duration) {
        this.duration = duration;
        return this;
    }

    public ExplosionType tremorDistance(double tremorDistance) {
        this.tremorDistance = tremorDistance;
        return this;
    }

    public ExplosionType tremorIntensity(float tremorIntensity) {
        this.tremorIntensity = tremorIntensity;
        return this;
    }

    public ExplosionType flashDistance(double flashDistance) {
        this.flashDistance = flashDistance;
        return this;
    }

    public ExplosionType flashDuration(int flashDuration) {
        this.flashDuration = flashDuration;
        return this;
    }

    public ExplosionType tremorDuration(int tremorDuration) {
        this.tremorDuration = tremorDuration;
        return this;
    }

    public float size() {
        return size;
    }

    public int getDuration() {
        return duration;
    }

    public double getTremorDistance() {
        return tremorDistance;
    }

    public double getFlashDistance() {
        return flashDistance;
    }

    public float getTremorIntensity() {
        return tremorIntensity;
    }

    public int getFlashDuration() {
        return flashDuration;
    }

    public int getTremorDuration() {
        return tremorDuration;
    }
}

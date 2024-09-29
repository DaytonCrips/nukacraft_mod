package com.nukateam.nukacraft.common.data.utils;

public class MathUtils {
    public static double limit(double value, double min, double max) {
        if (value < min) return min;
        else if (value > max) return max;
        return value;
    }

    public static int round(int i, int j) {
        return i % j == 0 ?
                (i / j) :
                (i / j) + 1;
    }

    public static float smin(float a, float b, float k) {
        float h = Math.max(k - Math.abs(a - b), 0.0F) / k;
        return Math.min(a, b) - h * h * k * (1.0F / 4.0F);
    }

    public static float sampleNoise3D(int x, int y, int z, float simplexSampleRate) {
        return (float) ((ACSimplexNoise.noise(
                (x + simplexSampleRate) / simplexSampleRate,
                (y + simplexSampleRate) / simplexSampleRate,
                (z + simplexSampleRate) / simplexSampleRate))
        );
    }
}

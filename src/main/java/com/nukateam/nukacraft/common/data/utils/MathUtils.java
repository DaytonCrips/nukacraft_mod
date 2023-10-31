package com.nukateam.nukacraft.common.data.utils;

public class MathUtils {
    public static double limit(double value, double min, double max){
        if (value < min) return min;
        else if(value > max) return max;
        return value;
    }
}

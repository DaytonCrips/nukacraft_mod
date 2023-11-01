package com.dayton.nukacraft.common.data.utils;

public class MathUtils {
    public static double limit(double value, double min, double max){
        if (value < min) return min;
        else if(value > max) return max;
        return value;
    }

    public static int round(int i, int j) {
        return i % j == 0 ?
                (i / j) :
                (i / j) + 1;
    }
}

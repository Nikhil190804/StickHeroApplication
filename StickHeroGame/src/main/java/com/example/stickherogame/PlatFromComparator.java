package com.example.stickherogame;

import java.util.Comparator;

public class PlatFromComparator implements Comparator<Platform> {
    @Override
    public int compare(Platform platform, Platform platform2) {
        int intValue = (int) platform.getLayoutX();
        int intValue2 = (int) platform2.getLayoutX();
        return Integer.compare(intValue,intValue2);
    }
}
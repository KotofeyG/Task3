package com.kotov.shape.util;

public class ShapeIdGeneration {
    private static long idCounter;

    public static long generateId() {
        return ++idCounter;
    }
}
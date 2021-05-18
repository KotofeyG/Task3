package com.kotov.shape.entity;

public class Point {
    private double x;
    private double y;
    private double z;

    public Point() {
    }

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }

        Point other = (Point) otherObject;

        if (x != other.x) {
            return false;
        }
        if (y != other.y) {
            return false;
        }
        return z == other.z;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Double.hashCode(x);
        result = prime * result + Double.hashCode(y);
        result = prime * result + Double.hashCode(z);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(getClass().getSimpleName());
        result.append(" [ x = ").append(x);
        result.append(", y = ").append(y);
        result.append(", z = ").append(z);
        result.append(" ]");
        return result.toString();
    }
}
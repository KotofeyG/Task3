package com.kotov.shape.entity;

public class TetrahedronParameter {
    private double volume;
    private double area;
    private double height;
    private double perimeter;

    public TetrahedronParameter() {
    }

    public TetrahedronParameter(double volume, double area, double height, double perimeter) {
        this.volume = volume;
        this.area = area;
        this.height = height;
        this.perimeter = perimeter;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public double getVolume() {
        return volume;
    }

    public double getArea() {
        return area;
    }

    public double getHeight() {
        return height;
    }

    public double getPerimeter() {
        return perimeter;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }

        TetrahedronParameter other = (TetrahedronParameter) otherObject;

        if (volume != other.volume) {
            return false;
        }
        if (area != other.area) {
            return false;
        }
        if (height != other.height) {
            return false;
        }
        return perimeter == other.perimeter;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Double.hashCode(volume);
        result = prime * result + Double.hashCode(area);
        result = prime * result + Double.hashCode(height);
        result = prime * result + Double.hashCode(perimeter);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(getClass().getSimpleName());
        result.append(" [ volume = ").append(volume);
        result.append(", area = ").append(area);
        result.append(", height = ").append(height);
        result.append(", perimeter = ").append(perimeter);
        result.append(" ]");
        return result.toString();
    }
}
package com.epam.jwd.task1.entity;

public abstract class RollingStock {
    private int number;
    private double length;
    private double width;
    private double height;
    private double weight;

    public RollingStock() {

    }

    public RollingStock(int number, double length, double width, double height, double weight) {
        this.number = number;
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RollingStock that = (RollingStock) o;

        if (number != that.number) return false;
        if (Double.compare(that.length, length) != 0) return false;
        if (Double.compare(that.width, width) != 0) return false;
        if (Double.compare(that.height, height) != 0) return false;
        return Double.compare(that.weight, weight) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = number;
        temp = Double.doubleToLongBits(length);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(width);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " {" +
                "number=" + number +
                ", length=" + length +
                ", width=" + width +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}

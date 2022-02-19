package com.epam.jwd.task1.entity;

public class Locomotive extends RollingStock {
    private PowerType powerType;
    private int powerOutput;
    private int maxSpeed;

    public Locomotive() {

    }

    public Locomotive(int number, double length, double width, double height, double weight, PowerType powerType,
                      int powerOutput, int maxSpeed) {
        super(number, length, width, height, weight);
        this.powerType = powerType;
        this.powerOutput = powerOutput;
        this.maxSpeed = maxSpeed;
    }

    public PowerType getPowerType() {
        return powerType;
    }

    public void setPowerType(PowerType powerType) {
        this.powerType = powerType;
    }

    public int getPowerOutput() {
        return powerOutput;
    }

    public void setPowerOutput(int powerOutput) {
        this.powerOutput = powerOutput;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Locomotive that = (Locomotive) o;

        if (powerOutput != that.powerOutput) return false;
        if (maxSpeed != that.maxSpeed) return false;
        return powerType == that.powerType;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (powerType != null ? powerType.hashCode() : 0);
        result = 31 * result + powerOutput;
        result = 31 * result + maxSpeed;
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " {" +
                "powerType=" + powerType +
                ", powerOutput=" + powerOutput +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}

package com.epam.jwd.task1.entity;

public class PassengerWagon extends RollingStock {
    private ComfortType comfortType;
    private int numOfPassengers;
    private double weightOfLuggage;

    public PassengerWagon() {

    }

    public PassengerWagon(int number, double length, double width, double height, double weight, ComfortType comfortType,
                          int numOfPassengers, double weightOfLuggage) {
        super(number, length, width, height, weight);
        this.comfortType = comfortType;
        this.numOfPassengers = numOfPassengers;
        this.weightOfLuggage = weightOfLuggage;
    }

    public ComfortType getComfortType() {
        return comfortType;
    }

    public void setComfortType(ComfortType comfortType) {
        this.comfortType = comfortType;
    }

    public int getNumOfPassengers() {
        return numOfPassengers;
    }

    public void setNumOfPassengers(int numOfPassengers) {
        this.numOfPassengers = numOfPassengers;
    }

    public double getWeightOfLuggage() {
        return weightOfLuggage;
    }

    public void setWeightOfLuggage(double weightOfLuggage) {
        this.weightOfLuggage = weightOfLuggage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        PassengerWagon that = (PassengerWagon) o;

        if (numOfPassengers != that.numOfPassengers) return false;
        if (Double.compare(that.weightOfLuggage, weightOfLuggage) != 0) return false;
        return comfortType == that.comfortType;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + (comfortType != null ? comfortType.hashCode() : 0);
        result = 31 * result + numOfPassengers;
        temp = Double.doubleToLongBits(weightOfLuggage);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " {" +
                "comfortType=" + comfortType +
                ", numOfPassengers=" + numOfPassengers +
                ", weightOfLuggage=" + weightOfLuggage +
                '}';
    }
}

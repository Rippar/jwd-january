package com.epam.jwd.task1.entity;

import java.util.List;

public class Train {
    private int number;
    private String destinationTo;
    private String destinationFrom;
    private List<RollingStock> rollingStockList;

    public Train() {

    }

    public Train(int number, String destinationTo, String destinationFrom, List<RollingStock> rollingStockList) {
        this.number = number;
        this.destinationTo = destinationTo;
        this.destinationFrom = destinationFrom;
        this.rollingStockList = rollingStockList;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDestinationTo() {
        return destinationTo;
    }

    public void setDestinationTo(String destinationTo) {
        this.destinationTo = destinationTo;
    }

    public String getDestinationFrom() {
        return destinationFrom;
    }

    public void setDestinationFrom(String destinationFrom) {
        this.destinationFrom = destinationFrom;
    }

    public List<RollingStock> getRollingStockList() {
        return rollingStockList;
    }

    public void setRollingStockList(List<RollingStock> rollingStockList) {
        this.rollingStockList = rollingStockList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Train train = (Train) o;

        if (number != train.number) return false;
        if (destinationTo != null ? !destinationTo.equals(train.destinationTo) : train.destinationTo != null)
            return false;
        if (destinationFrom != null ? !destinationFrom.equals(train.destinationFrom) : train.destinationFrom != null)
            return false;
        return rollingStockList != null ? rollingStockList.equals(train.rollingStockList) : train.rollingStockList == null;
    }

    @Override
    public int hashCode() {
        int result = number;
        result = 31 * result + (destinationTo != null ? destinationTo.hashCode() : 0);
        result = 31 * result + (destinationFrom != null ? destinationFrom.hashCode() : 0);
        result = 31 * result + (rollingStockList != null ? rollingStockList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " {" +
                "number=" + number +
                ", destinationTo='" + destinationTo + '\'' +
                ", destinationFrom='" + destinationFrom + '\'' +
                ", rollingStockList=" + rollingStockList +
                '}';
    }
}

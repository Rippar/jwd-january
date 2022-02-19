package com.epam.jwd.task1.view;

import com.epam.jwd.task1.entity.PassengerWagon;

import java.util.List;

/**
 * The presentation class with the methods used to display different data
 *
 * @author Dmitry Murzo
 */
public class RollingStockView {
    /**
     * Print the given argument to the console
     */
    public void printInfoToConsole(int n) {
        System.out.println(n);
    }

    /**
     * Print the given argument to the console
     */
    public void printInfoToConsole(double d) {
        System.out.println(d);
    }

    /**
     * Print the given argument to the console
     */
    public void printInfoToConsole(String s) {
        System.out.println(s);
    }

    /**
     * Print the given list of passenger wagons to the console
     */
    public void printPassengerWagonsToConsole(List<PassengerWagon> passengerWagonList) {
        for (PassengerWagon wagon : passengerWagonList) {
            StringBuilder str = new StringBuilder();
            str.append("Number of wagon: ");
            str.append(wagon.getNumber());
            str.append("; Comfort type: ");
            str.append(wagon.getComfortType());
            System.out.println(str);
        }
    }
}

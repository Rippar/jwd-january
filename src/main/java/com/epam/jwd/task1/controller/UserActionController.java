package com.epam.jwd.task1.controller;

import com.epam.jwd.task1.entity.PassengerWagon;
import com.epam.jwd.task1.entity.Train;
import com.epam.jwd.task1.logic.RollingStockLogic;
import com.epam.jwd.task1.view.RollingStockView;

import java.util.List;

/**
 * The class that defines the set of user's action
 *
 * @author Dmitry Murzo
 */
public class UserActionController {

    //The logic used for the operations on RollingStock type objects
    private RollingStockLogic logic = new RollingStockLogic();

    //The view used to display different data
    private RollingStockView view = new RollingStockView();

    /**
     * User's action to print the info about the number of passengers in passenger wagons to the console
     */
    public void getNumOfPassengers() {
        Train train = logic.getTrainFromSource();
        int numOfPassengers = logic.countPassengers(train);
        view.printInfoToConsole("Total number of passengers, pers.:");
        view.printInfoToConsole(numOfPassengers);

    }

    /**
     * User's action to print the info about the weight of luggage in passenger wagons to the console
     */
    public void getWeightOfLuggage() {
        Train train = logic.getTrainFromSource();
        double weightOfLuggage = logic.countLuggage(train);
        view.printInfoToConsole("Total amount of luggage, kg.:");
        view.printInfoToConsole(weightOfLuggage);
    }

    /**
     * User's action to print the info about passenger wagons sorted by ComfortType in ascending order to the console
     */
    public void getWagonsSortedByComfort() {
        Train train = logic.getTrainFromSource();
        List<PassengerWagon> passengerWagonList = logic.getSortedWagonsByComfort(train);
        view.printInfoToConsole("Sorting passenger wagons by comfort:");
        view.printPassengerWagonsToConsole(passengerWagonList);
    }

    /**
     * User's action to print the info about passenger wagons selected by a given range of number of passengers
     * to the console
     */
    public void getWagonsByNumOfPassengers(int min, int max) {
        Train train = logic.getTrainFromSource();
        List<PassengerWagon> passengerWagonList = logic.getWagonsByNumOfPassengers(min, max, train);
        view.printInfoToConsole("Found wagons by a given range of passengers:");
        view.printPassengerWagonsToConsole(passengerWagonList);
    }
}

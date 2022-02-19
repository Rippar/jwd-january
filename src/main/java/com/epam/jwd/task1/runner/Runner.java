package com.epam.jwd.task1.runner;

import com.epam.jwd.task1.controller.UserActionController;

public class Runner {
    public static void main(String[] args) {
        UserActionController controller = new UserActionController();
        controller.getNumOfPassengers();
        controller.getWeightOfLuggage();
        controller.getWagonsSortedByComfort();
        controller.getWagonsByNumOfPassengers(36, 51);
    }
}

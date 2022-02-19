package com.epam.jwd.task1.logic;

import com.epam.jwd.task1.entity.PassengerWagon;
import com.epam.jwd.task1.entity.RollingStock;
import com.epam.jwd.task1.entity.Train;
import com.epam.jwd.task1.source.TrainSource;

import java.util.ArrayList;
import java.util.List;


/**
 * The class that defines the methods used for the operations on RollingStock type objects
 *
 * @author Dmitry Murzo
 */
public class RollingStockLogic {

    /**
     * Returns the number of passengers in passenger wagons of the train
     *
     * @param train a Train object
     * @return int value of number of passengers
     */
    public int countPassengers(Train train) {
        List<RollingStock> rollingStockList = train.getRollingStockList();
        int numOfPassengers = 0;
        for (RollingStock rollingStock : rollingStockList) {
            if (rollingStock.getClass() == PassengerWagon.class) {
                numOfPassengers = numOfPassengers + ((PassengerWagon) rollingStock).getNumOfPassengers();
            }
        }

        return numOfPassengers;
    }

    /**
     * Returns the weight of luggage in passenger wagons
     *
     * @param train a Train object
     * @return double value of the weight of luggage
     */
    public double countLuggage(Train train) {
        List<RollingStock> rollingStockList = train.getRollingStockList();
        double weightOfLuggage = 0.0;
        for (RollingStock rollingStock : rollingStockList) {
            if (rollingStock.getClass() == PassengerWagon.class) {
                weightOfLuggage = weightOfLuggage + ((PassengerWagon) rollingStock).getWeightOfLuggage();
            }
        }

        return weightOfLuggage;
    }

    /**
     * Returns a list of passenger wagons for a given range of number of passengers
     *
     * @param min   a minimum number of passengers to form a sample
     * @param max   a maximum number of passengers to form a sample
     * @param train a Train object
     * @return a list of passenger wagons for a given range
     */
    public List<PassengerWagon> getWagonsByNumOfPassengers(int min, int max, Train train) {
        List<RollingStock> rollingStockList = train.getRollingStockList();
        List<PassengerWagon> wagons = new ArrayList<>();

        for (RollingStock rollingStock : rollingStockList) {
            if (rollingStock.getClass() == PassengerWagon.class) {
                if (((PassengerWagon) rollingStock).getNumOfPassengers() >= min
                        && ((PassengerWagon) rollingStock).getNumOfPassengers() <= max) {
                    wagons.add((PassengerWagon) rollingStock);

                }
            }
        }

        return wagons;
    }

    /**
     * Returns a list of passenger wagons sorted by ComfortType in ascending order
     *
     * @param train a Train object
     * @return a list of passenger wagons sorted by ComfortType in ascending order
     * @see WagonComparator
     */
    public List<PassengerWagon> getSortedWagonsByComfort(Train train) {
        List<RollingStock> rollingStockList = train.getRollingStockList();
        List<PassengerWagon> wagons = new ArrayList<>();
        WagonComparator wagonComparator = new WagonComparator();

        for (RollingStock rollingStock : rollingStockList) {
            if (rollingStock.getClass() == PassengerWagon.class) {
                wagons.add((PassengerWagon) rollingStock);
            }
        }

        wagons.sort(wagonComparator);

        return wagons;
    }

    /**
     * Return a Train object from source
     *
     * @return a Train object
     * @see TrainSource
     */
    public Train getTrainFromSource() {
        TrainSource source = new TrainSource();
        return source.getTrain();
    }


}

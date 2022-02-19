package com.epam.jwd.task1.logic;

import com.epam.jwd.task1.entity.ComfortType;
import com.epam.jwd.task1.entity.PassengerWagon;

import java.util.Comparator;
import java.util.Map;

/**
 * The class which extends Comparator and override the compare method
 * according to the spec of the task
 *
 * @author Dmitry Murzo
 * @see Comparator
 */
public class WagonComparator implements Comparator<PassengerWagon> {

    /**
     * Returns the int result of comparing two wagons by ComfortType in ascending order
     *
     * @param o1 a PassengerWagon object
     * @param o2 a PassengerWagon object
     * @return the int result of comparing two wagons by ComfortType in ascending order
     * @see ComfortType
     */
    @Override
    public int compare(PassengerWagon o1, PassengerWagon o2) {
        ComfortType comfortType1 = o1.getComfortType();
        ComfortType comfortType2 = o2.getComfortType();

        Map<ComfortType, Integer> comfortTypeMap = Map.of(
                ComfortType.SLEEPING, 4,
                ComfortType.CORRIDOR, 3,
                ComfortType.COUCHETTE, 2,
                ComfortType.OPENTYPE, 1
        );

        return comfortTypeMap.get(comfortType1) - comfortTypeMap.get(comfortType2);

    }
}

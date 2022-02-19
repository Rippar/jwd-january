package com.epam.jwd.task1.source;

import com.epam.jwd.task1.entity.ComfortType;
import com.epam.jwd.task1.entity.Locomotive;
import com.epam.jwd.task1.entity.PassengerWagon;
import com.epam.jwd.task1.entity.PowerType;
import com.epam.jwd.task1.entity.RollingStock;
import com.epam.jwd.task1.entity.Train;

import java.util.Arrays;
import java.util.List;

/**
 * The class that defines fields and a method for creating a Train object
 *
 * @author Dmitry Murzo
 */
public class TrainSource {
    private Locomotive locomotive = new Locomotive(0, 17220.0, 3120.0, 4637.0, 123000.0, PowerType.DIESEL, 1350, 120);
    private PassengerWagon wagon1 = new PassengerWagon(1, 25000.0, 4200.0, 3500.2, 7400.0, ComfortType.COUCHETTE, 54, 1134.0);
    private PassengerWagon wagon2 = new PassengerWagon(2, 25000.0, 4200.0, 3500.2, 7400.0, ComfortType.COUCHETTE, 45, 945.0);
    private PassengerWagon wagon3 = new PassengerWagon(3, 25000.0, 4200.0, 3500.2, 6800.0, ComfortType.CORRIDOR, 36, 756.0);
    private PassengerWagon wagon4 = new PassengerWagon(4, 25000.0, 4200.0, 3500.2, 6800.0, ComfortType.CORRIDOR, 36, 756.0);
    private PassengerWagon wagon5 = new PassengerWagon(5, 24500.0, 4080.0, 3300.0, 6500.0, ComfortType.SLEEPING, 18, 378.0);
    private PassengerWagon wagon6 = new PassengerWagon(6, 25000.0, 4200.0, 3500.2, 7700.0, ComfortType.OPENTYPE, 63, 693.0);

    /**
     * Returns the created Train object with determined rolling stocks params
     *
     * @return Train object
     */
    public Train getTrain() {
        List<RollingStock> rollingStockList = Arrays.asList(locomotive, wagon1, wagon2, wagon3, wagon4, wagon5, wagon6);
        Train train = new Train(333, "Moscow", "Minsk", rollingStockList);
        return train;
    }


}

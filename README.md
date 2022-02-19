# jwd-january

Here is a rolling stock hierarchy.

We have an abstract class RollingScock, which declares the fiels 
common to all rolling stock entities, such as number, length, width,
height and weight.

According to the spec of the task, i've decided to create two
subclasses of the RollingStock class: it is Locomotive class and 
PassengerWagon class, which have their own fields complement to the
fields of RollingStock class.

Locomotive has its own powerType, powerOutput and maxSpeed fields.
PassengerWagon has its own comfortType, numOfPassengers and weightOfLuggage fields.

I didn't create an "intermediate" class Wagon between RollingStock and 
PassengerWagon because I cannot single out any abstract things that would be 
equally relevant for both a passenger wagon and f.e. a freight wagon. 
These abstract things are relevant for any type of rolling stock.

Thanks for reviewing my code.
package com.epam.jwd.task2.logic;

/**
 * The class LogicException is used to wrap an Exception object that can be thrown at a logic layer
 *
 * @author Dmitry Murzo
 */
public class LogicException extends Exception {

    public LogicException() {
        super();
    }

    public LogicException(String message) {
        super(message);
    }

    public LogicException(Exception e) {
        super(e);
    }

    public LogicException(String message, Exception e) {
        super(message, e);
    }
}

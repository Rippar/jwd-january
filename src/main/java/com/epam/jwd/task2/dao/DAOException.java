package com.epam.jwd.task2.dao;

/**
 * The class DAOException is used to wrap an Exception object that can be thrown at a dao layer
 *
 * @author Dmitry Murzo
 */
public class DAOException extends Exception {

    public DAOException() {
        super();
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(Exception e) {
        super(e);
    }

    public DAOException(String message, Exception e) {
        super(message, e);
    }
}

package com.epam.jwd.task2.controller;

/**
 * The controller interface defines a method which get a request in a string format and returns the result in a
 * string format.
 *
 * @author Dmitry Murzo
 */
public interface Controller {

    /**
     * The method which get a request in a string format and returns the result in a string format
     *
     * @param request is a string request received by user's input
     * @return string representation of the result of received request
     */
    String doAction(String request);

}
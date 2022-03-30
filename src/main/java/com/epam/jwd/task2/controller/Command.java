package com.epam.jwd.task2.controller;

/**
 * The Command interface defines a method which execute the required command according to the given list of parameters
 *
 * @author Dmitry Murzo
 */
public interface Command {

    /**
     * The method which get a list of string parameters and returns the string result of executing command
     * according to this parameters
     *
     * @param params a list of string parameters based on user's input
     * @return string representation of executing command
     */
    String execute(String[] params);

}
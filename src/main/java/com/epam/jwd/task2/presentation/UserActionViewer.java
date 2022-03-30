package com.epam.jwd.task2.presentation;

/**
 * The UserActionViewer class with the methods used to display different data
 *
 * @author Dmitry Murzo
 */
public class UserActionViewer {

    /**
     * String constant of the success message
     */
    public static final String SUCCESS_MESSAGE = "Success";

    /**
     * String constant of the error message
     */
    public static final String ERROR_MESSAGE = "Error";

    /**
     * Return the String answer according to the boolean result
     *
     * @param result is a boolean result of some action
     * @return String answer according to param
     */
    public static String saveTextAnswer(boolean result) {
        if (result) {
            return SUCCESS_MESSAGE;
        } else {
            return ERROR_MESSAGE;
        }

    }

}

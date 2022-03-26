package com.epam.jwd.task2.presentation;

public class UserActionViewer {
    public static final String SUCCESS_MESSAGE = "Success";
    public static final String ERROR_MESSAGE = "Error";

    public static String saveTextAnswer(boolean result) {
        if(result) {
            return "save success";
        } else {
            return "save failure";
        }

    }

}

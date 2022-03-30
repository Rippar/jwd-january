package com.epam.jwd.task2.runner;

import java.util.Scanner;

/**
 * The class is used to process user's input
 *
 * @author Dmitry Murzo
 */
public class UserDataInput {

    /**
     * The method "asks" for user's input and allows to print the message to the console while asking for input
     *
     * @param message is a message print to the console along with the method operation
     * @return the user's input
     */
    public String enterFromConsole(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        return sc.nextLine();
    }
}

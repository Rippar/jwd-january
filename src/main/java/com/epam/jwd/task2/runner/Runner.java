package com.epam.jwd.task2.runner;

import com.epam.jwd.task2.controller.Controller;
import com.epam.jwd.task2.controller.impl.UserController;

public class Runner {
    public static void main(String[] args) {
        Controller controller = new UserController();
        UserDataInput input = new UserDataInput();

        while (true) {
            String request = input.enterFromConsole("Please enter \"change\" in order to change the first and the last word of " +
                    "each sentence of the text" +
                    "\nPlease enter \"remove\" and integer value of length in order to remove the words of current " +
                    "length starts with consonant from the text" +
                    "\nPlease enter \"sort\" in order to sort the words of the sentences in ascending proportion of vowels" +
                    "\nPlease enter \"save\" in order to save the text and its changes to the file" +
                    "\nPlease enter \"esc\" to stop the program\n>>");
            if (request.equals("esc")) {
                break;
            } else {
                String response = controller.doAction(request);
                System.out.println(response);

            }
        }


    }
}

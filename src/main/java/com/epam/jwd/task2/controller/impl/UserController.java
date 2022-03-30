package com.epam.jwd.task2.controller.impl;

import com.epam.jwd.task2.controller.Command;
import com.epam.jwd.task2.controller.CommandProvider;
import com.epam.jwd.task2.controller.Controller;
import com.epam.jwd.task2.presentation.UserActionViewer;

/**
 * The UserController class implements the method which get a request in a string format and returns the result in a
 * string format.
 *
 * @author Dmitry Murzo
 */
public class UserController implements Controller {

    /**
     * Constant COMMAND_DELIMITER is used to split the user's input into the list of string parameters
     */
    public static String COMMAND_DELIMITER = "\\s+";

    /**
     * CommandProvider is used to get the specific {@code Command} object according to user's input
     */
    private CommandProvider provider = new CommandProvider();

    /**
     * The method which get a request in a string format, split it to the list of parameters, get the specific command
     * using the first parameter of the split request, execute this command and returns the result in a string format.
     *
     * @param request is a string request received by user's input
     * @return string representation of the result of received request
     */
    @Override
    public String doAction(String request) {

        String[] params = request.split(COMMAND_DELIMITER);
        String commandName = params[0];
        Command currentCommand = provider.getCommand(commandName);
        if (currentCommand != null) {
            String response = currentCommand.execute(params);
            return response;
        } else {
            return UserActionViewer.ERROR_MESSAGE;
        }

    }
}

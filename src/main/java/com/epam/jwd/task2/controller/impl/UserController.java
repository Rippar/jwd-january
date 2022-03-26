package com.epam.jwd.task2.controller.impl;

import com.epam.jwd.task2.controller.Command;
import com.epam.jwd.task2.controller.CommandProvider;
import com.epam.jwd.task2.controller.Controller;
import com.epam.jwd.task2.presentation.UserActionViewer;

public class UserController implements Controller {

    public static String COMMAND_DELIMETR = "\\s+";
    private CommandProvider provider = new CommandProvider();

    @Override
    public String doAction(String request) {

        String[] params = request.split(COMMAND_DELIMETR);
        String commandName = params[0];
        Command currentCommand = provider.getCommand(commandName);
        if (currentCommand!= null) {
            String response = currentCommand.execute(params);
            return response;
        } else {
            return UserActionViewer.ERROR_MESSAGE;
        }

    }
}

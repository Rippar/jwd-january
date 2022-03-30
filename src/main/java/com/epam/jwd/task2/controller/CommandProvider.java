package com.epam.jwd.task2.controller;

import com.epam.jwd.task2.controller.impl.RemoveWordOfGivenLengthCommand;
import com.epam.jwd.task2.controller.impl.SaveTheTextToFileCommand;
import com.epam.jwd.task2.controller.impl.SortWordsByVowelCommand;
import com.epam.jwd.task2.controller.impl.SwapFirstLastWordCommand;

import java.util.HashMap;
import java.util.Map;

/**
 * The class that contains the collection of available Command objects and allows to receive them
 *
 * @author Dmitry Murzo
 */
public class CommandProvider {

    /**
     * Map is used to store and receive the Command objects by String key (the name of command)
     */
    private Map<String, Command> commands = new HashMap<>();

    public CommandProvider() {
        commands.put("swap", new SwapFirstLastWordCommand());
        commands.put("remove", new RemoveWordOfGivenLengthCommand());
        commands.put("sort", new SortWordsByVowelCommand());
        commands.put("save", new SaveTheTextToFileCommand());
    }

    /**
     * Getter method is used to receive the Command object by the name of this command
     *
     * @param commandName is the String key associated with specific Command object in the map
     * @return Command object
     */
    public Command getCommand(String commandName) {
        Command command;
        command = commands.get(commandName);
        return command;
    }
}

package com.epam.jwd.task2.controller;

import com.epam.jwd.task2.controller.impl.ChangeFirstLastWordCommand;
import com.epam.jwd.task2.controller.impl.RemoveWordOfGivenLengthCommand;
import com.epam.jwd.task2.controller.impl.SaveTheTextToFileCommand;
import com.epam.jwd.task2.controller.impl.SortWordsByVowelCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private Map<String, Command> commands = new HashMap<>();

    public CommandProvider() {
        commands.put("change", new ChangeFirstLastWordCommand());
        commands.put("remove", new RemoveWordOfGivenLengthCommand());
        commands.put("sort", new SortWordsByVowelCommand());
        commands.put("save", new SaveTheTextToFileCommand());
    }

    public Command getCommand(String commandName) {
        Command command;
        command = commands.get(commandName);
        return command;
    }
}

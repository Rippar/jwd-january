package com.epam.jwd.task2.controller;

import com.epam.jwd.task2.parsing.ParsingException;

public interface Command {
    String execute(String[] params);

}
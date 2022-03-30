package com.epam.jwd.task2.controller.impl;

import com.epam.jwd.task2.controller.Command;
import com.epam.jwd.task2.entity.Text;
import com.epam.jwd.task2.logic.LogicProvider;
import com.epam.jwd.task2.logic.TextLogic;
import com.epam.jwd.task2.parsing.ParsingException;
import com.epam.jwd.task2.parsing.ParsingProvider;
import com.epam.jwd.task2.parsing.TextParser;
import com.epam.jwd.task2.presentation.UserActionViewer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class that implements the remove command for the words of given length starts with consonant in each sentence
 * of {@code Text} object
 */
public class RemoveWordOfGivenLengthCommand implements Command {

    /**
     * Logger is used to log error messages for the executing of current command
     */
    private static final Logger logger = LogManager.getLogger(RemoveWordOfGivenLengthCommand.class);

    /**
     * The method which get a list of string parameters and returns the string result of executing the remove command
     * for the words of given length starts with consonant in each sentence of {@code Text} object. Using the specific
     * TextLogic and TextParser objects for executing this command.
     *
     * @param params a list of string parameters based on user's input
     * @return string representation of executing command
     */
    @Override
    public String execute(String[] params) {
        LogicProvider logicProvider = LogicProvider.getInstance();
        ParsingProvider parsingProvider = ParsingProvider.getInstance();
        TextParser parser = parsingProvider.getTextParser();
        Text text = null;

        try {
            text = parser.parseTheText();
            if (params.length > 1) {
                int wordLength = Integer.parseInt(params[1]);
                TextLogic textLogic = logicProvider.getTextLogic();
                textLogic.removeWordsOfGivenLengthStartsWithConsonant(text, wordLength);
                return UserActionViewer.SUCCESS_MESSAGE;
            } else {
                return UserActionViewer.ERROR_MESSAGE;
            }


        } catch (ParsingException | NumberFormatException e) {
            logger.error(e);
            return UserActionViewer.ERROR_MESSAGE;

        }
    }
}

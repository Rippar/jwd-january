package com.epam.jwd.task2.controller.impl;

import com.epam.jwd.task2.controller.Command;
import com.epam.jwd.task2.entity.Text;
import com.epam.jwd.task2.logic.LogicException;
import com.epam.jwd.task2.logic.LogicProvider;
import com.epam.jwd.task2.logic.TextLogic;
import com.epam.jwd.task2.parsing.ParsingException;
import com.epam.jwd.task2.parsing.ParsingProvider;
import com.epam.jwd.task2.parsing.TextParser;
import com.epam.jwd.task2.presentation.UserActionViewer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class that implements the save command for the current state of {@code Text} object in string form to the file
 */
public class SaveTheTextToFileCommand implements Command {

    /**
     * Logger is used to log error messages for the executing of current command
     */
    private static final Logger logger = LogManager.getLogger(SaveTheTextToFileCommand.class);

    /**
     * The method which get a list of string parameters and returns the string result of executing the save command
     * for the current state of {@code Text} object in string form to the file. Using the specific TextLogic and
     * TextParser objects for executing this command.
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
        boolean result = false;

        try {
            text = parser.parseTheText();
            TextLogic textLogic = logicProvider.getTextLogic();
            result = textLogic.saveTheTextToFile(text);
            return UserActionViewer.saveTextAnswer(result);
        } catch (ParsingException | LogicException e) {
            logger.error(e);
            return UserActionViewer.ERROR_MESSAGE;
        }

    }
}

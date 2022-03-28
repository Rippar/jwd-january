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

public class SortWordsByVowelCommand implements Command {

    private static final Logger logger = LogManager.getLogger(SortWordsByVowelCommand.class);

    @Override
    public String execute(String[] params) {
        LogicProvider logicProvider = LogicProvider.getInstance();
        ParsingProvider parsingProvider = ParsingProvider.getInstance();
        TextParser parser = parsingProvider.getTextParser();
        Text text = null;

        try {
            text = parser.parseTheText();
            TextLogic textLogic = logicProvider.getTextLogic();
            textLogic.sortWordsByVowelFraction(text);
            return UserActionViewer.SUCCESS_MESSAGE;
        } catch (ParsingException e) {
            logger.error(e);
            return UserActionViewer.ERROR_MESSAGE;
        }
    }
}

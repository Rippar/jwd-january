package com.epam.jwd.task2.controller.impl;

import com.epam.jwd.task2.controller.Command;
import com.epam.jwd.task2.dao.DAOException;
import com.epam.jwd.task2.entity.Text;
import com.epam.jwd.task2.logic.LogicProvider;
import com.epam.jwd.task2.logic.TextLogic;
import com.epam.jwd.task2.parsing.ParsingException;
import com.epam.jwd.task2.parsing.ParsingProvider;
import com.epam.jwd.task2.parsing.TextParser;
import com.epam.jwd.task2.presentation.UserActionViewer;

public class SaveTheTextToFileCommand implements Command {

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
        } catch (ParsingException | DAOException e) {
            // logging(e)
            return UserActionViewer.ERROR_MESSAGE;
        }

    }
}

package com.epam.jwd.task2.parsing;

import com.epam.jwd.task2.parsing.impl.TextParserImpl;

/**
 * The class which uses singleton pattern to control the number of parser objects created and also make it possible to
 * change the implementation of the TextParser interface if necessary
 *
 * @author Dmitry Murzo
 */
public class ParsingProvider {

    private static final ParsingProvider instance = new ParsingProvider();

    private TextParser textParser = new TextParserImpl();

    private ParsingProvider() {

    }

    public static ParsingProvider getInstance() {
        return instance;
    }

    public TextParser getTextParser() {
        return textParser;
    }

    public void setTextParser(TextParser textParser) {
        this.textParser = textParser;
    }
}

package com.epam.jwd.task2.parsing;

import com.epam.jwd.task2.parsing.impl.TextParserImpl;

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

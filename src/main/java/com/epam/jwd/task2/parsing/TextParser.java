package com.epam.jwd.task2.parsing;

import com.epam.jwd.task2.entity.Text;

/**
 * The TextParser interface defines a method to parse the text elements from source and returns a Text object
 *
 * @author Dmitry Murzo
 */
public interface TextParser {

    /**
     * The method which parse the text info from source and returns a Text object
     *
     * @return {@code Text} object
     * @throws ParsingException if can't get parsing info from source
     */
    Text parseTheText() throws ParsingException;
}

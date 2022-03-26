package com.epam.jwd.task2.parsing;

import com.epam.jwd.task2.entity.Text;


public interface TextParser {

    Text parseTheText() throws ParsingException;
}

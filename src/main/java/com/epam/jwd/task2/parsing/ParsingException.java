package com.epam.jwd.task2.parsing;

public class ParsingException extends Exception {

    public ParsingException() {
        super();
    }

    public ParsingException(String message) {
        super(message);
    }

    public ParsingException(Exception e) {
        super(e);
    }

    public ParsingException(String message, Exception e) {
        super(message, e);
    }
}

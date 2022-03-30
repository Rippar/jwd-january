package com.epam.jwd.task2.parsing;

/**
 * The class ParsingException is used to wrap an Exception object that can be thrown at a parsing layer
 *
 * @author Dmitry Murzo
 */
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

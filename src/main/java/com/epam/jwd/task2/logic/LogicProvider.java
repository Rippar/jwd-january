package com.epam.jwd.task2.logic;

import com.epam.jwd.task2.logic.impl.TextLogicImpl;

/**
 * The class which uses singleton pattern to control the number of logic objects created and also make it possible to
 * change the implementation of the TextLogic interface if necessary
 *
 * @author Dmitry Murzo
 */
public class LogicProvider {

    private static LogicProvider instance = new LogicProvider();
    private TextLogic textLogic = new TextLogicImpl();

    private LogicProvider() {

    }

    public static LogicProvider getInstance() {
        return instance;
    }

    public static void setInstance(LogicProvider instance) {
        LogicProvider.instance = instance;
    }

    public TextLogic getTextLogic() {
        return textLogic;
    }

    public void setTextLogic(TextLogic textLogic) {
        this.textLogic = textLogic;
    }
}

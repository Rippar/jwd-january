package com.epam.jwd.task2.logic;

import com.epam.jwd.task2.logic.impl.TextLogicImpl;

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

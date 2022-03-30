package com.epam.jwd.task2.dao;

import com.epam.jwd.task2.dao.impl.TextDAOImpl;

/**
 * The class which uses singleton pattern to control the number of dao objects created and also make it possible to
 * change the implementation of the TextDAO interface if necessary
 *
 * @author Dmitry Murzo
 */
public class DAOProvider {

    private static final DAOProvider instance = new DAOProvider();

    private TextDAO textDAO = new TextDAOImpl();

    private DAOProvider() {

    }

    public static DAOProvider getInstance() {
        return instance;
    }

    public TextDAO getTextDAO() {
        return textDAO;
    }

    public void setTextDAO(TextDAO textDAO) {
        this.textDAO = textDAO;
    }
}

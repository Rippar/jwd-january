package com.epam.jwd.task2.dao;

import com.epam.jwd.task2.dao.impl.TextDAOImpl;

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

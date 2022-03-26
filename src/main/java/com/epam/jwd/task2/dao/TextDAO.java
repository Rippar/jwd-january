package com.epam.jwd.task2.dao;

import com.epam.jwd.task2.entity.Text;

import java.util.List;

public interface TextDAO {

    String readFromFile() throws DAOException;
    boolean writeToFile(Text text) throws DAOException;
}

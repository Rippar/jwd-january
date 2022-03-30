package com.epam.jwd.task2.dao;

import com.epam.jwd.task2.entity.Text;

/**
 * The TextDAO interface defines the methods for reading and writing an information to the file
 *
 * @author Dmitry Murzo
 */
public interface TextDAO {

    /**
     * The method for reading information from the source
     *
     * @return the information read in the source as a String object
     * @throws DAOException if source is not found
     */
    String readFromFile() throws DAOException;

    /**
     * The method for writing information contained in the {@code Text} object to the file
     *
     * @return boolean result for this operation
     * @throws DAOException if file is not found
     */
    boolean writeToFile(Text text) throws DAOException;
}

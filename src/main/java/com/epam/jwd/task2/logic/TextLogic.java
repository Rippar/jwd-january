package com.epam.jwd.task2.logic;

import com.epam.jwd.task2.dao.DAOException;
import com.epam.jwd.task2.entity.Text;

public interface TextLogic {

    void changeFirstLastWord(Text text);

    void removeWordsOfGivenLengthStartsWithConsonant(Text text, int length);

    void sortWordsByVowelFraction(Text text);

    boolean saveTheTextToFile(Text text) throws DAOException;

}

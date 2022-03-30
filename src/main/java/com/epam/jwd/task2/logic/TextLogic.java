package com.epam.jwd.task2.logic;

import com.epam.jwd.task2.entity.Text;

/**
 * The TextLogic interface defines the methods to implement the functionality for working with Text object
 *
 * @author Dmitry Murzo
 */
public interface TextLogic {

    /**
     * The method which swap the first word with the last in each sentence of {@code Text} object
     *
     * @param text {@code Text} object
     */
    void swapFirstLastWord(Text text);

    /**
     * The method which remove the words of given length starts with consonant in each sentence of {@code Text} object
     *
     * @param text   {@code Text} object
     * @param length of the word
     */
    void removeWordsOfGivenLengthStartsWithConsonant(Text text, int length);

    /**
     * The method which sort the words by the ascending proportion of vowels in each sentence of {@code Text} object
     *
     * @param text {@code Text} object
     */
    void sortWordsByVowelFraction(Text text);

    /**
     * The method which save the current state of {@code Text} object in string form
     *
     * @param text{@code Text} object
     * @return save result
     * @throws LogicException if can't get access to the file
     */
    boolean saveTheTextToFile(Text text) throws LogicException;

}

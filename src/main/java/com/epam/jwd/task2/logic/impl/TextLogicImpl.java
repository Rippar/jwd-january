package com.epam.jwd.task2.logic.impl;

import com.epam.jwd.task2.dao.DAOException;
import com.epam.jwd.task2.dao.DAOProvider;
import com.epam.jwd.task2.dao.TextDAO;
import com.epam.jwd.task2.entity.Paragraph;
import com.epam.jwd.task2.entity.Sentence;
import com.epam.jwd.task2.entity.Text;
import com.epam.jwd.task2.entity.TextElement;
import com.epam.jwd.task2.entity.Word;
import com.epam.jwd.task2.logic.LogicException;
import com.epam.jwd.task2.logic.TextLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The class that implements the methods from TextLogic interface for working with text
 *
 * @author Dmitry Murzo
 */
public class TextLogicImpl implements TextLogic {

    /**
     * String constant of regular expression to check if string starts with vowel letter
     */
    public static final String REGEX_FOR_VOWELS = "^(?i:[aeiouy]).*";

    /**
     * String constant of regular expression to find the vowels in a string
     */
    public static final String REGEX_TO_COUNT_VOWELS = "(?iu)[aeiouy]";

    /**
     * DAOProvider used to get a certain TextDAO implementation
     */
    private final DAOProvider provider = DAOProvider.getInstance();

    /**
     * The method which swap the first word with the last in each sentence of {@code Text} object
     * Get the List of {@code TextElement} objects from {@code Text} object, in each {@code Paragraph} object
     * get the List of {@code Sentence} objects and get the List of {@code Word} objects in each {@code Sentence}
     * object. Then do the swap of the first and last {@code Word} object.
     *
     * @param text {@code Text} object
     */
    @Override
    public void swapFirstLastWord(Text text) {
        List<TextElement> textElements = text.getTextElements();
        for (TextElement el : textElements) {
            if (el.getClass() == Paragraph.class) {
                List<Sentence> sentences = ((Paragraph) el).getSentences();
                for (Sentence sentence : sentences) {
                    List<Word> words = sentence.getWords();
                    Word first = words.get(0);
                    Word last = words.get(words.size() - 1);
                    words.set(0, last);
                    words.set(words.size() - 1, first);
                }

            }
        }
    }

    /**
     * The method which remove the words of given length starts with consonant in each sentence of {@code Text} object.
     * Get the List of {@code TextElement} objects from {@code Text} object, in each {@code Paragraph} object
     * get the List of {@code Sentence} objects. Then remove the each {@code Word} object of given length from
     * {@code Sentence} object.
     *
     * @param text   {@code Text} object
     * @param length of the word
     */
    @Override
    public void removeWordsOfGivenLengthStartsWithConsonant(Text text, int length) {
        List<TextElement> textElements = text.getTextElements();
        for (TextElement el : textElements) {
            if (el.getClass() == Paragraph.class) {
                List<Sentence> sentences = ((Paragraph) el).getSentences();
                for (Sentence sentence : sentences) {
                    List<Word> words = sentence.getWords();
                    List<Word> wordsForRemove = new ArrayList<>();
                    for (Word word : words) {
                        String tmp = word.getWord();
                        if (tmp.length() == length && !tmp.matches(REGEX_FOR_VOWELS)) {
                            wordsForRemove.add(word);
                        }
                    }

                    for (Word word : wordsForRemove) {
                        words.remove(word);
                    }

                }

            }
        }
    }

    /**
     * The method which sort the words by the ascending proportion of vowels in each sentence of {@code Text} object.
     * Get the List of {@code TextElement} objects from {@code Text} object, in each {@code Paragraph} object
     * get the List of {@code Sentence} objects. Then count and assign the proportion of vowels to each {@code Word}
     * object via {@code countTheFractionOfVowels(Word)} method and sort the List of {@code Word} objects
     * by the ascending proportion of vowels.
     *
     * @param text {@code Text} object
     * @see #countTheFractionOfVowels(Word)
     */
    @Override
    public void sortWordsByVowelFraction(Text text) {
        List<TextElement> textElements = text.getTextElements();
        for (TextElement el : textElements) {
            if (el.getClass() == Paragraph.class) {
                List<Sentence> sentences = ((Paragraph) el).getSentences();
                for (Sentence sentence : sentences) {
                    List<Word> words = sentence.getWords();
                    List<Double> fractions = new ArrayList<>();
                    for (Word word : words) {
                        Double fraction = countTheFractionOfVowels(word);
                        fractions.add(fraction);
                    }

                    for (int i = 0; i < words.size(); i++) {
                        for (int j = words.size() - 1; j > i; j--) {
                            if (fractions.get(i) > fractions.get(j)) {
                                Word tmp0 = words.get(i);
                                Word tmp1 = words.get(j);
                                Double f0 = fractions.get(i);
                                Double f1 = fractions.get(j);
                                words.set(i, tmp1);
                                words.set(j, tmp0);
                                fractions.set(i, f1);
                                fractions.set(j, f0);

                            }
                        }
                    }

                }
            }
        }
    }

    /**
     * The method which save the current state of {@code Text} object in string form to the file.
     *
     * @param text {@code Text} object
     * @return save result
     * @throws LogicException if can't get access to the file
     */
    @Override
    public boolean saveTheTextToFile(Text text) throws LogicException {
        TextDAO textDAO = provider.getTextDAO();
        try {
            return textDAO.writeToFile(text);
        } catch (DAOException e) {
            throw new LogicException(e);
        }
    }

    /**
     * Helper method is used to count the proportion of vowels in each {@code Word} object.
     *
     * @param word is {@code Word} object
     * @return {@code Double} value of fraction
     */
    private Double countTheFractionOfVowels(Word word) {
        String str = word.getWord();
        Pattern vowels = Pattern.compile(REGEX_TO_COUNT_VOWELS);
        Matcher m = vowels.matcher(str);
        int vowelsCounter = 0;
        while (m.find()) {
            vowelsCounter++;
        }

        return (double) vowelsCounter / str.length();


    }
}

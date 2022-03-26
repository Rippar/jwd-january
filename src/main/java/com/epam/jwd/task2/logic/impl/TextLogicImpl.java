package com.epam.jwd.task2.logic.impl;

import com.epam.jwd.task2.dao.DAOException;
import com.epam.jwd.task2.dao.DAOProvider;
import com.epam.jwd.task2.dao.TextDAO;
import com.epam.jwd.task2.entity.Paragraph;
import com.epam.jwd.task2.entity.Sentence;
import com.epam.jwd.task2.entity.Text;
import com.epam.jwd.task2.entity.TextElement;
import com.epam.jwd.task2.entity.Word;
import com.epam.jwd.task2.logic.TextLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextLogicImpl implements TextLogic {

    public static final String REGEX_FOR_VOWELS = "^(?i:[aeiouy]).*";
    public static final String REGEX_TO_COUNT_VOWELS ="(?iu)[aeiouy]";

    private final DAOProvider provider = DAOProvider.getInstance();

    @Override
    public void changeFirstLastWord(Text text) {
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
                        for (int j = words.size()-1; j > i; j--) {
                            if (fractions.get(i) > fractions.get(j)) {
                                Word tmp0 = words.get(i);
                                Word tmp1 = words.get(j);
                                Double f0 = fractions.get(i);
                                Double f1 = fractions.get(j);
                                words.set(i, tmp1);
                                words.set(j, tmp0);
                                fractions.set(i,f1);
                                fractions.set(j,f0);

                            }
                        }
                    }

                }
            }
        }
    }

    @Override
    public boolean saveTheTextToFile(Text text) throws DAOException {
        TextDAO textDAO = provider.getTextDAO();
        return textDAO.writeToFile(text);
    }

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

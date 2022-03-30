package com.epam.jwd.task2.parsing.impl;

import com.epam.jwd.task2.dao.DAOException;
import com.epam.jwd.task2.dao.DAOProvider;
import com.epam.jwd.task2.dao.TextDAO;
import com.epam.jwd.task2.entity.CodeBlock;
import com.epam.jwd.task2.entity.Headline;
import com.epam.jwd.task2.entity.Paragraph;
import com.epam.jwd.task2.entity.Sentence;
import com.epam.jwd.task2.entity.Text;
import com.epam.jwd.task2.entity.TextElement;
import com.epam.jwd.task2.entity.Word;
import com.epam.jwd.task2.parsing.ParsingException;
import com.epam.jwd.task2.parsing.TextParser;

import java.util.ArrayList;
import java.util.List;

/**
 * The class that implements TextParser interface and defines the necessary regular expressions and helper methods
 * to parse the text elements
 *
 * @author Dmitry Murzo
 */
public class TextParserImpl implements TextParser {

    /**
     * String constant of line delimiter
     */
    public static final String LINE_DELIMITER = "\n";

    /**
     * String constant of regular expression to check if the string is a headline
     */
    public static final String HEADLINE_REGEX = "\\d.*";

    /**
     * String constant of regular expression to check if the string is a block of code
     */
    public static final String BEGIN_CODE_BLOCK_SYMBOL = "^(void|class).*";

    /**
     * String constant of regular expression to check if the string is an end of the block of code
     */
    public static final String END_CODE_BLOCK_SYMBOL = "^}";

    /**
     * String constant of regular expression to split the string to the sentences
     */
    public static final String SENTENCE_SPLIT_REGEX = "[.]+";

    /**
     * String constant of space symbol
     */
    public static final String SPACE = " ";

    /**
     * String constant of colon symbol
     */
    public static final String COLON = ":";

    /**
     * DAOProvider used to get a certain TextDAO implementation
     */
    private final DAOProvider provider = DAOProvider.getInstance();

    /**
     * Text object used to store the result of parseTheText() method
     */
    private Text text = null;

    /**
     * The method which parse the text structure elements from DAO layer, converts them into {@code TextElement} objects,
     * creates and returns a Text object
     *
     * @return {@code Text} object
     * @throws ParsingException if can't get parsing info from source
     */

    @Override
    public Text parseTheText() throws ParsingException {
        if (text == null) {
            TextDAO textDAO = provider.getTextDAO();
            String stringText = null;

            try {
                stringText = textDAO.readFromFile();

                List<TextElement> textElements = new ArrayList<>();

                String[] lines = stringText.split(LINE_DELIMITER);

                for (int i = 0; i < lines.length; i++) {
                    if (lines[i].matches(HEADLINE_REGEX)) {
                        StringBuilder headLineTmp = new StringBuilder();
                        headLineTmp.append(lines[i]);
                        headLineTmp.append(LINE_DELIMITER);
                        textElements.add(new Headline(headLineTmp.toString()));


                    } else if (lines[i].matches(BEGIN_CODE_BLOCK_SYMBOL)) {
                        StringBuilder codeBlockTmp = new StringBuilder();
                        codeBlockTmp.append(lines[i]);
                        codeBlockTmp.append(LINE_DELIMITER);

                        for (int j = i + 1; j < lines.length; j++) {
                            if (!lines[j].matches(END_CODE_BLOCK_SYMBOL)) {
                                codeBlockTmp.append(lines[j]);
                                codeBlockTmp.append(LINE_DELIMITER);
                            } else {
                                codeBlockTmp.append(lines[j]);
                                codeBlockTmp.append(LINE_DELIMITER);
                                i = j;
                                textElements.add(new CodeBlock(codeBlockTmp.toString()));
                                break;
                            }
                        }

                    } else {
                        StringBuilder paragraphTmp = new StringBuilder();

                        for (int j = i; j < lines.length; j++) {
                            if (j < lines.length - 1 && !lines[j + 1].matches(HEADLINE_REGEX) && !lines[j + 1].matches(BEGIN_CODE_BLOCK_SYMBOL)) {
                                paragraphTmp.append(lines[j]);
                                paragraphTmp.append(LINE_DELIMITER);
                            } else {
                                paragraphTmp.append(lines[j]);

                                List<Sentence> sentences = parseParagraphToSentences(paragraphTmp.toString());
                                textElements.add(new Paragraph(sentences));
                                i = j;
                                break;
                            }

                        }

                    }
                }

                text = new Text(textElements);
                return text;

            } catch (DAOException e) {
                throw new ParsingException(e);
            }
        } else {
            return text;
        }


    }

    /**
     * Helper method is used to parse the String representation of paragraph of the source text and convert it into the
     * {@code List}of {@code Sentence} objects
     *
     * @param paragraph is a String representation of paragraph
     * @return {@code List} of {@code Sentence} objects
     */
    private List<Sentence> parseParagraphToSentences(String paragraph) {
        String[] rawSentences = paragraph.split(SENTENCE_SPLIT_REGEX);
        List<Sentence> sentences = new ArrayList<>();


        for (String sentence : rawSentences) {
            List<Word> words = parseSentenceToWord(sentence);
            sentences.add(new Sentence(words));
        }

        return sentences;
    }

    /**
     * Helper method is used to parse the String representation of sentence of the source text and convert it into the
     * {@code List}of {@code Word} objects
     *
     * @param sentence is a String representation of sentence
     * @return {@code List} of {@code Word} objects
     */
    private List<Word> parseSentenceToWord(String sentence) {
        List<Word> words = new ArrayList<>();
        String[] rawWords = sentence.split(SPACE);

        for (int i = 0; i < rawWords.length; i++) {
            if (i == rawWords.length - 1 && rawWords[i].endsWith(COLON)) {
                words.add(new Word(rawWords[i]));
            } else if (i == rawWords.length - 1) {
                words.add(new Word(rawWords[i] + "."));
            } else {
                words.add(new Word(rawWords[i]));
            }
        }

        return words;

    }
}

package com.epam.jwd.task2.dao.impl;

import com.epam.jwd.task2.dao.DAOException;
import com.epam.jwd.task2.dao.TextDAO;
import com.epam.jwd.task2.entity.CodeBlock;
import com.epam.jwd.task2.entity.Headline;
import com.epam.jwd.task2.entity.Paragraph;
import com.epam.jwd.task2.entity.Sentence;
import com.epam.jwd.task2.entity.Text;
import com.epam.jwd.task2.entity.TextElement;
import com.epam.jwd.task2.entity.Word;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * The class that implements the methods from TextDAO interface for reading and writing an information to the file
 *
 * @author Dmitry Murzo
 */
public class TextDAOImpl implements TextDAO {

    /**
     * The path of the file to read info
     */
    public static final String PATH_TO_READ = "src/main/resources/SourceText.txt";

    /**
     * The path of the file to write info
     */
    public static final String PATH_TO_WRITE = "src/main/resources/FinalText.txt";

    /**
     * String constant of space symbol
     */
    public static final String SPACE = " ";

    /**
     * String constant of line delimiter
     */
    public static final String LINE_DELIMITER = "\n";

    /**
     * String object used to store information obtained by reading information from a file
     */
    private final String text = null;


    /**
     * The method for reading information from the source file
     *
     * @return the information read in the source file as a String object
     * @throws DAOException if source is not found
     */
    @Override
    public String readFromFile() throws DAOException {

        if (text == null) {
            StringBuilder text = new StringBuilder();

            try (BufferedReader reader = new BufferedReader(new FileReader(PATH_TO_READ))) {
                String line;

                while ((line = reader.readLine()) != null) {
                    text.append(line);
                    text.append("\n");
                }

            } catch (IOException e) {
                throw new DAOException(e);
            }

            return text.toString();
        } else {
            return text;
        }


    }

    /**
     * The method for writing information contained in the {@code Text} object in the string form to the file.
     *
     * @return boolean result for this operation
     * @throws DAOException if file is not found
     */
    @Override
    public boolean writeToFile(Text text) throws DAOException {
        boolean result = false;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH_TO_WRITE, false))) {

            List<TextElement> textElements = text.getTextElements();

            for (TextElement el : textElements) {
                if (el.getClass() == Headline.class) {
                    writer.write(((Headline) el).getHeadline());
                } else if (el.getClass() == CodeBlock.class) {
                    writer.write(((CodeBlock) el).getCode());
                } else if (el.getClass() == Paragraph.class) {
                    List<Sentence> sentences = ((Paragraph) el).getSentences();
                    for (Sentence sentence : sentences) {
                        List<Word> words = sentence.getWords();
                        for (Word word : words) {
                            writer.write(word.getWord() + SPACE);
                        }
                    }
                    writer.write(LINE_DELIMITER);

                }
            }

            result = true;
        } catch (IOException e) {
            throw new DAOException(e);
        }

        return result;


    }
}

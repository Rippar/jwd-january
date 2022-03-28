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


public class TextParserImpl implements TextParser {
    public static final String LINE_DELIMETR = "\n";
    public static final String HEADLINE_REGEX = "\\d.*";
    public static final String BEGIN_CODE_BLOCK = "^(void|class).*";
    public static final String END_CODE_BLOCK = "^}";
    public static final String SENTENCE_SPLIT_REGEX = "[.]+";
    public static final String WORD_SPLIT_REGEX = " ";

    private final DAOProvider provider = DAOProvider.getInstance();
    private Text text = null;

    @Override
    public Text parseTheText() throws ParsingException {
        if(text == null) {
            TextDAO textDAO = provider.getTextDAO();
            String stringText = null;

            try {
                stringText = textDAO.readFromFile();

                List<TextElement> textElements = new ArrayList<>();

                String[] lines = stringText.split(LINE_DELIMETR);

                for (int i = 0; i < lines.length; i++) {
                    if (lines[i].matches(HEADLINE_REGEX)) {
                        StringBuilder headLineTmp = new StringBuilder();
                        headLineTmp.append(lines[i]);
                        headLineTmp.append(LINE_DELIMETR);
                        textElements.add(new Headline(headLineTmp.toString()));


                    } else if (lines[i].matches(BEGIN_CODE_BLOCK)) {
                        StringBuilder codeBlockTmp = new StringBuilder();
                        codeBlockTmp.append(lines[i]);
                        codeBlockTmp.append(LINE_DELIMETR);

                        for (int j = i + 1; j < lines.length; j++) {
                            if (!lines[j].matches(END_CODE_BLOCK)) {
                                codeBlockTmp.append(lines[j]);
                                codeBlockTmp.append(LINE_DELIMETR);
                            } else {
                                codeBlockTmp.append(lines[j]);
                                codeBlockTmp.append(LINE_DELIMETR);
                                i = j;
                                textElements.add(new CodeBlock(codeBlockTmp.toString()));
                                break;
                            }
                        }

                    } else {
                        StringBuilder paragraphTmp = new StringBuilder();

                        for (int j = i; j < lines.length; j++) {
                            if (j < lines.length - 1 && !lines[j + 1].matches(HEADLINE_REGEX) && !lines[j + 1].matches(BEGIN_CODE_BLOCK)) {
                                paragraphTmp.append(lines[j]);
                                paragraphTmp.append(LINE_DELIMETR);
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

    private List<Sentence> parseParagraphToSentences(String paragraph) {
        String[] rawSentences = paragraph.split(SENTENCE_SPLIT_REGEX);
        List<Sentence> sentences = new ArrayList<>();


        for (String sentence : rawSentences) {
            List<Word> words = parseSentenceToWord(sentence);
            sentences.add(new Sentence(words));
        }

        return sentences;
    }

    private List<Word> parseSentenceToWord(String sentence) {
        List<Word> words = new ArrayList<>();
        String[] rawWords = sentence.split(WORD_SPLIT_REGEX);

        for (int i = 0; i < rawWords.length; i++) {
            if (i == rawWords.length - 1 && rawWords[i].endsWith(":")) {
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

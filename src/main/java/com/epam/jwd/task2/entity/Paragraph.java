package com.epam.jwd.task2.entity;

import java.util.List;

public class Paragraph extends TextElement {
    private int id;
    private List<Sentence> sentences;

    public Paragraph() {
        id = count++;
    }

    public Paragraph(List<Sentence> sentences) {
        id = count++;
        this.sentences = sentences;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Paragraph paragraph = (Paragraph) o;

        if (id != paragraph.id) return false;
        return sentences != null ? sentences.equals(paragraph.sentences) : paragraph.sentences == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (sentences != null ? sentences.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " {" +
                "id=" + id +
                ", sentences=" + sentences +
                '}';
    }
}

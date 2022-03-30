package com.epam.jwd.task2.entity;

import java.util.List;

public class Sentence {

    private static int count = 0;

    private int id;
    private List<Word> words;

    public Sentence() {
        id = count++;
    }

    public Sentence(List<Word> words) {
        id = count++;
        this.words = words;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sentence sentence = (Sentence) o;

        if (id != sentence.id) return false;
        return words != null ? words.equals(sentence.words) : sentence.words == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (words != null ? words.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " {" +
                "id=" + id +
                ", words=" + words +
                '}';
    }
}

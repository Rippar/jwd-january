package com.epam.jwd.task2.entity;

import java.util.List;

public class Text {

    private List <TextElement> textElements;

    public Text() {
    }

    public Text(List<TextElement> textElements) {
        this.textElements = textElements;
    }

    public List<TextElement> getTextElements() {
        return textElements;
    }

    public void setTextElements(List<TextElement> textElements) {
        this.textElements = textElements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Text text = (Text) o;

        return textElements != null ? textElements.equals(text.textElements) : text.textElements == null;
    }

    @Override
    public int hashCode() {
        return textElements != null ? textElements.hashCode() : 0;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " {" +
                "textElements=" + textElements +
                '}';
    }
}

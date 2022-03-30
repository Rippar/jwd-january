package com.epam.jwd.task2.entity;

public class Headline extends TextElement {
    private int id;
    private String headline;

    public Headline() {
        id = count++;
    }

    public Headline(String headline) {
        id = count++;
        this.headline = headline;
    }

    public int getId() {
        return id;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Headline headline1 = (Headline) o;

        if (id != headline1.id) return false;
        return headline != null ? headline.equals(headline1.headline) : headline1.headline == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (headline != null ? headline.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " {" +
                "id=" + id +
                ", headline='" + headline + '\'' +
                '}';
    }
}

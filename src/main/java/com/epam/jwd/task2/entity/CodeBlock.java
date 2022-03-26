package com.epam.jwd.task2.entity;

public class CodeBlock extends TextElement{
    private int id;
    private String code;

    public CodeBlock() {
        id = count++;
    }

    public CodeBlock(String code) {
        id = count++;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CodeBlock codeBlock = (CodeBlock) o;

        if (id != codeBlock.id) return false;
        return code != null ? code.equals(codeBlock.code) : codeBlock.code == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " {" +
                "id=" + id +
                ", code='" + code + '\'' +
                '}';
    }
}

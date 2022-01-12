package com.cesi.ressourcesrelationnelles.domain;

public class Comment {
    private int id;
    private String author;
    private String title;
    private String content;

    public Comment() {
    }

    public Comment(int id, String author, String title, String content) {
        this.setId(id);
        this.setAuthor(author);
        this.setTitle(title);
        this.setContent(content);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

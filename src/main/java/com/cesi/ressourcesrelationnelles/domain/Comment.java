package com.cesi.ressourcesrelationnelles.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Comment")
public class Comment {
    @Id
    private Long id;
    private String author;
    private String title;
    private String content;


    public Comment() {
    }

    public Comment(Long id, String author, String title, String content) {
        this.setId(id);
        this.setAuthor(author);
        this.setTitle(title);
        this.setContent(content);
    }

    public Comment(String author) {
        this.author = author;
    }

    public Comment(String author, String title) {
        this.setAuthor(author);
        this.setTitle(title);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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


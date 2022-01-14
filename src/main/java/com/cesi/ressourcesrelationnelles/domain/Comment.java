package com.cesi.ressourcesrelationnelles.domain;

import javax.persistence.*;

@Entity(name = "COMMENT")
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    private String author;
    private String title;
    private String content;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private CommentType commentType;

    public Comment() {
    }

    public Comment(Long id, String author, String title, String content) {
        this.setId(id);
        this.setAuthor(author);
        this.setTitle(title);
        this.setContent(content);
    }

    public Comment(Long id, String author, String title, String content, CommentType commentType) {
        this.setId(id);
        this.setAuthor(author);
        this.setTitle(title);
        this.setContent(content);
        this.setCommentType(commentType);
    }

    public Comment(String author) {
        this.author = author;
    }

    public Comment(String author, String title) {
        this.setAuthor(author);
        this.setTitle(title);
    }

    public CommentType getCommentType() {
        return commentType;
    }

    public void setCommentType(CommentType commentType) {
        this.commentType = commentType;
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


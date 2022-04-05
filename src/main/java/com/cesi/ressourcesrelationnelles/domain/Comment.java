package com.cesi.ressourcesrelationnelles.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Comment")
public class Comment {
    @Id
    private ObjectId id;
    private ObjectId resourceId;
    private String author;
    private String title;
    private String content;


    public Comment() {
    }

    public Comment(ObjectId id, ObjectId resourceId, String author, String title, String content) {
        this.setId(id);
        this.setResourceId(resourceId);
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

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getResourceId() {
        return resourceId;
    }

    public void setResourceId(ObjectId id) {
        this.resourceId = resourceId;
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


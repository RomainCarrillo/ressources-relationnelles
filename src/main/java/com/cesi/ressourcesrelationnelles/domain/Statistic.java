package com.cesi.ressourcesrelationnelles.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Statistic")
public class Statistic {

	@Id
    private ObjectId id;
    private Long resourceId;
    private int nbVues;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public int getNbVues() {
        return nbVues;
    }

    public void setNbVues(int nbVues) {
        this.nbVues = nbVues;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public Statistic(){

    }

    public Statistic(ObjectId id, Long resourceId, int nbVues) {
        this.id = id;
        this.resourceId = resourceId;
        this.nbVues = nbVues;
    }
}

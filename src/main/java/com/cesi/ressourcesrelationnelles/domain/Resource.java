package com.cesi.ressourcesrelationnelles.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Resource")
public class Resource {

    @Id
    private ObjectId id;
    private String resourceName;
    private int resourceType;


    public Resource(int resourceType, String resourceName, ObjectId id) {
        this.resourceType = resourceType;
        this.resourceName = resourceName;
        this.id = id;
    }

    public Resource() {

    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public int getResourceType() {
        return resourceType;
    }

    public void setResourceType(int resourceType) {
        this.resourceType = resourceType;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
}

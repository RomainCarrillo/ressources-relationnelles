package com.cesi.ressourcesrelationnelles.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Resource")
public class Resource {

    @Id
    private ObjectId id;
    private String resourcesName;

    private int resourcesTypes;


    public Resource(int resourcesTypes, String resourcesName, ObjectId id) {
        this.resourcesTypes = resourcesTypes;
        this.resourcesName = resourcesName;
        this.id = id;
    }

    public Resource() {

    }

    public String getResourcesName() {
        return resourcesName;
    }

    public void setResourcesName(String resourcesName) {
        this.resourcesName = resourcesName;
    }

    public int getResourcesTypes() {
        return resourcesTypes;
    }

    public void setResourcesTypes(int resourcesTypes) {
        this.resourcesTypes = resourcesTypes;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
}

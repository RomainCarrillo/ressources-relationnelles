package com.cesi.ressourcesrelationnelles.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Resource")
public class Resource {

    @Id
    private long id;
    private String resourcesName;

    private int resourcesTypes;


    public Resource(int resourcesTypes, String resourcesName, int id) {
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

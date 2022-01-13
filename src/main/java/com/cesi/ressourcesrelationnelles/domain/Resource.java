package com.cesi.ressourcesrelationnelles.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Resource {

    @Id
    @GeneratedValue
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

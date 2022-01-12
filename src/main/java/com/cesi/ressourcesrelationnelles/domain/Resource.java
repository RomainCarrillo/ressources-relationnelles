package com.cesi.ressourcesrelationnelles.domain;

public class Resource {

    private int resourcesTypes;
    private String resourcesName;
    private int id;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

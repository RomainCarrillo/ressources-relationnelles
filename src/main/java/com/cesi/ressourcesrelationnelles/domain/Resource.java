package com.cesi.ressourcesrelationnelles.domain;

public class Resource {

    private int ResourcesTypes;
    private String ResourcesName;
    private int id;

    public String getResourcesName() {
        return ResourcesName;
    }

    public void setResourcesName(String resourcesName) {
        ResourcesName = resourcesName;
    }

    public int getResourcesTypes() {
        return ResourcesTypes;
    }

    public void setResourcesTypes(int resourcesTypes) {
        ResourcesTypes = resourcesTypes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

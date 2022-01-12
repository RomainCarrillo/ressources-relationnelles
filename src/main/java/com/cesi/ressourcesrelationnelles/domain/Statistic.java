package com.cesi.ressourcesrelationnelles.domain;

public class Statistic {
    public int id;
    public int nbVues;
    public int id_ressource;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNbVues() {
        return nbVues;
    }

    public void setNbVues(int nbVues) {
        this.nbVues = nbVues;
    }

    public int getId_ressource() {
        return id_ressource;
    }

    public void setId_ressource(int id_ressource) {
        this.id_ressource = id_ressource;
    }

    public Statistic(int id, int idRessource, int nbVues) {
        this.id = id;
        this.id_ressource = idRessource;
        this.nbVues = nbVues;
    }
}

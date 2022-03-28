package com.cesi.ressourcesrelationnelles.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Statistic")
public class Statistic {

	@Id
    private long id;
    private int nbVues;
    private int id_ressource;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Statistic(){

    }

    public Statistic(int id, int idRessource, int nbVues) {
        this.id = id;
        this.id_ressource = idRessource;
        this.nbVues = nbVues;
    }
}

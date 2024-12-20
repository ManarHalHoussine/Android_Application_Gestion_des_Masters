package com.example.projetmaster1.models;

public class Module {

    private long id;
    private String nom;
    private String description;

    // Constructeur
    public Module(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    // Getters et Setters (à générer automatiquement dans Android Studio)

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

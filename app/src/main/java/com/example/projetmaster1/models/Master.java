package com.example.projetmaster1.models;

public class Master {

    private long id;
    private String nom;
    private String coordinateur;
    private String description;

    // Constructeur
    public Master(String nom, String coordinateur, String description) {
        this.nom = nom;
        this.coordinateur = coordinateur;
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

    public String getCoordinateur() {
        return coordinateur;
    }

    public void setCoordinateur(String coordinateur) {
        this.coordinateur = coordinateur;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

package com.example.projetmaster1.models;

public class Professeur {

    private long id;
    private String nom;
    private String prenom;
    private String email;
    private String description;
  private String master;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Constructeur
    public Professeur(String master, String nom, String description) {

        this.master = master;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMaster() {
        return master;
    }



}

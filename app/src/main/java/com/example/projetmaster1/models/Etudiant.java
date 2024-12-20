package com.example.projetmaster1.models;

public class Etudiant {

    private long id;
    private String nom;
    private String prenom;
    private String password;
    private String master;
    private String email;

    // Constructeur
    public Etudiant(String nom, String prenom, String email, String master) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.master = master;
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
    public String getMaster() {

        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}

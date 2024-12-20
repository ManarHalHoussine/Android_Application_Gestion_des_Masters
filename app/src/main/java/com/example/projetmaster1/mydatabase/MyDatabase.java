package com.example.projetmaster1.mydatabase;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabase extends SQLiteOpenHelper {
    public String s[] = {"admin@usmba.ac.ma"};

    public MyDatabase(Context context) {

        super(context, "projetmaster", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Etudiant(" +

                "nom TEXT NOT NULL," +
                "prenom TEXT NOT NULL," +
                "email TEXT PRIMARY KEY," +
                "password TEXT NOT NULL," +
                "master TEXT NOT NULL)");
        db.execSQL("CREATE TABLE client(" +
                "email TEXT PRIMARY KEY," +
                "nom TEXT NOT NULL," +
                "prenom TEXT NOT NULL," +
                "password TEXT NOT NULL)");

        db.execSQL("CREATE TABLE Professeur(" +
                "email TEXT PRIMARY KEY," +
                "nom TEXT NOT NULL," +
                "prenom TEXT NOT NULL," +
                "password TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int j) {
        db.execSQL("DROP TABLE  IF EXISTS client");

    }

    public void insertEnsei() {
        SQLiteDatabase db = getWritableDatabase();

        // Début de la transaction
        db.beginTransaction();

        try {
            // Professeur 1
            ContentValues prof1Values = new ContentValues();
            prof1Values.put("email", "prof1@usmba.ac.ma");
            prof1Values.put("nom", "NomProf1");
            prof1Values.put("prenom", "PrenomProf1");
            prof1Values.put("cin", "CIN123");
            prof1Values.put("password", "password1");

            db.insert("Professeur", null, prof1Values);

            // Professeur 2
            ContentValues prof2Values = new ContentValues();
            prof2Values.put("email", "prof2@usmba.ac.ma");
            prof2Values.put("nom", "NomProf2");
            prof2Values.put("prenom", "PrenomProf2");
            prof2Values.put("cin", "CIN456");
            prof2Values.put("password", "password2");

            db.insert("Professeur", null, prof2Values);

            // Professeur 3
            ContentValues prof3Values = new ContentValues();
            prof3Values.put("email", "prof3@usmba.ac.ma");
            prof3Values.put("nom", "NomProf3");
            prof3Values.put("prenom", "PrenomProf3");
            prof3Values.put("cin", "CIN789");
            prof3Values.put("password", "password3");

            db.insert("Professeur", null, prof3Values);

            // Réussite de la transaction
            db.setTransactionSuccessful();
        } finally {
            // Fin de la transaction
            db.endTransaction();
        }
    }
    public void insertEtudiant(String nom, String prenom,String email,String password,String master) {
        SQLiteDatabase db = getWritableDatabase();

        // Début de la transaction
        db.beginTransaction();

        try {
            ContentValues values = new ContentValues();

            values.put("nom", nom);
            values.put("prenom", prenom);
            values.put("email", email);
            values.put("password", password);
            values.put("master", master);

            db.insert("Etudiant", null, values);

            // Réussite de la transaction
            db.setTransactionSuccessful();
        } finally {
            // Fin de la transaction
            db.endTransaction();
        }

        db.close();
    }

    public boolean isAdmin(String email) {
        for (String adminEmail : s) {
            if (adminEmail.equals(email)) {
                return true;
            }
        }
        return false;
    }

}

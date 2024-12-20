package com.example.projetmaster1.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.projetmaster1.models.Etudiant;

import java.util.ArrayList;
import java.util.List;

public class EtudiantDAO extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Database";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Etudiant";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NOM = "nom";
    private static final String COLUMN_PRENOM = "prenom";
    private static final String COLUMN_EMAIL = "email";
  //  private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_MASTER = "master";

    public EtudiantDAO(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NOM + " TEXT, "
                + COLUMN_PRENOM + " TEXT, "
                + COLUMN_EMAIL + " TEXT, "
                + COLUMN_MASTER + " TEXT)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Implementer si nécessaire
    }

    public void addEtudiant(Etudiant etudiant) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NOM, etudiant.getNom());
        values.put(COLUMN_PRENOM, etudiant.getPrenom());
        values.put(COLUMN_EMAIL, etudiant.getEmail());
        values.put(COLUMN_MASTER, etudiant.getMaster());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public List<Etudiant> getAllEtudiants() {
        List<Etudiant> etudiantsList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") Etudiant etudiant = new Etudiant(
                        cursor.getString(cursor.getColumnIndex(COLUMN_NOM)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_PRENOM)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_MASTER))
                );
                etudiantsList.add(etudiant);

                // Log added for debugging
                Log.d("EtudiantDAO", "Added etudiant: " + etudiant.getNom() + " " + etudiant.getPrenom());
            } while (cursor.moveToNext());
        } else {
            // Log added for debugging
            Log.d("EtudiantDAO", "No etudiants found in the database");
        }

        cursor.close();
        db.close();
        return etudiantsList;
    }
    public void updateEtudiant(Etudiant etudiant) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NOM, etudiant.getNom());
        values.put(COLUMN_PRENOM, etudiant.getPrenom());
        values.put(COLUMN_EMAIL, etudiant.getEmail());
        values.put(COLUMN_MASTER, etudiant.getMaster());

        // Clause WHERE pour identifier l'étudiant à mettre à jour
        String selection = COLUMN_ID + "=?";
        String[] selectionArgs = {String.valueOf(etudiant.getId())}; // Assurez-vous que vous avez un champ id dans votre classe Etudiant

        // Mettre à jour l'enregistrement dans la base de données
        db.update(TABLE_NAME, values, selection, selectionArgs);
        db.close();
    }


}

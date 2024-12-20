package com.example.projetmaster1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dataBase extends SQLiteOpenHelper {
    public dataBase(Context context) {
        super(context, "admindata.db", null, 1);
        SQLiteDatabase db=getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE etudiant("+
                "Cne TEXT PRIMARY KEY,"+
                "Nom TEXT,"+
                "Prenom TEXT,"+
                "email TEXT,"+
                "password TEXT)");
        db.execSQL("CREATE TABLE professeur("+
                "Nom TEXT,"+
                "Prenom TEXT,"+
                "email TEXT,"+
                "password TEXT)");
        db.execSQL("CREATE TABLE module(NomMaster TEXT,NomModule TEXT)");
        db.execSQL("CREATE TABLE master(NomMaster TEXT PRIMARY KEY,NombreModule INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP Table IF EXISTS etudiant");
        db.execSQL("DROP Table IF EXISTS professeur");
        db.execSQL("DROP Table IF EXISTS module");
        db.execSQL("DROP Table IF EXISTS master");
    }

    public boolean insertData( String nom, String prenom, String email,String password){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues value=new ContentValues();

        value.put("Nom",nom);
        value.put("Prenom",prenom);
        value.put("Email",email);
        value.put("Password",password);
        long res=db.insert("admin",null,value);
        if(res==-1){
            return false;
        }else{
            return true;
        }
    }

    public boolean checkUser(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM admin where email=?" , new String[]{email});
        if(c.getCount()>0){
            return true;
        }else{
            return false;
        }
    }
    public boolean checkUserInfo(String email,String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM admin where email=? and password=?" , new String[]{email,password});
        if(c.getCount()>0){
            return true;
        }else{
            return false;
        }
    }
}
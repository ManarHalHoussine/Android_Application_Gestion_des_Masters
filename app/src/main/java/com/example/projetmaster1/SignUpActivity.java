package com.example.projetmaster1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.projetmaster1.LoginActivity;
import com.example.projetmaster1.mydatabase.MyDatabase;

public class SignUpActivity extends AppCompatActivity {
    EditText nomtxt,prenomtxt,emailtxt,passwordtxt;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inscrire_layout);

        nomtxt = findViewById(R.id.edNom);
        prenomtxt = findViewById(R.id.edPrenom);
        emailtxt = findViewById(R.id.edEmail);
        passwordtxt = findViewById(R.id.edPass);
        btn = findViewById(R.id.inscrirebtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddClient(view);
            }
        });
    }
    public void AddClient(View view) {
        String nom, prenom, email, password;
        nom = nomtxt.getText().toString();
        prenom = prenomtxt.getText().toString();
        email = emailtxt.getText().toString();
        password = passwordtxt.getText().toString();

        if (TextUtils.isEmpty(nom) || TextUtils.isEmpty(prenom) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
            return;
        }

        MyDatabase myDatabase = new MyDatabase(getApplicationContext());
        SQLiteDatabase sqLiteDatabase = myDatabase.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nom", nom);
        values.put("prenom", prenom);
        values.put("email", email);
        values.put("password", password);

        sqLiteDatabase.insert("client", null, values);
        myDatabase.close();

        Toast.makeText(this, "Inscription réussie", Toast.LENGTH_SHORT).show();
    }

}

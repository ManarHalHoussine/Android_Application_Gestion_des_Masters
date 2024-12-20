package com.example.projetmaster1;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetmaster1.interfaces.etudiant.EtudiantActivity;
import com.example.projetmaster1.interfaces.master.Master_activity;
import com.example.projetmaster1.interfaces.module.module_activity;
import com.example.projetmaster1.interfaces.professeur.professeur_activity;

public class dashboard_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Récupérer les boutons
        ImageButton etudiantButton = findViewById(R.id.etudbtn);
        ImageButton profButton = findViewById(R.id.profbtn);
        ImageButton moduleButton = findViewById(R.id.modulebtn);
        ImageButton masterButton = findViewById(R.id.masterbtn);

        // Mettre en place les écouteurs de clic pour chaque bouton
        etudiantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(dashboard_activity.this, EtudiantActivity.class));
            }
        });

        profButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(dashboard_activity.this, professeur_activity.class));
            }
        });

        moduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(dashboard_activity.this, module_activity.class));
            }
        });

        masterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(dashboard_activity.this, Master_activity.class));
            }
        });
    }
}

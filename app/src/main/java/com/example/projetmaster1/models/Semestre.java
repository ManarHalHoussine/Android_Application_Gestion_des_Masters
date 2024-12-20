package com.example.projetmaster1.models;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.projetmaster1.R;
import com.example.projetmaster1.interfaces.module.module_activity;

public class Semestre extends AppCompatActivity {
    Button btnS1, btnS2;
    TextView formationNameTextView; // Ajout de la variable pour le TextView du nom de la formation
    TextView profNameTextView; // Ajout de la variable pour le TextView du nom du professeur
    String nomFormation;
    String nomProf; // Ajout de la variable pour stocker le nom du professeur

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.semestre_layout);

        Bundle bundle = getIntent().getExtras();
        nomFormation = bundle.getString("formation");
        nomProf = bundle.getString("nomProf");
        btnS1 = findViewById(R.id.semester1);
        btnS2 = findViewById(R.id.semester2);
        formationNameTextView = findViewById(R.id.NomFormation);
        profNameTextView = findViewById(R.id.NomProf); // Liaison avec le TextView du nom du professeur

        formationNameTextView.setText(nomFormation);
        profNameTextView.setText(nomProf);

    }

    public void goToModules(View view) {
        Intent intent = new Intent(this, module_activity.class);
        Bundle bundle = new Bundle();
        bundle.putString("formation", nomFormation);
        bundle.putString("nomProf", nomProf); // Ajout du nom du professeur au Bundle
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
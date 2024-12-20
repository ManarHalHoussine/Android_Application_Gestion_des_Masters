package com.example.projetmaster1.interfaces.professeur;



import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetmaster1.Adapter.EnseignantAdapter;
import com.example.projetmaster1.R;
import com.example.projetmaster1.models.Professeur;

import java.util.ArrayList;

public class professeur_activity extends AppCompatActivity {
    EditText nom, master,descriptionn;
    Button valider;

    RecyclerView recyclerView;
    ArrayList<Professeur> clientList;

    EnseignantAdapter enseignantAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajouter_professeur_layout);

        master = findViewById(R.id.masterProf);
        nom= findViewById(R.id.nomProf);
        descriptionn = findViewById(R.id.descriptionProf);
        valider = findViewById(R.id.bt1);

        recyclerView = findViewById(R.id.recycView);
        clientList = new ArrayList<>();

        enseignantAdapter = new EnseignantAdapter(clientList);

        recyclerView.setAdapter(enseignantAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ajouterClient();
            }
        });
    }

    @SuppressLint("NotifyDataSetChanged")
    private void ajouterClient() {
        String masterEnseignant= master.getText().toString();
        String nomEnseignant = nom.getText().toString();
        String description = descriptionn.getText().toString();

        Professeur nouveauClient = new Professeur(masterEnseignant, nomEnseignant, description);
        clientList.add(nouveauClient);

        enseignantAdapter.notifyDataSetChanged();
    }


}

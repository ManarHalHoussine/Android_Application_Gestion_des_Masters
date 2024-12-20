package com.example.projetmaster1.interfaces.etudiant;



import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.projetmaster1.Adapter.EtudiantAdapter;
import com.example.projetmaster1.R;
import com.example.projetmaster1.models.Etudiant;
import java.util.ArrayList;

public class EtudiantActivity extends AppCompatActivity {
    EditText nom, master,prenom,email;
    Button ajouter;

    RecyclerView recyclerView;
    ArrayList<Etudiant> etudiantList;

    EtudiantAdapter etudiantAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.etudiant_layout);
        nom= findViewById(R.id.nomEtud);
        prenom= findViewById(R.id.prenomEtud);
        master = findViewById(R.id.masterEtud);
        email = findViewById(R.id.mailEtud);

        ajouter = findViewById(R.id.bt1);

        recyclerView = findViewById(R.id.recycVie);
        etudiantList = new ArrayList<>();

        etudiantAdapter = new EtudiantAdapter(etudiantList);

        recyclerView.setAdapter(etudiantAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ajouterClient();
            }
        });
    }

    @SuppressLint("NotifyDataSetChanged")
    private void ajouterClient() {

        String nomEtudiant = nom.getText().toString();
        String prenomEtudiant= prenom.getText().toString();
        String emailEtudiant= email.getText().toString();
        String masterEtudiant= master.getText().toString();

        Etudiant nouveauEtudiant = new Etudiant(nomEtudiant, prenomEtudiant, emailEtudiant,masterEtudiant);
        etudiantList.add(nouveauEtudiant);

        etudiantAdapter.notifyDataSetChanged();
    }


}

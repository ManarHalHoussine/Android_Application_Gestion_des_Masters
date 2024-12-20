package com.example.projetmaster1.interfaces.master;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filterable;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.projetmaster1.Adapter.MasterAdapter;
import com.example.projetmaster1.R;
import com.example.projetmaster1.models.Master;

import java.util.ArrayList;

public class Master_activity extends AppCompatActivity {
    private ListView listView;
    private MasterAdapter myAdapter;
    private ArrayList<Master> itemListView;
    private EditText editTextNewMasterName;
    private EditText editTextViewNomProf,description;
    private Button btnAddMaster;
    private boolean isFirstClick = true;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.master_activity_layout);
        listView = findViewById(R.id.listmaster);
        btnAddMaster = findViewById(R.id.addmasterbtn);
        editTextNewMasterName = findViewById(R.id.editTextNewMasterName);
        description = findViewById(R.id.description);
        editTextViewNomProf = findViewById(R.id.editTextViewNomProf); // Ajout de la référence pour le TextViewNomProf
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) SearchView searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (listView.getAdapter() instanceof Filterable) {
                    ((Filterable) listView.getAdapter()).getFilter().filter(newText);
                }
                return true;
            }
        });

        itemListView = new ArrayList<>();
        itemListView.add(new Master("WISD", "Pr.ALI YAHYAUOI","double diplomation"));
        itemListView.add(new Master("MIDVI","Pr.HASSAN SATORI","une diplomation"));
        itemListView.add(new Master("MQL","Pr.NOURDDINE CHANFOUR","Devellopement"));
        itemListView.add(new Master("MLAIM","Pr.JAMAL RIFFI","IA  CyberSecurity"));
        itemListView.add(new Master("BDSAS","Pr.HABIB NEFAOUI","Data scientist"));

        myAdapter = new MasterAdapter(this, R.layout.master_layout, itemListView);
        listView.setAdapter(myAdapter);

        btnAddMaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFirstClick) {
                    editTextNewMasterName.setVisibility(View.VISIBLE);
                    editTextViewNomProf.setVisibility(View.VISIBLE);
                    isFirstClick = false;
                } else {
                    String newMasterName = editTextNewMasterName.getText().toString();
                    String newProf = editTextViewNomProf.getText().toString();
                    String description = editTextViewNomProf.getText().toString();
                    itemListView.add(new Master(newMasterName, newProf,description));
                    myAdapter.notifyDataSetChanged();

                    isFirstClick = true;
                    editTextNewMasterName.setVisibility(View.GONE);
                    editTextViewNomProf.setVisibility(View.GONE);
                    editTextNewMasterName.setText("");
                    editTextViewNomProf.setText("");
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Master_activity.this, Semester.class);
                Bundle b = new Bundle();
                Master master = (Master) listView.getAdapter().getItem(position);
                Master prof = (Master) listView.getAdapter().getItem(position);
                Master description = (Master) listView.getAdapter().getItem(position);
                b.putString("master", master.getNom());
                b.putString("coordinateur", prof.getCoordinateur());
                b.putString("description", prof.getDescription());

                intent.putExtras(b);
                startActivity(intent);
            }
        });

    }

    public void go_to_cours(View view) {
        // Your code for handling button click
    }
}
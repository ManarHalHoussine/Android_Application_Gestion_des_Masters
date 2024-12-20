package com.example.projetmaster1.interfaces.module;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.text.TextUtils;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.projetmaster1.R;
import com.example.projetmaster1.models.cour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
    public class module_activity extends AppCompatActivity {
        TextView semestre, nomFormation;
        ListView listModule;
        EditText searchBar;
        Button addModuleButton;
        String nomFormat;
        List<String> moduleList;
        ArrayAdapter<String> adapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.module_activity_layout);

            //nomFormation = findViewById(R.id.nomFormationInM);
            //semestre = findViewById(R.id.semesterInM);
            listModule = findViewById(R.id.modulListview);
            searchBar = findViewById(R.id.searchBar);
            addModuleButton = findViewById(R.id.addmodulebtn);

            //Bundle bundle = getIntent().getExtras();
            //nomFormat = bundle.getString("formation");
            //nomFormation.setText(nomFormat);

            // Initialize your module list
            String[] modules = {"JEE", "Web design", "RO", "Web mobile"};
            moduleList = new ArrayList<>(Arrays.asList(modules));

            // Initialize the adapter with the module list
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, moduleList);
            listModule.setAdapter(adapter);

            // Set click listener for list items
            listModule.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String module = moduleList.get(position);
                    Intent intent = new Intent(module_activity.this, cour.class);
                    Bundle b = new Bundle();
                    b.putString("module", module);
                    intent.putExtras(b);
                    startActivity(intent);
                }
            });

            // Set text change listener for the search bar
            searchBar.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    // Not used in this example
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    // Filter the module list based on the search text
                    adapter.getFilter().filter(charSequence.toString());
                }

                @Override
                public void afterTextChanged(Editable editable) {
                    // Not used in this example
                }
            });

            // Set click listener for the add module button
            addModuleButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Utiliser une boîte de dialogue pour recueillir le nom du nouveau module
                    AlertDialog.Builder builder = new AlertDialog.Builder(module_activity.this);
                    builder.setTitle("Ajouter un nouveau module");

                    // Créer un champ d'édition dans la boîte de dialogue
                    final EditText input = new EditText(module_activity.this);
                    input.setInputType(InputType.TYPE_CLASS_TEXT);
                    builder.setView(input);

                    // Ajouter des boutons "Annuler" et "Ajouter" à la boîte de dialogue
                    builder.setPositiveButton("Ajouter", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // Récupérer le texte saisi par l'utilisateur
                            String newModule = input.getText().toString().trim();

                            // Vérifier si le texte n'est pas vide

                            if (!TextUtils.isEmpty(newModule)) {
                                // Ajouter le nouveau module à la liste et mettre à jour l'adaptateur
                                moduleList.add(newModule);
                                adapter.notifyDataSetChanged();
                            } else {
                                // Afficher un message d'erreur si le texte est vide
                                Toast.makeText(module_activity.this, "Veuillez entrer le nom du module", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    builder.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // Annuler la boîte de dialogue
                            dialog.cancel();
                        }
                    });

                    // Afficher la boîte de dialogue
                    builder.show();
                }
            });

        }
    }


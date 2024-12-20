package com.example.projetmaster1.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.projetmaster1.R;
import com.example.projetmaster1.models.Etudiant;
import java.util.ArrayList;

public class EtudiantAdapter extends RecyclerView.Adapter<EtudiantAdapter.EtudiantViewHolder> {

    private ArrayList<Etudiant> etudiantList;

    public EtudiantAdapter(ArrayList<Etudiant> etudiantList) {
        this.etudiantList = etudiantList;
    }

    @Override
    public EtudiantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_etudiant, parent, false);
        return new EtudiantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EtudiantViewHolder holder, int position) {

        Etudiant etudiant= etudiantList.get(position);


        holder.master.setText(etudiant.getMaster());
        holder.nom.setText(etudiant.getNom());
        holder.email.setText(etudiant.getEmail());
        holder.prenom.setText(etudiant.getPrenom());
    }

    @Override
    public int getItemCount() {
        return etudiantList.size();
    }

    public class EtudiantViewHolder extends RecyclerView.ViewHolder {
        TextView master, nom, prenom,email;

        public EtudiantViewHolder(View itemView) {
            super(itemView);
            prenom = itemView.findViewById(R.id.prenomEtud);
            nom = itemView.findViewById(R.id.nomEtud);
            master = itemView.findViewById(R.id.masterEtud);
            email = itemView.findViewById(R.id.mailEtud);
        }
    }

}



package com.example.projetmaster1.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.projetmaster1.R;
import com.example.projetmaster1.models.Professeur;

import java.util.ArrayList;

public class EnseignantAdapter extends RecyclerView.Adapter<EnseignantAdapter.EnseignantViewHolder> {

    private ArrayList<Professeur> clientList;

    public EnseignantAdapter(ArrayList<Professeur> clientList) {
        this.clientList = clientList;
    }

    @Override
    public EnseignantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_professeur, parent, false);
        return new EnseignantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EnseignantViewHolder holder, int position) {

        Professeur client = clientList.get(position);


        holder.master.setText(client.getMaster());
        holder.nom.setText(client.getNom());
        holder.descriptiion.setText(client.getDescription());
    }

    @Override
    public int getItemCount() {
        return clientList.size();
    }

    public class EnseignantViewHolder extends RecyclerView.ViewHolder {
        TextView master, nom, descriptiion;

        public EnseignantViewHolder(View itemView) {
            super(itemView);
            master = itemView.findViewById(R.id.masterProf);
            nom = itemView.findViewById(R.id.nomProf);
            descriptiion = itemView.findViewById(R.id.descriptionProf);
        }
    }

}



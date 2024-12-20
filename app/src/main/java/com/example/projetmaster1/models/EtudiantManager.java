package com.example.projetmaster1.models;

import java.util.ArrayList;
import java.util.List;

public class EtudiantManager {
    private static EtudiantManager instance;
    private List<Etudiant> etudiantList;

    private EtudiantManager() {
        etudiantList = new ArrayList<>();
    }

    public static synchronized EtudiantManager getInstance() {
        if (instance == null) {
            instance = new EtudiantManager();
        }
        return instance;
    }

    public List<Etudiant> getEtudiantList() {
        return etudiantList;
    }

    public void addEtudiant(Etudiant etudiant) {
        etudiantList.add(etudiant);
    }
}


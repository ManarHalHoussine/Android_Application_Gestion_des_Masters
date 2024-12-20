package com.example.projetmaster1.models;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetmaster1.R;

import com.github.barteksc.pdfviewer.PDFView;

public class cour extends AppCompatActivity {
    PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cour_activity);

        Bundle b=getIntent().getExtras();
        String module=b.getString("module");
       pdfView=findViewById(R.id.pdfView);
        pdfView.fromAsset("JSP.pdf").load();
    }
}
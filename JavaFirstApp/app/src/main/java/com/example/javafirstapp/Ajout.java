package com.example.javafirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Ajout extends AppCompatActivity implements View.OnClickListener {
    EditText nom_txt,prenom_txt,telephone_txt;
    Button ajouter_btn,quitter_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);
        nom_txt= (EditText) findViewById(R.id.nom_txt);
        prenom_txt= (EditText) findViewById(R.id.prenom_txt);
        telephone_txt = (EditText) findViewById(R.id.phone_txt);
        ajouter_btn = (Button) findViewById(R.id.ajouter_btn);
        quitter_btn = (Button) findViewById(R.id.quitter_btn);
        ajouter_btn.setOnClickListener(this);
        quitter_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v==ajouter_btn){
            COntact user = new COntact(nom_txt.getText().toString(),prenom_txt.getText().toString(),telephone_txt.getText().toString());
            Acceuill.data.add(user);
            Toast.makeText(this,"User"+nom_txt.getText().toString() +" has been aded" , Toast.LENGTH_LONG);
            Toast.makeText(this,"taille tot= "+Acceuill.data.size(),Toast.LENGTH_LONG).show();

        }
        else{
            this.finish();
        }

    }
}

package com.example.javafirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateUser extends AppCompatActivity implements View.OnClickListener {
    EditText nom ;
    EditText prenom ;
    EditText telph ;
    Button update_btn;
    Button cancel_btn;
    int indice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);
        nom= (EditText) findViewById(R.id.nom_txt);
        prenom= (EditText) findViewById(R.id.prenom_txt);
        telph= (EditText) findViewById(R.id.phone_txt);
        update_btn = (Button) findViewById((R.id.update_btn));
        cancel_btn = (Button) findViewById((R.id.cancel_btn));


        Intent x = this.getIntent();
        Bundle intent_infos= x.getExtras();
        String user_name=intent_infos.getString("nom_user");
       String user_prname=intent_infos.getString("prenom_user");
        String user_tel=intent_infos.getString("tel_user");
        indice=Integer.parseInt(intent_infos.getString("indice"));


        nom.setText(user_name);
        /*prenom.setText(user_prname);
        telph.setText(user_tel);*/

        update_btn.setOnClickListener(UpdateUser.this);
        cancel_btn.setOnClickListener(UpdateUser.this);

    }
    void update_user(String nom , String prenom ,String tel , int index){
        Acceuill.data.get(index).setNom(nom);
        Acceuill.data.get(index).setPrenom(prenom);
        Acceuill.data.get(index).setNum_tel(tel);

    }

    @Override
    public void onClick(View v) {
        if(v==update_btn){
            this.update_user(nom.getText().toString() , prenom.getText().toString()  ,telph.getText().toString()  ,indice);
            Intent i = new Intent(UpdateUser.this , Acceuill.class);
            startActivity(i);

        }
        else{

        }
    }
}

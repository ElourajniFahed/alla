package com.example.javafirstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
// cycle de vie de n'importe quel activity oncreate - start - stoped -resume - destroy


public class Acceuill extends AppCompatActivity implements View.OnClickListener {
    Button ajouter_btn ;
    Button afficher_btn;
    EditText name_txt;
    static  ArrayList<COntact> data = new ArrayList<>();
    String dir = Environment.getExternalStorageDirectory().getPath();// avoir le pathe de ressource du stockage externe

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuill);
        ajouter_btn = (Button) findViewById(R.id.ajout_btn);
        afficher_btn=(Button) findViewById(R.id.afficher_btn);
        name_txt = (EditText) findViewById(R.id.name_txt);
        Intent x = this.getIntent();
        Bundle b = x.getExtras();
        String user=b.getString("nameuser");
        name_txt.setText(user);
        ajouter_btn.setOnClickListener(this);
        afficher_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==ajouter_btn){
            Intent nav = new Intent(Acceuill.this,Ajout.class);
            startActivity(nav);

        }
        else{
            Toast.makeText(this,"data sended is : " +name_txt.getText().toString(),Toast.LENGTH_LONG);
            Intent nav = new Intent(Acceuill.this,Afficher.class);
            startActivity(nav);
        }
    }
public void save(){
    try{

        File f = new File(dir,"fichier.txt");
        FileWriter fw=new FileWriter(f,false); // false = ne efface pas le contenu avancé
        BufferedWriter bf = new BufferedWriter(fw);
        for(int i=0;i< Acceuill.data.size();i++){
            bf.write(data.get(i).getNom()+"#"+data.get(i).getPrenom()+"#"+data.get(i).getNum_tel()+"/n");

        }
        bf.close();
        fw.close();}
    catch (Exception e){
        Log.e("msg",e.getMessage());
    }

}

public void upload(){
    if(ContextCompat.checkSelfPermission(Acceuill.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
        //Permession non autorisé
        ActivityCompat.requestPermissions(Acceuill.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
    }
    try{
        File f = new File(dir,"fichier.txt");
        FileReader fr=new FileReader(f); // false = ne efface pas le contenu avancé
        BufferedReader bf = new BufferedReader(fr);
        String line = null;
        while ((line=bf.readLine())!=null){
            String[] donne= line.split("#")  ;
            data.add(new COntact(donne[0],donne[1],donne[2]));
        }
        bf.close();
        fr.close();}
    catch (Exception e){
        Log.e("msg",e.getMessage());
    }

}
    @Override
    protected void onStart() {
        super.onStart();
        upload();

    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        save();
        super.onDestroy();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==100){
            if((grantResults.length>0) && (grantResults[0]==PackageManager.PERMISSION_GRANTED)){
                Toast.makeText(Acceuill.this,"Permession autorisé",Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(Acceuill.this,"Permession non autorisé",Toast.LENGTH_SHORT).show();

            }
        }
    }
}

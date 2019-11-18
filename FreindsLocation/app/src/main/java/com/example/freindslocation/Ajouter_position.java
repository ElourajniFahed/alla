package com.example.freindslocation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Ajouter_position extends AppCompatActivity implements View.OnClickListener {
    EditText nom_edt ;
    EditText long_edt ;
    EditText lat_edt;
    Button ajouter_btn,quitter_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_position);
        nom_edt =(EditText) findViewById(R.id.nom_edtxt);
        long_edt =(EditText) findViewById(R.id.long_edtxt);
        lat_edt=(EditText) findViewById(R.id.lat_edtxt);
        ajouter_btn=(Button) findViewById(R.id.ajouter_btn);
        quitter_btn=(Button) findViewById(R.id.quitter_btn);
        ajouter_btn.setOnClickListener(this);
        quitter_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == ajouter_btn){
            //ajouter a la base sqllite
            ContentValues values = new ContentValues();
            values.put(MyPositionHelper.column_name,nom_edt.getText().toString());
            values.put(MyPositionHelper.column_lang,long_edt.getText().toString());
            values.put(MyPositionHelper.column_lat,lat_edt.getText().toString());
             long i=MainActivity.bd.insert(MyPositionHelper.table,null,values);
            //Toast.makeText(this,"insertion valide",Toast.LENGTH_LONG).show();
            Toast.makeText(this,i+nom_edt.getText().toString()+" "+long_edt.getText().toString()+" "+lat_edt.getText(),Toast.LENGTH_LONG).show();
        }
        else{
            this.finish();
        }
    }

    public static class Contact {

        String nom;
        String longitude;
        String latitude;

        public Contact(String nom, String longitude, String latitude) {
            this.nom = nom;
            this.longitude = longitude;
            this.latitude = latitude;
        }

        @Override
        public String toString() {
            return "com.example.freindslocation.Ajouter_position.Contact{" +
                    "nom='" + nom + '\'' +
                    ", longitude='" + longitude + '\'' +
                    ", latitude='" + latitude + '\'' +
                    '}';
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getNom() {
            return nom;
        }

        public String getLongitude() {
            return longitude;
        }

        public String getLatitude() {
            return latitude;
        }
    }
}

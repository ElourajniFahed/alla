package com.example.javafirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b_val;
    Button b_quit;
    EditText ed_name;
    EditText ed_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b_val = (Button) findViewById(R.id.b_valider);
        b_quit=(Button) findViewById(R.id.b_quitter);
        ed_name =(EditText) findViewById(R.id.ed_nom);
        ed_password =(EditText) findViewById(R.id.ed_password);
        // ajouter ecouteur
        b_val.setOnClickListener(this);
        b_quit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == b_quit){
            MainActivity.this.finish();
        }
        if(v== b_val){
            Toast.makeText(this, "HELLO" +ed_name.getText().toString()+" your password is "+ed_password.getText().toString(), Toast.LENGTH_LONG).show();
            Intent i = new Intent(MainActivity.this , Acceuill.class);
            i.putExtra("nameuser",ed_name.getText().toString());
            startActivity(i);


        }

    }
}

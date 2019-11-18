package com.example.freindslocation;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
 RecyclerView contact_recycle_view;
 MonAdapter monad;
 ArrayList<Contact> data=new ArrayList<Contact>();
 public static SQLiteDatabase bd;

    @Override
    protected void onStart() {
        super.onStart();
        data.clear();


        Cursor cursor =MainActivity.bd.query(MyPositionHelper.table,new String[]{MyPositionHelper.column_name,MyPositionHelper.column_lang,MyPositionHelper.column_lat},null,null,null,null,null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            String nom =cursor.getString(0);
            String longi =cursor.getString(1);
            String lat =cursor.getString(2);
            Contact user = new Contact(nom,longi,lat);
            this.data.add(user);
            cursor.moveToNext();
        }
        //monad = new MonAdapter(this,this.data);
        //ArrayAdapter monad = new ArrayAdapter(this, android.R.layout.simple_list_item_1, this.data);
       // liste_view.setAdapter(monad);
        MyRecycleViewAdapter recycle_adapter= new MyRecycleViewAdapter(this, this.data);

        contact_recycle_view.setAdapter(recycle_adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyPositionHelper helper=new MyPositionHelper(MainActivity.this,"freindslocation_base.db",null,1);
        bd=helper.getWritableDatabase();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        contact_recycle_view = (RecyclerView) findViewById(R.id.contact_recycle_view);
        Contact c1 = new Contact("fahed","546","123");
        contact_recycle_view.setHasFixedSize(true);// all of element in the recylce view taille fixe .
        //contact_recycle_view.setLayoutManager(new LinearLayoutManager(MainActivity.this));// linear layou est le type d'affichage
        contact_recycle_view.setLayoutManager(new GridLayoutManager(this,2));// linear layou est le type d'affichage


        //data.add(c1);data.add(c1);data.add(c1);data.add(c1);data.add(c1);data.add(c1);

        //.setOnItemClickListener(this);








        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent i = new Intent(MainActivity.this , Ajouter_position.class);
                //i.putExtra("nameuser",ed_name.getText().toString());
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


    }
}

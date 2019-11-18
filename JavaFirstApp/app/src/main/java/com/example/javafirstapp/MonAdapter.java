package com.example.javafirstapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.javafirstapp.Acceuill;

import java.security.acl.AclEntry;
import java.util.ArrayList;

public class MonAdapter extends BaseAdapter {
    Context c;
    ArrayList<COntact> data;
    public MonAdapter(Context c, ArrayList<COntact> data){
        this.c=c;
        this.data=data;

    }
    @Override
    public int getCount() { //renvoie le nembre des element a afficher
        return data.size();
    }

    @Override
    public Object getItem(int position) {//
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // pour chaue ligne de donnes on vas effectuer ce traitement
       /* TextView tv= new TextView(c);//#######
        tv.setText(data.get(position).toString());*///###########
        LayoutInflater inf = LayoutInflater.from(c);//layout inflater allow you to communicate with the xml file in order to use it
        LinearLayout l = (LinearLayout) inf.inflate(R.layout.layout,null); // determiner le layout que vas utiliser
        TextView nom_txt=l.findViewById(R.id.tv_nom);
        TextView prenom_txt=l.findViewById(R.id.tv_prenom);
        TextView tel_txt=l.findViewById(R.id.tv_telf);
        nom_txt.setText(data.get(position).getNom());
        prenom_txt.setText(data.get(position).getPrenom());
        tel_txt.setText(data.get(position).getNum_tel());

        return l;
    }

}

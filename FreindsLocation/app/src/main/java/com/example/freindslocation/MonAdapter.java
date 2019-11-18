package com.example.freindslocation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MonAdapter extends BaseAdapter {
    Context c;
    ArrayList<Contact> data;
    public MonAdapter(Context c, ArrayList<Contact> data){
        this.c=c;
        this.data=data;

    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inf = LayoutInflater.from(c);//layout inflater allow you to communicate with the xml file in order to use it
        LinearLayout l = (LinearLayout) inf.inflate(R.layout.activity_user_info_layout,null); // determiner le layout que vas utiliser
        TextView nom_txt=l.findViewById(R.id.nom_txt);
        TextView lat_txt=l.findViewById(R.id.lat_txt);
        TextView long_txt=l.findViewById(R.id.long_txt);
        nom_txt.setText(data.get(position).getNom());
        lat_txt.setText(data.get(position).getLatitude());
        long_txt.setText(data.get(position).getLongitude());

        return l;    }
}

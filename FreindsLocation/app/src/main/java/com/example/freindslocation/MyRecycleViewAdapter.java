package com.example.freindslocation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.MyviewHolder> {

    ArrayList<Contact> data;
    Context c;

    public MyRecycleViewAdapter( Context c,ArrayList<Contact> data) {
        this.data = data;
        this.c = c;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inf = LayoutInflater.from(c);//layout inflater allow you to communicate with the xml file in order to use it
        LinearLayout l = (LinearLayout) inf.inflate(R.layout.activity_user_info_layout,null); // determiner le layout que vas utiliser
        return new MyviewHolder(l);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        // when update
        holder.nom_txt.setText(data.get(position).getNom());
        holder.lat_txt.setText(data.get(position).getLatitude());
        holder.long_txt.setText(data.get(position).getLongitude());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyviewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView nom_txt,long_txt,lat_txt;
        ImageButton email_btn,sms_btn,call_btn,exit_btn,map_btn;
        public MyviewHolder(LinearLayout l) {
            super(l);
            nom_txt=l.findViewById(R.id.nom_txt);
            long_txt=l.findViewById(R.id.long_txt);
            lat_txt=l.findViewById(R.id.lat_txt);
            email_btn=l.findViewById(R.id.email_btn);
            sms_btn=l.findViewById(R.id.sms_btn);
            call_btn=l.findViewById(R.id.call_btn);
            exit_btn=l.findViewById(R.id.exit_btn);
            map_btn=l.findViewById(R.id.map_btn);
            exit_btn.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(v==exit_btn){
                MainActivity.bd.execSQL("Delete from "+MyPositionHelper.table+" where "+MyPositionHelper.column_name+" = "+nom_txt.getText()+" "+MyPositionHelper.column_lat+" ="+lat_txt.getText()+" "+MyPositionHelper.column_lang+" ="+long_txt.getText());

                //MainActivity.bd.delete(MyPositionHelper.table," "+MyPositionHelper.column_name+" = "+nom_txt.getText()+" "+MyPositionHelper.column_lat+" ="+lat_txt.getText()+" "+MyPositionHelper.column_lang+" ="+long_txt.getText())


            }

        }
    }
}

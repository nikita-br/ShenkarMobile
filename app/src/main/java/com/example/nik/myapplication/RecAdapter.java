package com.example.nik.myapplication;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.support.v4.content.ContextCompat.startActivity;

class RecAdapter extends RecyclerView.Adapter<RecAdapter.ViewHolder> {

    ArrayList<String> exersises;

    public RecAdapter(ArrayList<String> exersises) {
        this.exersises = exersises;
    }

    @NonNull
    @Override
    public RecAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.exrow,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecAdapter.ViewHolder holder, final int position) {
        holder.name.setText(exersises.get(position));
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                //Toast.makeText(v.getContext(), "Recycle Click" + position, Toast.LENGTH_SHORT).show();
                if(position==0) {
                    v.getContext().startActivity(new Intent(v.getContext(), Calculator.class));
                }
                if(position==1) {
                    v.getContext().startActivity(new Intent(v.getContext(), birthdayActivity.class));
                }



            }
        });
    }

    @Override
    public int getItemCount() {
        return exersises.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.exname);
        }
    }




}

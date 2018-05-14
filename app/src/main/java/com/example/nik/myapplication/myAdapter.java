package com.example.nik.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class myAdapter extends RecyclerView.Adapter<myAdapter.ViewHolder> {
    List<Student> students;

    public myAdapter(List<Student> students) {
        this.students = students;
    }

    @NonNull
    @Override
    public myAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_row,parent,false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myAdapter.ViewHolder holder, int position) {
        holder.name.setText(students.get(position).getName());
       // holder.day.setText((students.get(position).getDate().substring(0,students.get(position).getDate().length()-5)));
        holder.day.setText((students.get(position).getDate()));
        holder.year.setText((students.get(position).getGil()));

    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView day;
        public TextView year;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            day = itemView.findViewById(R.id.day);
            year = itemView.findViewById(R.id.year);
        }
    }
}

package com.example.recyclerviewproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerStudentAdapter extends RecyclerView.Adapter<RecyclerStudentAdapter.ViewHolder> {

    final ArrayList<StudentModel> arrStudent;

    RecyclerStudentAdapter(ArrayList<StudentModel> arrStudent) {
        this.arrStudent = arrStudent;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.ivStudentImg.setImageResource(arrStudent.get(position).img);
        holder.tvStudentName.setText(arrStudent.get(position).name);
        holder.tvStudentAddress.setText(arrStudent.get(position).address+" [Id No. : "+position+"]");
    }

    @Override
    public int getItemCount() {
        return arrStudent.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView tvStudentName;
        final TextView tvStudentAddress;
        final ImageView ivStudentImg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivStudentImg = itemView.findViewById(R.id.ivStudentImg);
            tvStudentName = itemView.findViewById(R.id.tvStudentName);
            tvStudentAddress = itemView.findViewById(R.id.tvStudentAddress);
        }
    }
}

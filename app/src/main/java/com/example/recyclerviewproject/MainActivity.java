package com.example.recyclerviewproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final ArrayList<StudentModel> arrStudent = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerViewStudent = findViewById(R.id.recyclerViewStudent);

        recyclerViewStudent.setLayoutManager(new LinearLayoutManager(this));

        arrStudent.add(new StudentModel(R.drawable.ic_baseline_person_24, "Satish", "Bihar"));
        arrStudent.add(new StudentModel(R.drawable.ic_baseline_person_24, "Satish", "Bihar"));
        arrStudent.add(new StudentModel(R.drawable.ic_baseline_person_24, "Satish", "Bihar"));
        arrStudent.add(new StudentModel(R.drawable.ic_baseline_person_24, "Satish", "Bihar"));
        arrStudent.add(new StudentModel(R.drawable.ic_baseline_person_24, "Satish", "Bihar"));
        arrStudent.add(new StudentModel(R.drawable.ic_baseline_person_24, "Satish", "Bihar"));
        arrStudent.add(new StudentModel(R.drawable.ic_baseline_person_24, "Satish", "Bihar"));
        arrStudent.add(new StudentModel(R.drawable.ic_baseline_person_24, "Satish", "Bihar"));
        arrStudent.add(new StudentModel(R.drawable.ic_baseline_person_24, "Satish", "Bihar"));
        arrStudent.add(new StudentModel(R.drawable.ic_baseline_person_24, "Satish", "Bihar"));
        arrStudent.add(new StudentModel(R.drawable.ic_baseline_person_24, "Satish", "Bihar"));
        arrStudent.add(new StudentModel(R.drawable.ic_baseline_person_24, "Satish", "Bihar"));
        arrStudent.add(new StudentModel(R.drawable.ic_baseline_person_24, "Satish", "Bihar"));
        arrStudent.add(new StudentModel(R.drawable.ic_baseline_person_24, "Satish", "Bihar"));
        arrStudent.add(new StudentModel(R.drawable.ic_baseline_person_24, "Satish", "Bihar"));
        arrStudent.add(new StudentModel(R.drawable.ic_baseline_person_24, "Satish", "Bihar"));
        arrStudent.add(new StudentModel(R.drawable.ic_baseline_person_24, "Satish", "Bihar"));
        arrStudent.add(new StudentModel(R.drawable.ic_baseline_person_24, "Satish", "Bihar"));
        arrStudent.add(new StudentModel(R.drawable.ic_baseline_person_24, "Satish", "Bihar"));
        arrStudent.add(new StudentModel(R.drawable.ic_baseline_person_24, "Satish", "Bihar"));
        arrStudent.add(new StudentModel(R.drawable.ic_baseline_person_24, "Satish", "Bihar"));
        arrStudent.add(new StudentModel(R.drawable.ic_baseline_person_24, "Satish", "Bihar"));
        arrStudent.add(new StudentModel(R.drawable.ic_baseline_person_24, "Satish", "Bihar"));
        arrStudent.add(new StudentModel(R.drawable.ic_baseline_person_24, "Satish", "Bihar"));
        arrStudent.add(new StudentModel(R.drawable.ic_baseline_person_24, "Satish", "Bihar"));
        arrStudent.add(new StudentModel(R.drawable.ic_baseline_person_24, "Satish", "Bihar"));
        arrStudent.add(new StudentModel(R.drawable.ic_baseline_person_24, "Satish", "Bihar"));
        arrStudent.add(new StudentModel(R.drawable.ic_baseline_person_24, "Satish", "Bihar"));
        arrStudent.add(new StudentModel(R.drawable.ic_baseline_person_24, "Satish", "Bihar"));
        arrStudent.add(new StudentModel(R.drawable.ic_baseline_person_24, "Satish", "Bihar"));
        arrStudent.add(new StudentModel(R.drawable.ic_baseline_person_24, "Satish", "Bihar"));

        RecyclerStudentAdapter recyclerStudentAdapter = new RecyclerStudentAdapter(this, arrStudent);
        recyclerViewStudent.setAdapter(recyclerStudentAdapter);

    }
}
package com.example.recyclerviewproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final ArrayList<StudentModel> studentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerViewStudent = findViewById(R.id.recyclerViewStudent);

        recyclerViewStudent.setLayoutManager(new LinearLayoutManager(this));

        for(int i = 0; i < 10000; i++){
            studentList.add(new StudentModel(R.drawable.ama_bw_128, "Satish", "satish@anshumemorial.in"));
        }

        RecyclerStudentAdapter recyclerStudentAdapter = new RecyclerStudentAdapter(studentList);
        recyclerViewStudent.setAdapter(recyclerStudentAdapter);

        Button btnUserPage = findViewById(R.id.btn_user_page);
        btnUserPage.setOnClickListener(view -> {
            Intent intent = new Intent(this, UserActivity.class);
            startActivity(intent);
        });
    }
}
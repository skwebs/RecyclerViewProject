package com.example.recyclerviewproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setTitle("Home Page");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnUserPage = findViewById(R.id.btn_user_page);
        Button btnUserPage2 = findViewById(R.id.btn_user_page2);

        btnUserPage.setOnClickListener(view -> {
            Intent intent = new Intent(this, UserActivity.class);
            startActivity(intent);
        });

        btnUserPage2.setOnClickListener(view -> {
            Intent intent = new Intent(this, UserActivity2.class);
            startActivity(intent);
        });
    }
}
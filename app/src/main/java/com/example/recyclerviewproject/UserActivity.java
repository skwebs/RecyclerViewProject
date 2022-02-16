package com.example.recyclerviewproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserActivity extends AppCompatActivity {

    final ArrayList<UserModel> userList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Button btnMainPage = findViewById(R.id.btn_main_page);
        btnMainPage.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        RecyclerView userRecyclerView = findViewById(R.id.user_recycler_view);
        userRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        for (int i = 0; i < 100; i++) {
            userList.add(new UserModel("Satish", "satish@anshumemorial.in"));
        }

        UserAdapter userAdapter = new UserAdapter(userList);
        userRecyclerView.setAdapter(userAdapter);
    }

}
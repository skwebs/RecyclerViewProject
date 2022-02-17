package com.example.recyclerviewproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class UserActivity extends AppCompatActivity {

    private static final String TAG = "UserActivity:";
    final ArrayList<UserModel> userList = new ArrayList<>();
    RequestQueue requestQueue;
    RecyclerView userRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        requestQueue = VolleySingleton.getInstance(this).getRequestQueue();
        userRecyclerView = findViewById(R.id.user_recycler_view);
        userRecyclerView.setHasFixedSize(true);
        Button btnMainPage = findViewById(R.id.btn_main_page);
        btnMainPage.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        getUserDetails();
    }

    private void getUserDetails() {

        String url = "https://anshumemorial.in/lv8_api/api/users";
        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                response -> {

                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            String name = jsonObject.getString("name");
                            String email = jsonObject.getString("email");

                            userList.add(new UserModel(name, email));

                            Log.d(TAG, "Name: " + name + ", email: " + email);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        userList.add(new UserModel("Satish", "satish@anshumemorial.in"));
                    }

                    userRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    UserAdapter userAdapter = new UserAdapter(this, userList);
                    userRecyclerView.setAdapter(userAdapter);

                }, Throwable::printStackTrace);

        requestQueue.add(jsonObjectRequest);
    }

}
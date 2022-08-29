package com.example.recyclerviewproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class UserActivity2 extends AppCompatActivity {



    private static final String TAG = "UserActivity2:";
    final ArrayList<UserModel> userList = new ArrayList<>();
    RequestQueue requestQueue;
    RecyclerView userRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user2);


        requestQueue = VolleySingleton.getInstance(this).getRequestQueue();
        userRecyclerView = findViewById(R.id.user_recycler_view);
        userRecyclerView.setHasFixedSize(true);

        getUserDetails();
    }

    private void getUserDetails() {
        ProgressDialog progressDialog = ProgressDialog.show(this,null,"Please wait");
        String url = "https://anshumemorial.in/lv9api/api/auth/user";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                response -> {
                    try {
                        JSONArray dataArray = response.getJSONArray("data");

                        for (int i = 0; i < dataArray.length(); i++) {
                            try {
                                JSONObject jsonObject = dataArray.getJSONObject(i);
                                String name = jsonObject.getString("name");
                                String email = jsonObject.getString("email");

                                userList.add(new UserModel(name, email));

                                Log.d(TAG, "Name: " + name + ", email: " + email);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                    userRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    UserAdapter userAdapter = new UserAdapter(this, userList);
                    userRecyclerView.setAdapter(userAdapter);

                    if(progressDialog!=null && progressDialog.isShowing())
                        progressDialog.dismiss();

                }, error -> {
            if(progressDialog!=null && progressDialog.isShowing())
                progressDialog.dismiss();
            Log.d(TAG, "getUserDetails: "+error);
        });

        requestQueue.add(jsonObjectRequest);
    }
}
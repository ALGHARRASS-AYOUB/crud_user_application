package com.example.crud_school_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView informationRV;
    Button add_user;
    ArrayList<User> users;
    UserDBHelper userDBHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        informationRV=findViewById(R.id.users);
        add_user=findViewById(R.id.add_user);

        users=userDBHelper.getAllUsers();

        //showing information in the recycle view
        informationRV.setLayoutManager(new LinearLayoutManager(this));



        Intent addUserIntent=new Intent(this,changeInfo.class);





    }
}
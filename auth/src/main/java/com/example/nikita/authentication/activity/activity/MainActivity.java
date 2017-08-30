package com.example.nikita.authentication.activity.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.nikita.authentication.R;
import com.example.nikita.authentication.activity.model.UserAthentication;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public ArrayList<UserAthentication> itemsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}

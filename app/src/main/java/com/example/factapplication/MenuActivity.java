package com.example.factapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void goToChoicepoint(View view) {
        setContentView(R.layout.activity_choicepoint);
    }

    public void goToBullseye(View view) {
        setContentView(R.layout.activity_bullseye);
    }
}
package com.example.factapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MenuActivity extends AppCompatActivity {
    Button switchToBullseye;
    Button switchToChoicepoint;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        switchToBullseye = findViewById(R.id.bullseyeButton);
        switchToBullseye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToBullseye();
            }
        });

        switchToChoicepoint = findViewById(R.id.choicePointButton);
        switchToChoicepoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToChoicepoint();
            }
        });
    }

    public void goToChoicepoint() {
        Intent switchActivityIntent = new Intent(this, ChoicepointActivity.class);
        startActivity(switchActivityIntent);
    }

    public void goToBullseye() {
        Intent switchActivityIntent = new Intent(this, BullseyeActivity.class);
        startActivity(switchActivityIntent);
    }
}
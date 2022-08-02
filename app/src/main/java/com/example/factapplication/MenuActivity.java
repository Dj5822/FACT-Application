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

        // Code related to bullseye testing.
        final RelativeLayout rr = (RelativeLayout) findViewById(R.id.rr);
        rr.setOnTouchListener(new View.OnTouchListener() {

            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    int x = (int) event.getX();
                    int y = (int) event.getY();
                    RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                            RelativeLayout.LayoutParams.WRAP_CONTENT,
                            RelativeLayout.LayoutParams.WRAP_CONTENT);
                    ImageView iv = new ImageView(getApplicationContext());
                    lp.setMargins(x, y, 0, 0);
                    iv.setLayoutParams(lp);
                    iv.setImageDrawable(getResources().getDrawable(
                            androidx.constraintlayout.widget.R.drawable.abc_ab_share_pack_mtrl_alpha));
                    ((ViewGroup) v).addView(iv);
                }
                return false;
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
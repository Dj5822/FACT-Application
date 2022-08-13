package com.example.factapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChoicepointActivity extends AppCompatActivity {

    private ViewHolder vh;
    private String position;

    private final String leftChoice = "Buy whiskey";
    private final String rightChoice = "Keep walking";
    private final String scenario = "You come across the liquor store";

    private class ViewHolder {
        ImageView backgroundImage;
        View choicePointView;
        TextView scenarioText, currentText, leftText, rightText;

        public ViewHolder() {
            backgroundImage = findViewById(R.id.choicePointBackground);
            choicePointView = findViewById(R.id.choicePointView);
            scenarioText = findViewById(R.id.choicePointScenarioText);
            currentText = findViewById(R.id.choicepointCurrentText);
            leftText = findViewById(R.id.choicepointLeftSideText);
            rightText = findViewById(R.id.choicepointRightSideText);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choicepoint);
        vh = new ViewHolder();

        initialize();

        vh.choicePointView.setOnTouchListener(new OnSwipeTouchListener(ChoicepointActivity.this) {
            public void onSwipeLeft() {
                if (position == "center") {
                    goToRightScreen();
                }
                else if (position == "left") {
                    goToCenterScreen();
                }

            }

            public void onSwipeRight(){
                if (position == "center") {
                    goToLeftScreen();
                }
                else if (position == "right") {
                    goToCenterScreen();
                }
            }
        });
    }

    private void initialize() {
        position = "center";
        vh.scenarioText.setText(scenario);
        vh.leftText.setText(leftChoice);
        vh.rightText.setText(rightChoice);
        vh.currentText.setVisibility(View.INVISIBLE);
        vh.leftText.setVisibility(View.VISIBLE);
        vh.rightText.setVisibility(View.VISIBLE);
    }

    private void goToRightScreen() {
        position = "right";
        vh.currentText.setText(rightChoice);
        vh.currentText.setVisibility(View.VISIBLE);
        vh.leftText.setVisibility(View.INVISIBLE);
        vh.rightText.setVisibility(View.INVISIBLE);
        vh.backgroundImage.setImageResource(R.drawable.choice_point_background_right);
    }

    private void goToLeftScreen() {
        position = "left";
        vh.currentText.setText(leftChoice);
        vh.currentText.setVisibility(View.VISIBLE);
        vh.leftText.setVisibility(View.INVISIBLE);
        vh.rightText.setVisibility(View.INVISIBLE);
        vh.backgroundImage.setImageResource(R.drawable.choice_point_background_left);
    }

    private void goToCenterScreen() {
        position = "center";
        vh.currentText.setVisibility(View.INVISIBLE);
        vh.leftText.setVisibility(View.VISIBLE);
        vh.rightText.setVisibility(View.VISIBLE);
        vh.backgroundImage.setImageResource(R.drawable.choice_point_background_center);
    }
}

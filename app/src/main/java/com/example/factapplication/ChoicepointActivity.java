package com.example.factapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ChoicepointActivity extends AppCompatActivity {

    private ViewHolder vh;
    private String position;

    private class ViewHolder {
        ImageView backgroundImage;
        View choicepointView;

        public ViewHolder() {
            backgroundImage = findViewById(R.id.choicePointBackground);
            choicepointView = findViewById(R.id.choicePointView);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choicepoint);
        this.position = "center";

        vh = new ViewHolder();

        vh.choicepointView.setOnTouchListener(new OnSwipeTouchListener(ChoicepointActivity.this) {
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

    private void goToRightScreen() {
        position = "right";
        vh.backgroundImage.setImageResource(R.drawable.choice_point_background_right);
    }

    private void goToLeftScreen() {
        position = "left";
        vh.backgroundImage.setImageResource(R.drawable.choice_point_background_left);
    }

    private void goToCenterScreen() {
        position = "center";
        vh.backgroundImage.setImageResource(R.drawable.choice_point_background_center);
    }
}

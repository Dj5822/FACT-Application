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
                    position = "right";
                    vh.backgroundImage.setImageResource(R.drawable.choice_point_background_right);
                }
                else if (position == "left") {
                    position = "center";
                    vh.backgroundImage.setImageResource(R.drawable.choice_point_background_center);
                }

            }

            public void onSwipeRight(){
                if (position == "center") {
                    position = "left";
                    vh.backgroundImage.setImageResource(R.drawable.choice_point_background_left);
                }
                else if (position == "right") {
                    position = "center";
                    vh.backgroundImage.setImageResource(R.drawable.choice_point_background_center);
                }
            }
        });
    }
}

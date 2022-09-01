package com.example.factapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class ChoicepointActivity extends AppCompatActivity {

    private ViewHolder vh;
    private String position;
    private boolean editing = true;

    private final String leftChoice = "Buy whiskey";
    private final String rightChoice = "Keep walking";
    private final String scenario = "You come across the liquor store";

    private class ViewHolder {
        ImageView backgroundImage;
        View choicePointView;
        TextView scenarioText, currentText, leftText, rightText,
        valueText1, valueText2;
        CardView exitConfirmPopup;

        CardView awayMoveEdit, towardsMoveEdit, scenarioEdit, currentTextEdit, valuesTextEdit;
        Button editButton;

        public ViewHolder() {
            backgroundImage = findViewById(R.id.choicePointBackground);
            choicePointView = findViewById(R.id.choicePointView);
            scenarioText = findViewById(R.id.choicePointScenarioText);
            currentText = findViewById(R.id.choicepointCurrentText);
            leftText = findViewById(R.id.choicepointLeftSideText);
            rightText = findViewById(R.id.choicepointRightSideText);
            valueText1 = findViewById(R.id.choicePointValueText);
            valueText2 = findViewById(R.id.choicePointValueText2);
            exitConfirmPopup = findViewById(R.id.exitConfirmPopup);
            awayMoveEdit = findViewById(R.id.awayMoveEdit);
            towardsMoveEdit = findViewById(R.id.towardsMoveEdit);
            scenarioEdit = findViewById(R.id.scenarioEdit);
            currentTextEdit = findViewById(R.id.choicepointCurrentTextEdit);
            valuesTextEdit = findViewById(R.id.choicepointValuesTextEdit);
            editButton = findViewById(R.id.editButton);
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
        vh.valueText1.setVisibility(View.INVISIBLE);
        vh.valueText2.setVisibility(View.INVISIBLE);
        vh.exitConfirmPopup.setVisibility(View.INVISIBLE);
        vh.currentTextEdit.setVisibility(View.INVISIBLE);
        vh.valuesTextEdit.setVisibility(View.INVISIBLE);
    }

    private void goToRightScreen() {
        position = "right";
        vh.currentText.setText(rightChoice);
        vh.currentText.setVisibility(View.VISIBLE);
        vh.leftText.setVisibility(View.INVISIBLE);
        vh.rightText.setVisibility(View.INVISIBLE);
        vh.backgroundImage.setImageResource(R.drawable.choice_point_background_right);
        vh.valueText1.setVisibility(View.VISIBLE);
        vh.valueText2.setVisibility(View.VISIBLE);
        vh.valueText1.setText("Health");
        vh.valueText2.setText("Family");
        vh.valueText1.setTextColor(Color.parseColor("#127a1e"));
        vh.valueText2.setTextColor(Color.parseColor("#127a1e"));
        if (editing) {
            editText();
        }
    }

    private void goToLeftScreen() {
        position = "left";
        vh.currentText.setText(leftChoice);
        vh.currentText.setVisibility(View.VISIBLE);
        vh.leftText.setVisibility(View.INVISIBLE);
        vh.rightText.setVisibility(View.INVISIBLE);
        vh.backgroundImage.setImageResource(R.drawable.choice_point_background_left);
        vh.valueText1.setVisibility(View.VISIBLE);
        vh.valueText2.setVisibility(View.VISIBLE);
        vh.valueText1.setText("I'm stressed so it's ok");
        vh.valueText2.setText("I'm weak");
        vh.valueText1.setTextColor(Color.RED);
        vh.valueText2.setTextColor(Color.RED);
        if (editing) {
            editText();
        }
    }

    private void goToCenterScreen() {
        position = "center";
        vh.currentText.setVisibility(View.INVISIBLE);
        vh.leftText.setVisibility(View.VISIBLE);
        vh.rightText.setVisibility(View.VISIBLE);
        vh.backgroundImage.setImageResource(R.drawable.choice_point_background_center);
        vh.valueText1.setVisibility(View.INVISIBLE);
        vh.valueText2.setVisibility(View.INVISIBLE);
        if (editing) {
            editText();
        }
    }

    public void goBack(View view) {
        finish();

    }

    public void hideConfirmationPopup(View view) {
        vh.exitConfirmPopup.setVisibility(View.INVISIBLE);
    }

    public void showConfirmationPopup(View view) {
        vh.exitConfirmPopup.setVisibility(View.VISIBLE);
    }

    public void editCenterScreen() {
        vh.scenarioText.setVisibility(View.INVISIBLE);
        vh.scenarioEdit.setVisibility(View.VISIBLE);

        vh.leftText.setVisibility(View.INVISIBLE);
        vh.awayMoveEdit.setVisibility(View.VISIBLE);

        vh.rightText.setVisibility(View.INVISIBLE);
        vh.towardsMoveEdit.setVisibility(View.VISIBLE);

        vh.currentTextEdit.setVisibility(View.INVISIBLE);
        vh.valuesTextEdit.setVisibility(View.INVISIBLE);
    }

    public void saveCenterScreen() {
        vh.scenarioText.setVisibility(View.VISIBLE);
        vh.scenarioEdit.setVisibility(View.INVISIBLE);

        vh.leftText.setVisibility(View.VISIBLE);
        vh.awayMoveEdit.setVisibility(View.INVISIBLE);

        vh.rightText.setVisibility(View.VISIBLE);
        vh.towardsMoveEdit.setVisibility(View.INVISIBLE);

        vh.currentTextEdit.setVisibility(View.INVISIBLE);
        vh.valuesTextEdit.setVisibility(View.INVISIBLE);
    }

    public void editLeftScreen() {
        vh.scenarioText.setVisibility(View.VISIBLE);
        vh.scenarioEdit.setVisibility(View.VISIBLE);

        vh.leftText.setVisibility(View.INVISIBLE);
        vh.awayMoveEdit.setVisibility(View.INVISIBLE);

        vh.rightText.setVisibility(View.INVISIBLE);
        vh.towardsMoveEdit.setVisibility(View.INVISIBLE);

        vh.currentTextEdit.setVisibility(View.VISIBLE);
        vh.valuesTextEdit.setVisibility(View.VISIBLE);
    }

    public void saveLeftScreen() {
        vh.scenarioText.setVisibility(View.INVISIBLE);
        vh.scenarioEdit.setVisibility(View.INVISIBLE);

        vh.leftText.setVisibility(View.INVISIBLE);
        vh.awayMoveEdit.setVisibility(View.INVISIBLE);

        vh.rightText.setVisibility(View.INVISIBLE);
        vh.towardsMoveEdit.setVisibility(View.INVISIBLE);

        vh.currentTextEdit.setVisibility(View.INVISIBLE);
        vh.valuesTextEdit.setVisibility(View.INVISIBLE);
    }

    public void editRightScreen() {
        vh.scenarioText.setVisibility(View.VISIBLE);
        vh.scenarioEdit.setVisibility(View.VISIBLE);

        vh.leftText.setVisibility(View.INVISIBLE);
        vh.awayMoveEdit.setVisibility(View.INVISIBLE);

        vh.rightText.setVisibility(View.INVISIBLE);
        vh.towardsMoveEdit.setVisibility(View.INVISIBLE);

        vh.currentTextEdit.setVisibility(View.VISIBLE);
        vh.valuesTextEdit.setVisibility(View.VISIBLE);
    }

    public void saveRightScreen() {
        vh.scenarioText.setVisibility(View.INVISIBLE);
        vh.scenarioEdit.setVisibility(View.INVISIBLE);

        vh.leftText.setVisibility(View.INVISIBLE);
        vh.awayMoveEdit.setVisibility(View.INVISIBLE);

        vh.rightText.setVisibility(View.INVISIBLE);
        vh.towardsMoveEdit.setVisibility(View.INVISIBLE);

        vh.currentTextEdit.setVisibility(View.INVISIBLE);
        vh.valuesTextEdit.setVisibility(View.INVISIBLE);
    }

    public void editText() {
        vh.editButton.setText("save");
        if (position == "center") {
            editCenterScreen();
        }
        else if (position == "left") {
            editLeftScreen();
        }
        else if (position == "right") {
            editRightScreen();
        }
    }

    public void saveText() {
        vh.editButton.setText("edit");
        if (position == "center") {
            saveCenterScreen();
        }
        else if (position == "left") {
            saveLeftScreen();
        }
        else if (position == "right") {
            saveRightScreen();
        }
    }

    public void toggleEditButton(View view) {
        if (editing) {
            saveText();
        }
        else {
            editText();
        }
        editing = !editing;
    }
}

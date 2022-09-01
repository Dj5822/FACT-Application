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

import com.google.android.material.textfield.TextInputEditText;

public class ChoicepointActivity extends AppCompatActivity {

    // The current state of the choice point activity.
    private String position;
    private boolean editing = true;

    // The text that appears on the screen.
    private String leftChoice = "";
    private String rightChoice = "";
    private String scenario = "";

    private ViewHolder vh;

    private class ViewHolder {
        ImageView backgroundImage;
        View choicePointView;
        Button editButton;

        // Popups
        CardView exitConfirmPopup;

        // Text views
        TextView scenarioText, currentText, leftText, rightText,
        valueText1, valueText2;

        // Cards for editing the text.
        CardView awayMoveEdit, towardsMoveEdit, scenarioEdit, currentTextEditCard, valuesTextEditCard;
        TextView currentTextEdit, valuesTextEdit;

        // Text Input fields.
        TextInputEditText scenarioTextField, awayTextField, towardsTextField, centerTextField;

        public ViewHolder() {
            backgroundImage = findViewById(R.id.choicePointBackground);
            choicePointView = findViewById(R.id.choicePointView);
            editButton = findViewById(R.id.editButton);

            // Popups
            exitConfirmPopup = findViewById(R.id.exitConfirmPopup);

            // Text views
            scenarioText = findViewById(R.id.choicePointScenarioText);
            currentText = findViewById(R.id.choicepointCurrentText);
            leftText = findViewById(R.id.choicepointLeftSideText);
            rightText = findViewById(R.id.choicepointRightSideText);
            valueText1 = findViewById(R.id.choicePointValueText);
            valueText2 = findViewById(R.id.choicePointValueText2);

            // Cards for editing the text.
            awayMoveEdit = findViewById(R.id.awayMoveEdit);
            towardsMoveEdit = findViewById(R.id.towardsMoveEdit);
            scenarioEdit = findViewById(R.id.scenarioEdit);
            currentTextEditCard = findViewById(R.id.choicepointCurrentTextEditCard);
            valuesTextEditCard = findViewById(R.id.choicepointValuesTextEditCard);
            currentTextEdit = findViewById(R.id.choicePointCurrentTextEdit);
            valuesTextEdit = findViewById(R.id.choicepointValuesTextEdit);

            // Text Input fields.
            scenarioTextField = findViewById(R.id.choicePointScenarioTextField);
            awayTextField = findViewById(R.id.choicePointAwayTextField);
            towardsTextField = findViewById(R.id.choicePointTowardsTextField);
            centerTextField = findViewById(R.id.choicePointCenterTextField);
        }
    }

    // Entry point
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_choicepoint);
        vh = new ViewHolder();

        initialize();
    }

    private void initialize() {
        setupSwipeListener();
        goToCenterScreen();
    }

    private void setupSwipeListener() {
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

    private void updateText() {
        scenario = vh.scenarioTextField.getText().toString();
        leftChoice = vh.awayTextField.getText().toString();
        rightChoice = vh.towardsTextField.getText().toString();
        vh.scenarioText.setText(scenario);
        vh.awayTextField.setText(leftChoice);
        vh.leftText.setText(leftChoice);
        vh.towardsTextField.setText(rightChoice);
        vh.rightText.setText(rightChoice);
        if (position == "left") {
            vh.centerTextField.setText(leftChoice);
        }
        else if (position == "right") {
            vh.centerTextField.setText(rightChoice);
        }
    }

    // RIGHT

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

    public void editRightScreen() {
        vh.scenarioText.setVisibility(View.VISIBLE);
        vh.scenarioEdit.setVisibility(View.VISIBLE);

        vh.leftText.setVisibility(View.INVISIBLE);
        vh.awayMoveEdit.setVisibility(View.INVISIBLE);

        vh.rightText.setVisibility(View.INVISIBLE);
        vh.towardsMoveEdit.setVisibility(View.INVISIBLE);

        vh.currentTextEditCard.setVisibility(View.VISIBLE);
        vh.valuesTextEditCard.setVisibility(View.VISIBLE);

        vh.currentTextEdit.setText("Towards move");
        vh.valuesTextEdit.setText("Values (Separate using commas)");


    }

    public void saveRightScreen() {
        vh.scenarioText.setVisibility(View.VISIBLE);
        vh.scenarioEdit.setVisibility(View.INVISIBLE);

        vh.leftText.setVisibility(View.INVISIBLE);
        vh.awayMoveEdit.setVisibility(View.INVISIBLE);

        vh.rightText.setVisibility(View.INVISIBLE);
        vh.towardsMoveEdit.setVisibility(View.INVISIBLE);

        vh.currentTextEditCard.setVisibility(View.INVISIBLE);
        vh.valuesTextEditCard.setVisibility(View.INVISIBLE);
    }

    // LEFT

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

    public void editLeftScreen() {
        vh.scenarioText.setVisibility(View.VISIBLE);
        vh.scenarioEdit.setVisibility(View.VISIBLE);

        vh.leftText.setVisibility(View.INVISIBLE);
        vh.awayMoveEdit.setVisibility(View.INVISIBLE);

        vh.rightText.setVisibility(View.INVISIBLE);
        vh.towardsMoveEdit.setVisibility(View.INVISIBLE);

        vh.currentTextEditCard.setVisibility(View.VISIBLE);
        vh.valuesTextEditCard.setVisibility(View.VISIBLE);

        vh.currentTextEdit.setText("Away move");
        vh.valuesTextEdit.setText("Thoughts and feelings (Separate using commas)");

    }

    public void saveLeftScreen() {
        vh.scenarioText.setVisibility(View.VISIBLE);
        vh.scenarioEdit.setVisibility(View.INVISIBLE);

        vh.leftText.setVisibility(View.INVISIBLE);
        vh.awayMoveEdit.setVisibility(View.INVISIBLE);

        vh.rightText.setVisibility(View.INVISIBLE);
        vh.towardsMoveEdit.setVisibility(View.INVISIBLE);

        vh.currentTextEditCard.setVisibility(View.INVISIBLE);
        vh.valuesTextEditCard.setVisibility(View.INVISIBLE);
    }

    // CENTER

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

    public void editCenterScreen() {
        vh.scenarioText.setVisibility(View.INVISIBLE);
        vh.scenarioEdit.setVisibility(View.VISIBLE);

        vh.leftText.setVisibility(View.INVISIBLE);
        vh.awayMoveEdit.setVisibility(View.VISIBLE);

        vh.rightText.setVisibility(View.INVISIBLE);
        vh.towardsMoveEdit.setVisibility(View.VISIBLE);

        vh.currentTextEditCard.setVisibility(View.INVISIBLE);
        vh.valuesTextEditCard.setVisibility(View.INVISIBLE);
    }

    public void saveCenterScreen() {
        vh.scenarioText.setVisibility(View.VISIBLE);
        vh.scenarioEdit.setVisibility(View.INVISIBLE);

        vh.leftText.setVisibility(View.VISIBLE);
        vh.awayMoveEdit.setVisibility(View.INVISIBLE);

        vh.rightText.setVisibility(View.VISIBLE);
        vh.towardsMoveEdit.setVisibility(View.INVISIBLE);

        vh.currentTextEditCard.setVisibility(View.INVISIBLE);
        vh.valuesTextEditCard.setVisibility(View.INVISIBLE);
    }

    // EDIT

    public void toggleEditButton(View view) {
        if (editing) {
            saveText();
        }
        else {
            editText();
        }
        editing = !editing;
    }

    public void editText() {
        updateText();
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
        updateText();
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

    // BACK

    public void goBack(View view) {
        finish();

    }

    public void hideConfirmationPopup(View view) {
        vh.exitConfirmPopup.setVisibility(View.INVISIBLE);
    }

    public void showConfirmationPopup(View view) {
        vh.exitConfirmPopup.setVisibility(View.VISIBLE);
    }
}

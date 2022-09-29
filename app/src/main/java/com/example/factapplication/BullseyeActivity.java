package com.example.factapplication;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class BullseyeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private ViewHolder vh;
    String currentValue = "Love";
    private int currentPressed;
    TextView textView;


    private class ViewHolder {
        FloatingActionButton backButton;

        public ViewHolder() {
            backButton = findViewById(R.id.bullseyeBackButton);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bullseye);
        vh = new ViewHolder();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Exit Bullseye");
        builder.setMessage("Are you sure you want to exit the activity?");
        builder.setPositiveButton("Confirm",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog backDialog = builder.create();

        vh.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backDialog.show();
            }
        });


        Button resetBullseye = findViewById(R.id.resetButton);
        resetBullseye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(getIntent());
            }
        });

        Button selectFirstValue = findViewById(R.id.firstValue);
        selectFirstValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentValue = "Love";
                currentPressed = 0;
            }
        });

        Button selectSecondValue = findViewById(R.id.secondValue);
        selectSecondValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentValue = "Adventurousness";
                currentPressed = 1;
            }
        });

        Button selectThirdValue = findViewById(R.id.thirdValue);
        selectThirdValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentValue = "fairness";
                currentPressed = 2;
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
                            androidx.constraintlayout.widget.R.drawable.btn_radio_off_mtrl));
                    ((ViewGroup) v).addView(iv);

                    // set text
                    TextView textView = new TextView(getApplicationContext());
                    textView.setText(currentValue.toString());
                    System.out.println(currentPressed);
                    if(currentPressed==0){
                        textView.setTextColor(Color.rgb(204,102,102));
                    }
                    else if (currentPressed==1){
                        textView.setTextColor(Color.rgb(122,179,252));
                    }
                    else {
                        textView.setTextColor(Color.rgb(55,148,57));
                    }
                    textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    RelativeLayout.LayoutParams tlp = new RelativeLayout.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
                    tlp.setMargins(x+40,y-45,0,0);
                    textView.setLayoutParams(tlp);


                    textView.setTypeface(null, Typeface.BOLD);
                    ((ViewGroup) v).addView(textView);

                    // go to next value
                }
                return false;
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
    }
}
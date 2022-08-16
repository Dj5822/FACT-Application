package com.example.factapplication;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.os.Bundle;
import android.text.Layout;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BullseyeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private String currentValue = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bullseye);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String[] items = new String[]{"value1", "value2", "value3"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

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
                    textView.setText(spinner.getSelectedItem().toString());
                    textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    RelativeLayout.LayoutParams tlp = new RelativeLayout.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
                    tlp.setMargins(x+40,y-45,0,0);
                    textView.setLayoutParams(tlp);
                    ((ViewGroup) v).addView(textView);
                }
                return false;
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        switch (position) {
            case 0:
                // Whatever you want to happen when the first item gets selected
                System.out.println("asdf");
                currentValue = v.toString();
                break;
            case 1:
                // Whatever you want to happen when the second item gets selected
                System.out.println("asdf2");
                break;
            case 2:
                // Whatever you want to happen when the thrid item gets selected
                System.out.println("asd3f");
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
    }
}
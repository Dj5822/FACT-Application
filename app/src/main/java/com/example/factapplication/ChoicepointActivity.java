package com.example.factapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.factapplication.ui.choicepoint.ChoicepointModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.example.factapplication.ui.choicepoint.SectionsPagerAdapter;
import com.example.factapplication.databinding.ActivityChoicepointMainBinding;

public class ChoicepointActivity extends AppCompatActivity {

    private ActivityChoicepointMainBinding binding;
    private ChoicepointModel choicepointModel;

    // Entry point
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityChoicepointMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        choicepointModel = new ViewModelProvider(this).get(ChoicepointModel.class);
        choicepointModel.initialize();

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        viewPager.setOffscreenPageLimit(2);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton editButton = binding.editButton;
        FloatingActionButton backButton = binding.backButton;

        viewPager.setCurrentItem(1);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Exit Choicepoint");
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

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choicepointModel.toggleEditing();
                choicepointModel.editModeEnabled().observe(ChoicepointActivity.this, editing -> {
                    if (editing) {
                        editButton.setImageResource(R.drawable.ic_baseline_edit_24);
                    }
                    else {
                        editButton.setImageResource(R.drawable.ic_baseline_done_24);
                    }
                });
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backDialog.show();
            }
        });
    }
}

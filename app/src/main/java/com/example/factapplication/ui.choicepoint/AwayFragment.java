package com.example.factapplication.ui.choicepoint;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.factapplication.databinding.ActivityChoicepointLeftBinding;

/**
 * A placeholder fragment containing a simple view.
 */
public class AwayFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private ChoicepointModel choicepointModel;
    private ActivityChoicepointLeftBinding binding;

    public static AwayFragment newInstance() {
        AwayFragment fragment = new AwayFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, 1);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        choicepointModel = new ViewModelProvider(requireActivity()).get(ChoicepointModel.class);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        binding = ActivityChoicepointLeftBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.choicePointValuesTextField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                choicepointModel.setThoughtsAndFeelings(binding.choicePointValuesTextField.getText().toString());
            }
        });

        binding.choicePointStrategiesTextField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                choicepointModel.setStrategies(binding.choicePointStrategiesTextField.getText().toString());
            }
        });

        binding.choicePointCenterTextField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                choicepointModel.setAwayMove(binding.choicePointCenterTextField.getText().toString());
            }
        });

        binding.choicePointScenarioTextField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                choicepointModel.setScenario(binding.choicePointScenarioTextField.getText().toString());
            }
        });

        choicepointModel.getThoughtsAndFeelings().observe(getViewLifecycleOwner(), new Observer<String>() {

            @Override
            public void onChanged(String s) {
                if (!binding.choicePointValuesTextField.getText().toString().equals(s))
                binding.choicePointValuesTextField.setText(s);
            }
        });

        choicepointModel.getStrategies().observe(getViewLifecycleOwner(), new Observer<String>() {

            @Override
            public void onChanged(String s) {
                if (!binding.choicePointStrategiesTextField.getText().toString().equals(s))
                binding.choicePointStrategiesTextField.setText(s);
            }
        });

        choicepointModel.getAwayMove().observe(getViewLifecycleOwner(), new Observer<String>() {

            @Override
            public void onChanged(String s) {
                if (!binding.choicePointCenterTextField.getText().toString().equals(s))
                binding.choicePointCenterTextField.setText(s);
            }
        });

        choicepointModel.getScenario().observe(getViewLifecycleOwner(), new Observer<String>() {

            @Override
            public void onChanged(String s) {
                if (!binding.choicePointScenarioTextField.getText().toString().equals(s))
                binding.choicePointScenarioTextField.setText(s);
            }
        });

        choicepointModel.editModeEnabled().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean enabled) {
                if (enabled) {
                    binding.choicepointValuesTextEditCard.setVisibility(View.INVISIBLE);
                    binding.choicepointCurrentTextEditCard.setVisibility(View.INVISIBLE);
                    binding.scenarioEdit.setVisibility(View.INVISIBLE);
                    binding.choicePointValueText.setVisibility(View.VISIBLE);
                    binding.choicePointValueText2.setVisibility(View.VISIBLE);
                    binding.choicepointCurrentText.setVisibility(View.VISIBLE);
                    binding.choicePointScenarioText.setVisibility(View.VISIBLE);

                }
                else {
                    binding.choicepointValuesTextEditCard.setVisibility(View.VISIBLE);
                    binding.choicepointCurrentTextEditCard.setVisibility(View.VISIBLE);
                    binding.scenarioEdit.setVisibility(View.VISIBLE);
                    binding.choicePointValueText.setVisibility(View.INVISIBLE);
                    binding.choicePointValueText2.setVisibility(View.INVISIBLE);
                    binding.choicepointCurrentText.setVisibility(View.INVISIBLE);
                    binding.choicePointScenarioText.setVisibility(View.INVISIBLE);
                }

            }
        });

        return root;
    }

    public void updateText() {
        choicepointModel.getThoughtsAndFeelings().observe(getViewLifecycleOwner(), new Observer<String>() {

            @Override
            public void onChanged(String s) {
                binding.choicePointValueText.setText(s);
            }
        });

        choicepointModel.getStrategies().observe(getViewLifecycleOwner(), new Observer<String>() {

            @Override
            public void onChanged(String s) {
                binding.choicePointValueText2.setText(s);
            }
        });

        choicepointModel.getAwayMove().observe(getViewLifecycleOwner(), new Observer<String>() {

            @Override
            public void onChanged(String s) {
                binding.choicepointCurrentText.setText(s);
            }
        });

        choicepointModel.getScenario().observe(getViewLifecycleOwner(), new Observer<String>() {

            @Override
            public void onChanged(String s) {
                binding.choicePointScenarioText.setText(s);
            }
        });

    }

    @Override
    public void onDestroyView() {
        choicepointModel.getThoughtsAndFeelings().removeObservers(getViewLifecycleOwner());

        choicepointModel.getStrategies().removeObservers(getViewLifecycleOwner());

        choicepointModel.getAwayMove().removeObservers(getViewLifecycleOwner());

        choicepointModel.getScenario().removeObservers(getViewLifecycleOwner());

        super.onDestroyView();
        binding = null;
    }
}
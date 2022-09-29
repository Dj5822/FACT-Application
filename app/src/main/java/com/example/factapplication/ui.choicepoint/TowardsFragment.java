package com.example.factapplication.ui.choicepoint;

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

import com.example.factapplication.databinding.ActivityChoicepointRightBinding;

/**
 * A placeholder fragment containing a simple view.
 */
public class TowardsFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private ChoicepointModel choicepointModel;
    private ActivityChoicepointRightBinding binding;

    public static TowardsFragment newInstance() {
        TowardsFragment fragment = new TowardsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, 3);
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

        binding = ActivityChoicepointRightBinding.inflate(inflater, container, false);
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
                choicepointModel.setValues(binding.choicePointValuesTextField.getText().toString());
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
                choicepointModel.setTowardsMove(binding.choicePointCenterTextField.getText().toString());
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
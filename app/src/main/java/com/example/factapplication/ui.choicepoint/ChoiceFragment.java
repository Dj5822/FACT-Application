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
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.factapplication.databinding.ActivityChoicepointCenterBinding;

/**
 * A placeholder fragment containing a simple view.
 */
public class ChoiceFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private ChoicepointModel choicepointModel;
    private ActivityChoicepointCenterBinding binding;

    public static ChoiceFragment newInstance() {
        ChoiceFragment fragment = new ChoiceFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, 2);
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

        binding = ActivityChoicepointCenterBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.choicePointAwayTextField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                choicepointModel.setAwayMove(binding.choicePointAwayTextField.getText().toString());
            }
        });

        binding.choicePointTowardsTextField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                choicepointModel.setTowardsMove(binding.choicePointTowardsTextField.getText().toString());
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

        choicepointModel.getAwayMove().observe(getViewLifecycleOwner(), new Observer<String>() {

            @Override
            public void onChanged(String s) {
                binding.choicepointLeftSideText.setText(s);
            }
        });

        choicepointModel.getTowardsMove().observe(getViewLifecycleOwner(), new Observer<String>() {

            @Override
            public void onChanged(String s) {
                binding.choicepointRightSideText.setText(s);
            }
        });

        choicepointModel.getScenario().observe(getViewLifecycleOwner(), new Observer<String>() {

            @Override
            public void onChanged(String s) {
                binding.choicePointScenarioText.setText(s);
            }
        });

        choicepointModel.editModeEnabled().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean enabled) {
                if (enabled) {
                    binding.awayMoveEdit.setVisibility(View.INVISIBLE);
                    binding.towardsMoveEdit.setVisibility(View.INVISIBLE);
                    binding.scenarioEdit.setVisibility(View.INVISIBLE);
                    binding.choicepointLeftSideText.setVisibility(View.VISIBLE);
                    binding.choicepointRightSideText.setVisibility(View.VISIBLE);
                    binding.choicePointScenarioText.setVisibility(View.VISIBLE);
                }
                else {
                    binding.awayMoveEdit.setVisibility(View.VISIBLE);
                    binding.towardsMoveEdit.setVisibility(View.VISIBLE);
                    binding.scenarioEdit.setVisibility(View.VISIBLE);
                    binding.choicepointLeftSideText.setVisibility(View.INVISIBLE);
                    binding.choicepointRightSideText.setVisibility(View.INVISIBLE);
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
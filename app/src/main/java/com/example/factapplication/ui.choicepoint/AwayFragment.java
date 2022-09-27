package com.example.factapplication.ui.choicepoint;

import android.content.Context;
import android.os.Bundle;
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

        choicepointModel.editModeEnabled().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean enabled) {
                if (enabled) {
                    binding.choicepointValuesTextEditCard.setVisibility(View.INVISIBLE);
                    binding.choicepointCurrentTextEditCard.setVisibility(View.INVISIBLE);
                    binding.scenarioEdit.setVisibility(View.INVISIBLE);
                }
                else {
                    binding.choicepointValuesTextEditCard.setVisibility(View.VISIBLE);
                    binding.choicepointCurrentTextEditCard.setVisibility(View.VISIBLE);
                    binding.scenarioEdit.setVisibility(View.VISIBLE);
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
package com.example.factapplication.ui.choicepoint;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class ChoicepointModel extends ViewModel {

    private MutableLiveData<Boolean> editing = new MutableLiveData<>();
    private MutableLiveData<String> scenario = new MutableLiveData<>();
    private MutableLiveData<String> awayMove = new MutableLiveData<>();
    private MutableLiveData<String> towardsMove = new MutableLiveData<>();

    public void initialize() {
        editing.setValue(true);
    }

    public void toggleEditing() {
        try {
            editing.setValue(!editing.getValue());
        }
        catch (Exception ex) {
            System.out.println("Need to initialize values.");
        }
    }

    public LiveData<Boolean> editModeEnabled() {
        return editing;
    }
}
package com.example.factapplication.ui.choicepoint;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class ChoicepointModel extends ViewModel {

    private MutableLiveData<Integer> mIndex = new MutableLiveData<>();
    private MutableLiveData<Boolean> editing = new MutableLiveData<>();
    private LiveData<String> mText = Transformations.map(mIndex, new Function<Integer, String>() {
        @Override
        public String apply(Integer input) {
            return "Hello world from section: " + input;
        }
    });

    public void initialize() {
        editing.setValue(true);
    }

    public void setIndex(int index) {
        mIndex.setValue(index);
    }

    public LiveData<String> getText() {
        return mText;
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
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
    private MutableLiveData<String> thoughtsAndFeelings = new MutableLiveData<>();
    private MutableLiveData<String> values = new MutableLiveData<>();
    private MutableLiveData<String> strategies = new MutableLiveData<>();

    public void initialize() {
        editing.setValue(true);
        scenario.setValue("");
        awayMove.setValue("");
        towardsMove.setValue("");
        thoughtsAndFeelings.setValue("");
        values.setValue("");
        strategies.setValue("");
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

    public void setAwayMove(MutableLiveData<String> awayMove) {
        this.awayMove = awayMove;
    }

    public MutableLiveData<String> getAwayMove() {
        return awayMove;
    }

    public void setScenario(MutableLiveData<String> scenario) {
        this.scenario = scenario;
    }

    public MutableLiveData<String> getScenario() {
        return scenario;
    }

    public void setStrategies(MutableLiveData<String> strategies) {
        this.strategies = strategies;
    }

    public MutableLiveData<String> getStrategies() {
        return strategies;
    }

    public void setThoughtsAndFeelings(MutableLiveData<String> thoughtsAndFeelings) {
        this.thoughtsAndFeelings = thoughtsAndFeelings;
    }

    public MutableLiveData<String> getThoughtsAndFeelings() {
        return thoughtsAndFeelings;
    }

    public void setTowardsMove(MutableLiveData<String> towardsMove) {
        this.towardsMove = towardsMove;
    }

    public MutableLiveData<String> getTowardsMove() {
        return towardsMove;
    }

    public void setValues(MutableLiveData<String> values) {
        this.values = values;
    }

    public MutableLiveData<String> getValues() {
        return values;
    }
}
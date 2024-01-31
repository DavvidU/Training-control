package com.example.treningcontrol.ui.pogoda;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PogodaViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public PogodaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Super pogoda dzisiaj tak o");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
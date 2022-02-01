package com.example.okcredit.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.okcredit.repository.repository;
import com.example.okcredit.response.response;

public class MainViewModel extends AndroidViewModel {

    private repository repository;
    private LiveData<response> responseLiveData;

    public MainViewModel(@NonNull Application application) {
        super(application);

        repository = new repository();
        this.responseLiveData = repository.getMeals();

    }

    public LiveData<response> getResponseLiveData()
    {
        return responseLiveData;
    }
}


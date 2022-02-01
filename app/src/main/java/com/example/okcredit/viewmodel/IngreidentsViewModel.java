package com.example.okcredit.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.okcredit.repository.repository;
import com.example.okcredit.response.response;
import com.example.okcredit.response.response1;

public class IngreidentsViewModel extends AndroidViewModel {

    private com.example.okcredit.repository.repository repository;
    private LiveData<response1> responseLiveData;


    public IngreidentsViewModel(@NonNull Application application) {
        super(application);
        repository = new repository();
        //this.responseLiveData = repository.getIngredients(id);
    }

    public LiveData<response1> getResponseLiveData(String id)
    {
        this.responseLiveData = repository.getIngredients(id);
        return responseLiveData;
    }
}

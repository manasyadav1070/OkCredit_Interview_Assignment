package com.example.okcredit.response;

import com.example.okcredit.model.Meal;
import com.example.okcredit.model.ingridients;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class response1 {
    @SerializedName("meals")
    @Expose
    private List<ingridients> ingridients = null;

    public List<ingridients> getIngridients() {
        return ingridients;
    }

    public void setMeals(List<ingridients> ingridients) {
        this.ingridients = ingridients;
    }
}

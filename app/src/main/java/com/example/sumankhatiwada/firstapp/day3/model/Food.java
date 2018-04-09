package com.example.sumankhatiwada.firstapp.day3.model;

import com.example.sumankhatiwada.firstapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sumankhatiwada on 4/6/18.
 */

public class Food {

    private String foodName;
   private String foodDescription;
   private int foodPhoto;

    public Food(String foodName, String foodDescription, int foodPhoto) {
        this.foodName = foodName;
        this.foodDescription = foodDescription;
        this.foodPhoto = foodPhoto;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodDescription() {
        return foodDescription;
    }

    public void setFoodDescription(String foodDescription) {
        this.foodDescription = foodDescription;
    }

    public int getFoodPhoto() {
        return foodPhoto;
    }

    public void setFoodPhoto(int foodPhoto) {
        this.foodPhoto = foodPhoto;
    }


}

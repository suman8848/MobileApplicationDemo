package com.example.sumankhatiwada.firstapp.day2;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by sumankhatiwada on 4/3/18.
 */

public class DinnerDeciderPresenter {

    DinnerDomain dinnerDomain = new DinnerDomain();

    public void addFoodToList(String dinnerName) {
        DinnerDomain dinnerDomainTest = new DinnerDomain();
        dinnerDomainTest.setDinnerName(dinnerName);
        dinnerDomain.addFood(dinnerDomainTest);
    }

    public void setDefaultValueToList(){
        dinnerDomain.setDefaultDinnerValue();
    }

    public ArrayList<DinnerDomain> getDinnerList(){

        return  dinnerDomain.getArrayList();
    }

}

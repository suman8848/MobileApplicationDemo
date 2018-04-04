package com.example.sumankhatiwada.firstapp.day2;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by sumankhatiwada on 4/3/18.
 */

public class DinnerDomain {
    public String dinnerName;
    ArrayList<DinnerDomain> arrayList= new ArrayList<>();

    public DinnerDomain() {
    }

    public String getDinnerName() {
        return dinnerName;
    }

    public void setDinnerName(String dinnerName) {
        this.dinnerName = dinnerName;
    }

    public ArrayList<DinnerDomain> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<DinnerDomain> arrayList) {
        this.arrayList = arrayList;
    }

    public void setDefaultDinnerValue(){
        DinnerDomain dinnerDomain = new DinnerDomain();
        dinnerDomain.setDinnerName("Hamburger");
        addFood(dinnerDomain);

        DinnerDomain dinnerDomain1 = new DinnerDomain();
        dinnerDomain1.setDinnerName("Pizza");
        addFood(dinnerDomain1);

        DinnerDomain dinnerDomain2 = new DinnerDomain();
        dinnerDomain2.setDinnerName("Maxican");
        addFood(dinnerDomain2);

        DinnerDomain dinnerDomain3 = new DinnerDomain();
        dinnerDomain3.setDinnerName("American");
        addFood(dinnerDomain3);

        DinnerDomain dinnerDomain4 = new DinnerDomain();
        dinnerDomain4.setDinnerName("Chinese");
        addFood(dinnerDomain4);

    }
    public void addFood(DinnerDomain dinnerDomain){

        arrayList.add(dinnerDomain);

    }



    @Override
    public String toString() {
        return "DinnerDomain{" +
                "dinnerName='" + dinnerName + '\'' +
                ", arrayList=" + arrayList +
                '}';
    }
}

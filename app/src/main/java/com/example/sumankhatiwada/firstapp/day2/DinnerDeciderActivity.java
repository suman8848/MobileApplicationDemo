package com.example.sumankhatiwada.firstapp.day2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sumankhatiwada.firstapp.R;
import com.example.sumankhatiwada.firstapp.base.BaseActivity;

import java.util.ArrayList;
import java.util.Random;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by sumankhatiwada on 4/3/18.
 */

public class DinnerDeciderActivity extends BaseActivity implements DinnerDeciderView {
    @BindView(R.id.btn_addFood)
    Button btnAddFood;
    @BindView(R.id.btn_decide)
    Button btnDecideFood;
    @BindView(R.id.txt_dinner_name)
    TextView textViewDinnerName;
    @BindView(R.id.et_addFood)
    EditText etAddFood;


    DinnerDeciderPresenter dinnerDeciderPresenter = new DinnerDeciderPresenter();

    @Override
    protected int getContentView() {
        return R.layout.activity_second_day2;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);

        dinnerDeciderPresenter.setDefaultValueToList();
        onShowDinnerItem();

    }

    @OnClick(R.id.btn_addFood)
    public void addFood(){
        hideSoftKeyboard();
        String getFood =etAddFood.getText().toString();
        if(!getFood.isEmpty()) {
            dinnerDeciderPresenter.addFoodToList(getFood);
            showToast(DinnerDeciderActivity.this, "Food Added Successfully");
            etAddFood.setText("");
        }else{
            showToast(DinnerDeciderActivity.this,"Food Cannot be empty");
        }


    }

    @OnClick(R.id.btn_decide)
    public void randomDecideValue(){
        onShowDinnerItem();
    }

    @Override
    public void onShowDinnerItem() {
        ArrayList<DinnerDomain> dinnerDomains=dinnerDeciderPresenter.getDinnerList();
        Random rand = new Random();
        int random = rand.nextInt(dinnerDomains.size());
        for (int i = 0; i<dinnerDomains.size();i++){
            Log.e("testter",dinnerDomains.get(i).getDinnerName());

        }
        textViewDinnerName.setText(dinnerDomains.get(random).getDinnerName());

    }
}

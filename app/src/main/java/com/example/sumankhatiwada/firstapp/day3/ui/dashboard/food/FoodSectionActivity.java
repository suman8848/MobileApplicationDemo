package com.example.sumankhatiwada.firstapp.day3.ui.dashboard.food;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;

import com.example.sumankhatiwada.firstapp.R;
import com.example.sumankhatiwada.firstapp.base.BaseActivity;
import com.example.sumankhatiwada.firstapp.day3.model.Food;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class FoodSectionActivity extends BaseActivity {
    @BindView(R.id.toolbarLayout)
    CollapsingToolbarLayout collapsingToolbarLayout;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.foodImageView)
    ImageView imageView;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    List<Food> foodList;

    @Override
    protected int getContentView() {
        return R.layout.activity_food_section;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
//        setToolbar("Foods");
        setDefaultFoodData();
        initializeAdapter();
        collapsingToolbarLayout.setTitle("Foods");
//        collapsingToolbarLayout.setBackgroundColor(Color.BLACK);
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
        imageView.setImageResource(R.drawable.food
        );

        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(true);



    }

    private void setDefaultFoodData(){
        foodList = new ArrayList<>();
        foodList.add(new Food("Burger","Burger Description", R.mipmap.ic_launcher_burger));
        foodList.add(new Food("Pizza","Pizza Description", R.mipmap.ic_launcher_pizza));
        foodList.add(new Food("Nuggets","Nuggets Description", R.mipmap.ic_launcher_nuggets));
    }
    private void initializeAdapter(){

        FoodListAdapter adapter = new FoodListAdapter(foodList, FoodSectionActivity.this, new FoodListAdapter.OnItemClickListener() {
            @Override
            public void onClick(Food foodItem) {
                showToast(FoodSectionActivity.this,foodItem.getFoodName());
            }
        });
        recyclerView.setAdapter(adapter);
    }
}

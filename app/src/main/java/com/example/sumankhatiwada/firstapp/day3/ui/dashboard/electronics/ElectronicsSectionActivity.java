package com.example.sumankhatiwada.firstapp.day3.ui.dashboard.electronics;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.sumankhatiwada.firstapp.R;
import com.example.sumankhatiwada.firstapp.base.BaseActivity;
import com.example.sumankhatiwada.firstapp.day3.model.ElectronicItem;
import com.example.sumankhatiwada.firstapp.day3.model.Food;
import com.example.sumankhatiwada.firstapp.day3.ui.dashboard.food.FoodListAdapter;
import com.example.sumankhatiwada.firstapp.day3.ui.dashboard.food.FoodSectionActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ElectronicsSectionActivity extends BaseActivity {


    @BindView(R.id.toolbarLayout)
    CollapsingToolbarLayout collapsingToolbarLayout;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.electronicsImageView)
    ImageView imageView;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    List<ElectronicItem> electronicItemList;
    @Override
    protected int getContentView() {
        return R.layout.activity_electronics_section;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);

        setDefaultElectronicData();
        initializeAdapter();

//        setToolbar("Electronics");
//        getSupportActionBar().setTitle("");
        collapsingToolbarLayout.setTitle("Electronics");
//        collapsingToolbarLayout.setBackgroundColor(Color.BLACK);
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
        imageView.setImageResource(R.drawable.electronics
        );
//        un.setColorFilter(Color.WHITE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }

        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(true);
    }

    private void setDefaultElectronicData() {
        electronicItemList = new ArrayList<>();
        electronicItemList.add(new ElectronicItem("Head Phone","Head Phone Description: "+getResources().getString(R.string.loream), R.drawable.headphone));
        electronicItemList.add(new ElectronicItem("Mac 2015","Mac Description: "+ getResources().getString(R.string.loream), R.drawable.mac));
        electronicItemList.add(new ElectronicItem("Smart Phone","Phone Description: "+ getResources().getString(R.string.loream), R.drawable.phone));

    }

    private void initializeAdapter () {


        ElectronicsListAdapter adapter = new ElectronicsListAdapter(electronicItemList, ElectronicsSectionActivity.this, new ElectronicsListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ElectronicItem item) {
                startActivity(new Intent(ElectronicsSectionActivity.this,ElectronicItemDisplayActivity.class).putExtra("electronicItem",item));
                showToast(ElectronicsSectionActivity.this,""+item.getElectronicItemName());
            }
        });
        recyclerView.setAdapter(adapter);



    }
}

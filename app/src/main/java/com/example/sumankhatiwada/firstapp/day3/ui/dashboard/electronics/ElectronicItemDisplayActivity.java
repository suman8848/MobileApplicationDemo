package com.example.sumankhatiwada.firstapp.day3.ui.dashboard.electronics;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sumankhatiwada.firstapp.R;
import com.example.sumankhatiwada.firstapp.base.BaseActivity;
import com.example.sumankhatiwada.firstapp.day3.model.ElectronicItem;

import butterknife.BindView;

public class ElectronicItemDisplayActivity extends BaseActivity {


    @BindView(R.id.electronicsImageView)
    ImageView imageView;

    @BindView(R.id.txtview_electronics_item_desc)
    TextView textView;

    @BindView(R.id.toolbarLayout)
    CollapsingToolbarLayout collapsingToolbarLayout;

    @BindView(R.id.appBar)
    AppBarLayout appBarLayout;

    @Override
    protected int getContentView() {
        return R.layout.activity_electronic_item_display;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
          ElectronicItem item = intent.getParcelableExtra("electronicItem");
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = true;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbarLayout.setTitle(item.getElectronicItemName());
                    isShow = true;
                } else if(isShow) {
                    collapsingToolbarLayout.setTitle(" ");//carefull there should a space between double quote otherwise it wont work
                    isShow = false;
                }
            }
        });
//        collapsingToolbarLayout.setBackgroundColor(Color.BLACK);
//        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);

        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);

        imageView.setImageResource(item.getElectronicItemPhoto());
        imageView.setBackgroundColor(Color.WHITE);

        textView.setText(item.getElectronicItemDetails());

    }
}

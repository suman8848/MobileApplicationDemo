package com.example.sumankhatiwada.firstapp.day3.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sumankhatiwada.firstapp.R;
import com.example.sumankhatiwada.firstapp.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by sumankhatiwada on 4/4/18.
 */

public class DashBoardActivity extends BaseActivity  {

    @BindView(R.id.txt_dashboard_username)
    TextView txtDashboardUsername;

    @BindView(R.id.gridview)
    GridView gridView;

    int products[] = {R.mipmap.ic_electronics,R.mipmap.ic_food, R.mipmap.ic_clothing,R.mipmap.ic_beauty};
    String productName[] = {"Electronics","Food","Clothing","Beauty"};



    @Override
    protected int getContentView() {
        return R.layout.dashboard_activity;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
        String username =intent.getStringExtra("username").toString();
        txtDashboardUsername.setText(username);
        DashBoardItemAdapter customAdapter = new DashBoardItemAdapter(getApplicationContext(), products,productName);
        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String product = productName[i];
                showToast(DashBoardActivity.this,product);
            }
        });


    }



}

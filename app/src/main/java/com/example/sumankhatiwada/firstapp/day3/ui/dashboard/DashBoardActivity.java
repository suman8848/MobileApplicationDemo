package com.example.sumankhatiwada.firstapp.day3.ui.dashboard;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sumankhatiwada.firstapp.R;
import com.example.sumankhatiwada.firstapp.base.BaseActivity;
import com.example.sumankhatiwada.firstapp.day3.ui.dashboard.beauty.BeautySectionActivity;
import com.example.sumankhatiwada.firstapp.day3.ui.dashboard.clothing.ClothingSectionActivity;
import com.example.sumankhatiwada.firstapp.day3.ui.dashboard.electronics.ElectronicsSectionActivity;
import com.example.sumankhatiwada.firstapp.day3.ui.dashboard.food.FoodSectionActivity;
import com.example.sumankhatiwada.firstapp.day3.ui.login.WalmartLoginActivity;
import com.example.sumankhatiwada.firstapp.day3.ui.login.WalmartLoginRegisterPresenter;
import com.example.sumankhatiwada.firstapp.day4.problem1.AutoCompleteTxtView;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnItemSelected;

/**
 * Created by sumankhatiwada on 4/4/18.
 */

public class DashBoardActivity extends BaseActivity  {

    @BindView(R.id.txt_dashboard_username)
    TextView txtDashboardUsername;

    @BindView(R.id.gridview)
    GridView gridView;

    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigationView;

    WalmartLoginRegisterPresenter walmartLoginRegisterPresenter= WalmartLoginRegisterPresenter.getInstance();

    int products[] = {R.mipmap.ic_electronics,R.mipmap.ic_launcher_burger, R.mipmap.ic_clothing,R.mipmap.ic_beauty};
    String productName[] = {"Electronics","Food","Clothing","Beauty"};



    @Override
    protected int getContentView() {
        return R.layout.dashboard_activity;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
        setToolbar("Welcome");
        String username =intent.getStringExtra("username").toString();
        txtDashboardUsername.setText(username);
        DashBoardItemAdapter customAdapter = new DashBoardItemAdapter(getApplicationContext(), products,productName);
        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String product = productName[i];
                showToast(DashBoardActivity.this,product);
                switch (product){
                    case "Electronics" : startActivity(new Intent(DashBoardActivity.this, ElectronicsSectionActivity.class)); break;
                    case "Food" : startActivity(new Intent(DashBoardActivity.this, FoodSectionActivity.class));break;
                    case "Clothing" : startActivity(new Intent(DashBoardActivity.this, ClothingSectionActivity.class));break;
                    case "Beauty" : startActivity(new Intent(DashBoardActivity.this, BeautySectionActivity.class));break;
                }
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.action_electronics:
                        showToast(DashBoardActivity.this,"Electronics");
                        break;

                    case R.id.action_food:
                        showToast(DashBoardActivity.this,"Food");
                        break;

                    case R.id.action_clothing:
                        showToast(DashBoardActivity.this,"Clothing");
                        break;

                    case R.id.action_beauty:
                        showToast(DashBoardActivity.this,"Beauty");
                        break;

                }
                return true;
            }
        });
    }



    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);

        menu.findItem(R.id.logout).setVisible(true);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.logout: alertDialog();break;
        }
        return super.onOptionsItemSelected(item);

    }

    public void alertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to logout?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        logout();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void logout() {
        walmartLoginRegisterPresenter.clearSession();
        startActivity(new Intent(DashBoardActivity.this, WalmartLoginActivity.class));
        finish();

    }

}

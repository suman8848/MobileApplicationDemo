package com.example.sumankhatiwada.firstapp.day3.ui.dashboard.clothing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.sumankhatiwada.firstapp.R;
import com.example.sumankhatiwada.firstapp.base.BaseActivity;

import butterknife.BindView;

public class ClothingSectionActivity extends BaseActivity {


    @BindView(R.id.listview_clothes)
    ListView listView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    public String clothes[] = {"Shirt", "T-Shirt", "Hoodie", "Gloves", "Sweater", "Jackets"};

    @Override
    protected int getContentView() {
        return R.layout.activity_clothing_section;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
        setToolbar("Clothes");

        ArrayAdapter<String> clothingStringArrayAdapter = new ArrayAdapter<String>(ClothingSectionActivity.this, android.R.layout.simple_list_item_1, clothes);
        listView.setAdapter(clothingStringArrayAdapter);

        listView.setOnItemClickListener((AdapterView<?> adapterView, View view, int i, long l)
                -> {
            String s = adapterView.getItemAtPosition(i).toString();
            showToast(ClothingSectionActivity.this,s);
        });

    }



}

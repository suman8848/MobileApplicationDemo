package com.example.sumankhatiwada.firstapp.day3.ui.dashboard.beauty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import com.example.sumankhatiwada.firstapp.R;
import com.example.sumankhatiwada.firstapp.base.BaseActivity;
import com.example.sumankhatiwada.firstapp.day3.ui.dashboard.clothing.ClothingSectionActivity;
import com.example.sumankhatiwada.firstapp.day3.ui.dashboard.electronics.ElectronicsSectionActivity;
import com.example.sumankhatiwada.firstapp.day3.ui.dashboard.food.FoodSectionActivity;
import com.example.sumankhatiwada.firstapp.day4.problem1.AutoCompleteTxtView;

import butterknife.BindView;

public class BeautySectionActivity extends BaseActivity {


    @BindView(R.id.txtView_actv)
    AutoCompleteTextView textViewActv;
    @Override
    protected int getContentView() {
        return R.layout.activity_beauty_section;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
        hideSoftKeyboard();
        setToolbar("Search Beauty Products");
        String []beautyproducts = getResources().getStringArray(R.array.beautyproducts);
        ArrayAdapter arrayAdapter = new ArrayAdapter(BeautySectionActivity.this,android.R.layout.simple_spinner_item,beautyproducts);
        textViewActv.setAdapter(arrayAdapter);
        textViewActv.setThreshold(2);
        textViewActv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                showToast(BeautySectionActivity.this,""+adapterView.getItemAtPosition(i));
                String checkClass = adapterView.getItemAtPosition(i).toString();

            }
        });


    }
}

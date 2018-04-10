package com.example.sumankhatiwada.firstapp.day1;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.sumankhatiwada.firstapp.day2.ConverterActivity;
import com.example.sumankhatiwada.firstapp.day2.DinnerDeciderActivity;
import com.example.sumankhatiwada.firstapp.day3.ui.implicitintent.ImplicitIntentActivity;
import com.example.sumankhatiwada.firstapp.day3.ui.login.WalmartLoginActivity;
import com.example.sumankhatiwada.firstapp.day4.problem1.AutoCompleteTxtView;
import com.example.sumankhatiwada.firstapp.day5.CurriculumVitaeApp;

/**
 * Created by sumankhatiwada on 4/3/18.
 */

public class MenuActivity extends ListActivity{

    String [] menu = {"MainActivity","ConverterActivity","DinnerDeciderActivity","WalmartLoginActivity","ImplicitIntent","AutoCompleteTxtView", "CurriculumVitaeApp"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String>menuAdapter=new ArrayAdapter<String>(MenuActivity.this,android.R.layout.simple_list_item_1,menu);
        setListAdapter(menuAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
            if(position==0){
                startActivity(new Intent(MenuActivity.this, MainActivity.class));
            }else if(position==1){
                startActivity(new Intent(MenuActivity.this,ConverterActivity.class));
            }else if(position==2){
                startActivity(new Intent(MenuActivity.this, DinnerDeciderActivity.class));
            }else if(position==3){
                startActivity(new Intent(MenuActivity.this, WalmartLoginActivity.class));
            }else if(position==4){
                startActivity(new Intent(MenuActivity.this, ImplicitIntentActivity.class));
            }else if(position==5){
                startActivity(new Intent(MenuActivity.this, AutoCompleteTxtView.class));
            }else if(position==6){
            startActivity(new Intent(MenuActivity.this, CurriculumVitaeApp.class));
        }
    }
}

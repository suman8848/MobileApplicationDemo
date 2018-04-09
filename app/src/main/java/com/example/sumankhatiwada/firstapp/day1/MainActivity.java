package com.example.sumankhatiwada.firstapp.day1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.sumankhatiwada.firstapp.R;
import com.example.sumankhatiwada.firstapp.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
        setToolbar("MainActivity");
        findViewById(R.id.btn_submit).setOnClickListener((View v) -> startActivity(new Intent(MainActivity.this,SecondActivity.class)));
    }
}

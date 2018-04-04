package com.example.sumankhatiwada.firstapp.day1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.sumankhatiwada.firstapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_submit).setOnClickListener((View v) -> startActivity(new Intent(MainActivity.this,SecondActivity.class)));
    }
}

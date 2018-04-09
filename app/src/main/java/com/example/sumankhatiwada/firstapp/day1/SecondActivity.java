package com.example.sumankhatiwada.firstapp.day1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.sumankhatiwada.firstapp.R;
import com.example.sumankhatiwada.firstapp.base.BaseActivity;

/**
 * Created by sumankhatiwada on 4/3/18.
 */

public class SecondActivity extends BaseActivity {

    @Override
    protected int getContentView() {
        return R.layout.activity_second;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
        setToolbar("Second");
    }
}

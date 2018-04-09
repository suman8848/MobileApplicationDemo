package com.example.sumankhatiwada.firstapp.day2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.sumankhatiwada.firstapp.R;
import com.example.sumankhatiwada.firstapp.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by sumankhatiwada on 4/3/18.
 */

public class ConverterActivity extends BaseActivity {

    @BindView(R.id.btn_convert_submit)
    Button btnSubmit;
    @BindView(R.id.et_lbValue)
    EditText et_lbValue;
    @BindView(R.id.et_kgValue)
    EditText et_kgValue;


    @Override
    protected int getContentView() {
        return R.layout.activity_converter_day2;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
        setToolbar("Convert");
    }

    @OnClick(R.id.btn_convert_submit)
    public void onClick(){
        hideSoftKeyboard();
        Double lbValue = Double.parseDouble(et_lbValue.getText().toString());
        //lb*0.456
        Double result = lbValue * 0.456;
        et_kgValue.setText(""+result);

    }
}

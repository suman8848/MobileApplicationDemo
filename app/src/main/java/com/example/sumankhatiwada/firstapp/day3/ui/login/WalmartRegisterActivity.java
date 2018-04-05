package com.example.sumankhatiwada.firstapp.day3.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.sumankhatiwada.firstapp.R;
import com.example.sumankhatiwada.firstapp.base.BaseActivity;
import com.example.sumankhatiwada.firstapp.day3.model.Users;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by sumankhatiwada on 4/4/18.
 */

public class WalmartRegisterActivity extends BaseActivity implements WalmartRegisterView {

    @BindView(R.id.editText_UserName)
    EditText etRegisterUsername;

    @BindView(R.id.editText_UserPassword)
    EditText etRegisterUserPassword;

    @BindView(R.id.edittext_firstName)
    EditText etFirstName;

    @BindView(R.id.edittext_lastName)
    EditText etLastName;

    @BindView(R.id.btn_create_account)
    Button createAccount;

    WalmartLoginRegisterPresenter walmartRegisterPresenter = WalmartLoginRegisterPresenter.getInstance();

    @Override
    protected int getContentView() {
        return R.layout.activity_walmart_register;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
        hideSoftKeyboard();
    }

    @OnClick(R.id.btn_create_account)
    public void registerUser() {
        String firstName = etFirstName.getText().toString();
        String lastName = etLastName.getText().toString();
        String userName = etRegisterUsername.getText().toString();
        String password = etRegisterUserPassword.getText().toString();

        if (!firstName.isEmpty() && !lastName.isEmpty() && !userName.isEmpty() && !password.isEmpty()) {
            doRegistration(firstName, lastName, userName, password);
        } else {
            showToast(WalmartRegisterActivity.this, "All fields are mandatory");
        }

    }


    @Override
    public void doRegistration(String firstName, String lastName, String email, String password) {
        walmartRegisterPresenter.doRegistration(firstName, lastName, email, password);
        showToast(WalmartRegisterActivity.this, "User Registered Successfully");
        finish();

    }
}

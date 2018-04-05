package com.example.sumankhatiwada.firstapp.day3.ui.login;

import android.content.Intent;
import android.graphics.Rect;
import android.support.design.widget.CoordinatorLayout;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.sumankhatiwada.firstapp.R;
import com.example.sumankhatiwada.firstapp.base.BaseActivity;
import com.example.sumankhatiwada.firstapp.day3.ui.dashboard.DashBoardActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class WalmartLoginActivity extends BaseActivity implements WalmartLoginView {

    @BindView(R.id.registerTxtview)
    TextView textViewGoToRegister;
    @BindView(R.id.loginButton)
    Button btnLogin;
    @BindView(R.id.login_coordinator)
    CoordinatorLayout loginCoordinator;
    @BindView(R.id.bottomLayout)
    FrameLayout frameLayout;
    @BindView(R.id.editText_UserName)
    EditText editTextUserName;
    @BindView(R.id.editText_UserPassword)
    EditText editTextUserPassword;


    WalmartLoginRegisterPresenter walmartLoginPresenter = WalmartLoginRegisterPresenter.getInstance();


    @Override
    protected int getContentView() {
        return R.layout.activity_walmart_login;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
        hideSoftKeyboard();
        walmartLoginPresenter.setDefaultUsers();
        loginCoordinator.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @Override
            public void onGlobalLayout() {

                Rect r = new Rect();
                loginCoordinator.getWindowVisibleDisplayFrame(r);
                int screenHeight = loginCoordinator.getRootView().getHeight();

                // r.bottom is the position above soft keypad or device button.
                // if keypad is shown, the r.bottom is smaller than that before.
                int keypadHeight = screenHeight - r.bottom;


                if (keypadHeight > screenHeight * 0.15) { // 0.15 ratio is perhaps enough to determine keypad height.
                    frameLayout.setVisibility(View.GONE);
                } else {
                    frameLayout.setVisibility(View.VISIBLE);

                }
            }
        });

    }

    @OnClick(R.id.registerTxtview)
    public void goToRegister() {
        startActivity(new Intent(WalmartLoginActivity.this, WalmartRegisterActivity.class));
    }

    @OnClick(R.id.loginButton)
    public void doLogin() {

        String userName = editTextUserName.getText().toString();
        String password = editTextUserPassword.getText().toString();

        if (!userName.isEmpty() || !password.isEmpty()) {

            doLoginCheck(userName, password);

        } else {
            showToast(this, "All field are mandatory");
        }


    }

    @Override
    public void doLoginCheck(String username, String password) {
        Boolean isLoginSuccess = walmartLoginPresenter.doLoginCheck(username, password);
        if (isLoginSuccess) {
            startActivity(new Intent(WalmartLoginActivity.this, DashBoardActivity.class).putExtra("username", username));
            finish();
        } else {
            showToast(WalmartLoginActivity.this, "Login Invalid");
        }
    }

}



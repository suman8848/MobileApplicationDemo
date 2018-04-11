package com.example.sumankhatiwada.firstapp.day6.problem1;

import android.content.Intent;
import android.graphics.Rect;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.sumankhatiwada.firstapp.R;
import com.example.sumankhatiwada.firstapp.base.BaseActivity;
import com.example.sumankhatiwada.firstapp.day3.ui.dashboard.DashBoardActivity;
import com.example.sumankhatiwada.firstapp.day3.ui.login.WalmartLoginActivity;
import com.example.sumankhatiwada.firstapp.day3.ui.login.WalmartLoginRegisterPresenter;
import com.example.sumankhatiwada.firstapp.day3.ui.login.WalmartLoginView;
import com.example.sumankhatiwada.firstapp.day6.problem1.webview.WebApp;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginWebApp extends BaseActivity implements WalmartLoginView {


    @BindView(R.id.webView)
    WebView webView;

    WalmartLoginRegisterPresenter walmartLoginPresenter = WalmartLoginRegisterPresenter.getInstance();

    @Override
    protected int getContentView() {
        return R.layout.activity_web_view_impl;
    }
    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
        walmartLoginPresenter.setDefaultUsers();
        setToolbar("Login Web App");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
//        webView.getSettings().setUseWideViewPort(false);
        webView.setInitialScale(220);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.loadUrl("file:///android_asset/login.html");
        webView.addJavascriptInterface(this,"mylogininterface");
    }

//    @OnClick(R.id.loginButton)
    @JavascriptInterface
    public void doLogin(String name, String pass) {

        String userName = name;
        String password = pass;

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
            startActivity(new Intent(LoginWebApp.this, WebApp.class).putExtra("username", username));
            finish();
        } else {
            showToast(LoginWebApp.this, "Login Invalid");
        }
    }
}

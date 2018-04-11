package com.example.sumankhatiwada.firstapp.day6.problem1.webview;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toolbar;

import com.example.sumankhatiwada.firstapp.R;
import com.example.sumankhatiwada.firstapp.base.BaseActivity;
import com.example.sumankhatiwada.firstapp.day6.problem1.domain.WebDomain;
import com.example.sumankhatiwada.firstapp.day6.problem1.frgments.UsefulSitesListFragment;

import butterknife.BindView;

public class WebViewImpl extends BaseActivity {


    @BindView(R.id.webView)
    WebView webView;

    ProgressDialog progressDialog;

    @Override
    protected int getContentView() {
        return R.layout.activity_web_view_impl;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);

        WebDomain webDomain = intent.getParcelableExtra(UsefulSitesListFragment.WEBSITE_KEY);
        String webSiteName = webDomain.getName();
        setToolbar(webSiteName);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.loadUrl(webDomain.getUrl());
        webView.setWebViewClient(new MyWebViewClient());

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

    }


    // Use When the user clicks a link from a web page in your WebView
    private class MyWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return false;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }

        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            showToast(WebViewImpl.this, description);

        }
    }
}

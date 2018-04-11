package com.example.sumankhatiwada.firstapp.day6.problem1.webview;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.sumankhatiwada.firstapp.R;
import com.example.sumankhatiwada.firstapp.base.BaseActivity;
import com.example.sumankhatiwada.firstapp.day5.ViewPagerAdapter;
import com.example.sumankhatiwada.firstapp.day6.problem1.frgments.UsefulSitesPresenter;

import butterknife.BindView;

public class WebApp extends BaseActivity implements ViewPager.OnPageChangeListener {

    @BindView(R.id.pager)
    ViewPager viewPager;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    WebViewPagerAdapter webViewPagerAdapter;
    UsefulSitesPresenter usefulSitesPresenter = UsefulSitesPresenter.getInstance();

    @Override
    protected int getContentView() {
        return R.layout.activity_web_app;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
        setToolbar();
        // Set the ViewPagerAdapter into ViewPager
        webViewPagerAdapter = new WebViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(webViewPagerAdapter);
        viewPager.addOnPageChangeListener(this);

    }

    private void setToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setTitle("Web App");
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        Fragment fragment = webViewPagerAdapter.getFragment(position);
        if (fragment != null) {
            fragment.onResume();
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        usefulSitesPresenter.clear();
        finish();
    }
}

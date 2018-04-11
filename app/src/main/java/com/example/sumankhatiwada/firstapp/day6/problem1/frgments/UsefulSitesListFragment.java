package com.example.sumankhatiwada.firstapp.day6.problem1.frgments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.sumankhatiwada.firstapp.R;
import com.example.sumankhatiwada.firstapp.base.BaseFragment;
import com.example.sumankhatiwada.firstapp.day6.problem1.domain.WebDomain;
import com.example.sumankhatiwada.firstapp.day6.problem1.webview.WebViewImpl;

import java.util.List;

import butterknife.BindView;


public class UsefulSitesListFragment extends BaseFragment implements UsefulSitesView{

    public static final String WEBSITE_KEY="web";

    @BindView(R.id.listview_web)
    ListView listView;


    public UsefulSitesListFragment() {
    }

    public static UsefulSitesListFragment newInstance() {

        Bundle args = new Bundle();

        UsefulSitesListFragment fragment = new UsefulSitesListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    UsefulSitesPresenter usefulSitesPresenter = UsefulSitesPresenter.getInstance();
    @Override
    public int getContentView() {
        return R.layout.fragment_useful_sites_list;
    }

    @Override
    protected void onViewReadyFragment(View view, Intent intent) {
        super.onViewReadyFragment(view, intent);
        usefulSitesPresenter.setDefaultWebSite();
        List<WebDomain> webDomainsList = getWebsitesList();

//        Log.e("StringWebList",webDomainsList.size());
        String[] webList = new String[webDomainsList.size()];
        for(int i = 0 ;i < webDomainsList.size(); i++){

            webList[i] = webDomainsList.get(i).getName();
        }
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,webList);
        listView.setAdapter(stringArrayAdapter);
       listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
           @Override
           public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
               showToast(getActivity(),webDomainsList.get(i).getName());
               alertDialog(getActivity(),"Add to favourite",webDomainsList.get(i));
               return true;
           }
       });
       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               showToast(getActivity(),"Long press to add favourite website");
               WebDomain domain = webDomainsList.get(i);
               startActivity(new Intent(getActivity(),WebViewImpl.class).putExtra(WEBSITE_KEY,domain));
           }
       });
    }

    @Override
    public List<WebDomain> getWebsitesList() {
        return usefulSitesPresenter.getWebList();
    }

    @Override
    public List<WebDomain> getFavWebsitesList() {
        return null;
    }

    @Override
    protected void performAlertPostiveClick(WebDomain webDomain) {

        usefulSitesPresenter.addToFavouriteList(webDomain);
    }



}

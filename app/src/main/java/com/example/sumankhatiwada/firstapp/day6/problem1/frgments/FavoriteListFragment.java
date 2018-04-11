package com.example.sumankhatiwada.firstapp.day6.problem1.frgments;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.sumankhatiwada.firstapp.R;
import com.example.sumankhatiwada.firstapp.base.BaseFragment;
import com.example.sumankhatiwada.firstapp.day6.problem1.domain.WebDomain;
import com.example.sumankhatiwada.firstapp.day6.problem1.webview.WebViewImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.example.sumankhatiwada.firstapp.day6.problem1.frgments.UsefulSitesListFragment.WEBSITE_KEY;

/**
 * Created by sumankhatiwada on 4/10/18.
 */

public class FavoriteListFragment extends BaseFragment {
    @BindView(R.id.listview_web)
    ListView listView;

    Context mContext;


    public FavoriteListFragment() {

    }

    public static FavoriteListFragment newInstance() {
        return new FavoriteListFragment();
    }


    @Override
    public int getContentView() {
        return R.layout.fragment_useful_sites_list;
    }

    @Override
    protected void onViewReadyFragment(View view, Intent intent) {
        super.onViewReadyFragment(view, intent);

    }

    @Override
    public void onResume() {
        super.onResume();
        UsefulSitesPresenter usefulSitesPresenter = UsefulSitesPresenter.getInstance();
        List<WebDomain> favWebDomainList = usefulSitesPresenter.getWebList();
        List<WebDomain> favList = new ArrayList<>();
        for (int i = 0; i<favWebDomainList.size(); i++) {
            if (favWebDomainList.get(i).isFavouriteUrl()) {
                favList.add(favWebDomainList.get(i));
            }
        }
        String[] favWebList = new String[favList.size()];
        for (int i = 0; i < favWebList.length; i++) {
            favWebList[i] = favList.get(i).getName();

        }
        if (favList.size() > 0) {
            ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, favWebList);
            listView.setAdapter(stringArrayAdapter);
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                WebDomain domain = favList.get(i);
                startActivity(new Intent(getActivity(),WebViewImpl.class).putExtra(WEBSITE_KEY,domain));
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }
}

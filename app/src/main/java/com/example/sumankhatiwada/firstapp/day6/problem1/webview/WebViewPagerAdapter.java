package com.example.sumankhatiwada.firstapp.day6.problem1.webview;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.ViewGroup;

import com.example.sumankhatiwada.firstapp.day6.problem1.frgments.FavoriteListFragment;
import com.example.sumankhatiwada.firstapp.day6.problem1.frgments.UsefulSitesListFragment;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by sumankhatiwada on 4/10/18.
 */

public class WebViewPagerAdapter extends FragmentPagerAdapter {
    // Tab Titles
    private String tabtitles[] = new String[]{"Personal Sites", "Favorite"};
    Context context;
    final int PAGE_COUNT = tabtitles.length;
    private Map<Integer, String> mFragmentTags;
    private FragmentManager mFragmentManager;

    public WebViewPagerAdapter(FragmentManager fm) {
        super(fm);
        mFragmentManager = fm;
        mFragmentTags = new HashMap<Integer, String>();
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }



    @Override
    public Fragment getItem(int position) {
//        mObservers.deleteObservers();

        switch (position) {

            // Open website list.java
            case 0:
                return UsefulSitesListFragment.newInstance();

//            // Open AboutMeFragment.java
            case 1:
                return FavoriteListFragment.newInstance();
//
//            // Open WorkExperienceFragment.java
//            case 2:
//                WorkExperienceFragment workExperience = new WorkExperienceFragment();
//                return workExperience;
//
//            case 3:
//                ContactsFragment contactsFragment = new ContactsFragment();
//                return contactsFragment;
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabtitles[position];
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Object object = super.instantiateItem(container, position);
        if (object instanceof Fragment) {
            Fragment fragment = (Fragment) object;
            String tag = fragment.getTag();
            mFragmentTags.put(position, tag);
        }
        return object;
    }

    public Fragment getFragment(int position) {
        Fragment fragment = null;
        String tag = mFragmentTags.get(position);
        if (tag != null) {
            fragment = mFragmentManager.findFragmentByTag(tag);
        }
        return fragment;
    }
}



package com.example.sumankhatiwada.firstapp.day5;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.sumankhatiwada.firstapp.day5.fragments.AboutMeFragment;
import com.example.sumankhatiwada.firstapp.day5.fragments.ContactsFragment;
import com.example.sumankhatiwada.firstapp.day5.fragments.HomeFragment;
import com.example.sumankhatiwada.firstapp.day5.fragments.WorkExperienceFragment;

/**
 * Created by sumankhatiwada on 4/9/18.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {


    // Tab Titles
    private String tabtitles[] = new String[] { "Home", "About Me", "Work Experience","Contact" };
    Context context;
    final int PAGE_COUNT = tabtitles.length;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            // Open HomeFragment.java
            case 0:
                HomeFragment homeFragment = new HomeFragment();
                return homeFragment;

            // Open AboutMeFragment.java
            case 1:
                AboutMeFragment aboutMeFragment = new AboutMeFragment();
                return aboutMeFragment;

            // Open WorkExperienceFragment.java
            case 2:
                WorkExperienceFragment workExperience = new WorkExperienceFragment();
                return workExperience;

            case 3:
                ContactsFragment contactsFragment = new ContactsFragment();
                return contactsFragment;
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabtitles[position];
    }
}

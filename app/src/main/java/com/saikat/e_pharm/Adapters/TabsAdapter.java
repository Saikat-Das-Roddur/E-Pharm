package com.saikat.e_pharm.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.saikat.e_pharm.Fragments.FragmentTab;
import com.saikat.e_pharm.R;

public class TabsAdapter extends FragmentPagerAdapter {
    int numberOfTabs;
    public TabsAdapter(@NonNull FragmentManager fm, int numberOfTabs) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.numberOfTabs = numberOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new FragmentTab("Pending");
            case 1:
                return new FragmentTab("Delivered");
            case 2:
                return  new FragmentTab("Canceled");
            default:
                return new FragmentTab("Pending");

        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}

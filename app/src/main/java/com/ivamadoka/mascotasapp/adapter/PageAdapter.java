package com.ivamadoka.mascotasapp.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class PageAdapter extends FragmentPagerAdapter {

private ArrayList<Fragment> fragmentss;

    public PageAdapter(@NonNull FragmentManager fm, int behavior, ArrayList<Fragment> fragments) {
        super(fm, behavior);
        this.fragmentss = fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentss.get(position);
    }

    @Override
    public int getCount() {
        return fragmentss.size();
    }
}

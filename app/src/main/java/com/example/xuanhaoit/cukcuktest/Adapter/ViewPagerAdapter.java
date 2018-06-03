package com.example.xuanhaoit.cukcuktest.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.xuanhaoit.cukcuktest.View.Diagrams.Frag_Diagrams;
import com.example.xuanhaoit.cukcuktest.View.Frag_Temporarily;
import com.example.xuanhaoit.cukcuktest.View.Order.Frag_order;

/**
 * Created by XuanHaoIT on 10/08/2017.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public static final int NUMBER_PAGE = 3;
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new Frag_order();
                break;
            case 1:
                fragment = new Frag_Diagrams();
                break;
            case 2:
                fragment = new Frag_Temporarily();
                break;
            default:
                fragment = new Frag_order();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 5;
    }
}

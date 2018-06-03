package com.example.xuanhaoit.cukcuktest.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.xuanhaoit.cukcuktest.Model.Area;
import com.example.xuanhaoit.cukcuktest.View.Diagrams.Frag_Diagrams_Floor;

import java.util.List;

/**
 * Created by XuanHaoIT on 21/09/2017.
 */

public class TabsViewPagerAdapter extends FragmentStatePagerAdapter {
    List<Area> areas;
    Context context;
    public TabsViewPagerAdapter(FragmentManager fm, Context context, List<Area> areas) {
        super(fm);
        this.areas = areas;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return Frag_Diagrams_Floor.newInstance(position+1);
    }

    @Override
    public int getCount() {
        return areas.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
//        Log.d("ahha",  areas.get(position).getAreaName());
        return areas.get(position).getAreaName();
    }

    public void updateArea(List<Area> Listareas)
    {
        areas = Listareas;
        notifyDataSetChanged();
    }
}

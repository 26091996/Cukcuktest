package com.example.xuanhaoit.cukcuktest.View.Diagrams;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xuanhaoit.cukcuktest.Adapter.TabsViewPagerAdapter;
import com.example.xuanhaoit.cukcuktest.Model.Area;
import com.example.xuanhaoit.cukcuktest.Model.DinnerTable;
import com.example.xuanhaoit.cukcuktest.Presenter.Pre_Diagrams.Pre_Diagrams;
import com.example.xuanhaoit.cukcuktest.R;

import java.util.List;

/**
 * Created by XuanHaoIT on 21/09/2017.
 */

public class Frag_Diagrams extends Fragment implements IDiagrams
 {
    View view;
    TabLayout tabHost;
    ViewPager pager;
    TabsViewPagerAdapter adapter;
    Toolbar toolbar;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.frag_diagrams, container, false);
        init();

            Pre_Diagrams pre_diagrams = new Pre_Diagrams(this);
            pre_diagrams.GetArea();
        return view;
    }

    public void init()
    {
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        pager =  view.findViewById(R.id.pager);
        tabHost = view.findViewById(R.id.tabHost);
    }

    @Override
    public void ListArea(List<Area> listArea) {
        Log.d("hao", String.valueOf(listArea.size()));
        adapter = new TabsViewPagerAdapter(getChildFragmentManager(), getContext(), listArea);
        pager.setAdapter(adapter);

        tabHost.setupWithViewPager(pager);

        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabHost));

//        for (int i = 0; i < adapter.getCount(); i++) {
//            tabHost.addTab(
//                    tabHost.newTab()
//                            .setText(adapter.getPageTitle(i))
//                            .
//
//            );
//        }
    }

     @Override
     public void ListDinnerTable(List<DinnerTable> dinnerTables) {

     }
 }

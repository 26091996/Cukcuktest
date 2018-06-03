package com.example.xuanhaoit.cukcuktest.View.Diagrams;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.xuanhaoit.cukcuktest.Adapter.GridAdapter;
import com.example.xuanhaoit.cukcuktest.Adapter.TabsViewPagerAdapter;
import com.example.xuanhaoit.cukcuktest.Model.Area;
import com.example.xuanhaoit.cukcuktest.Model.DinnerTable;
import com.example.xuanhaoit.cukcuktest.Presenter.Pre_Diagrams.Pre_Diagrams;
import com.example.xuanhaoit.cukcuktest.Presenter.Pre_Order.Pre_Order;
import com.example.xuanhaoit.cukcuktest.R;
import com.example.xuanhaoit.cukcuktest.View.Menu.ListMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XuanHaoIT on 10/08/2017.
 */

public class Frag_Diagrams_Floor extends Fragment implements IDiagrams {

    GridView gridView;
    GridAdapter gridAdapter;
    TabsViewPagerAdapter pagerAdapter;
    View view;
    Pre_Order pre_order;
    String TenBan;
    List<DinnerTable> listName = new ArrayList<>();
    List<Area> areas = new ArrayList<>();
    public static String Tag = "Tag";
    private int Tang;
    public static Frag_Diagrams_Floor newInstance(int postion)
    {
        Bundle bundle =new Bundle();
        bundle.putInt(Tag,postion);
        Frag_Diagrams_Floor diagrams_floor = new Frag_Diagrams_Floor();
        diagrams_floor.setArguments(bundle);
        return diagrams_floor;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Tang = getArguments().getInt(Tag);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.frag_diagrams_floor,container,false);
        pre_order = new Pre_Order(getContext());
        InitView();
        Pre_Diagrams pre_diagrams = new Pre_Diagrams(this);
        pre_diagrams.GetArea();
        pre_diagrams.GetDinnerTable();

        return view;
    }
    public void InitView()
    {
        gridView = (GridView) view.findViewById(R.id.gridDiagrams);
    }

    @Override
    public void ListDinnerTable(List<DinnerTable> dinnerTables) {
        for (int i = 0;i<dinnerTables.size();i++) {
            if (dinnerTables.get(i).getAreaID() == Tang) {

                    listName.add(new DinnerTable(dinnerTables.get(i).getAreaID(),dinnerTables.get(i).getDinnerTableName(),dinnerTables.get(i).getDinnerTableQuanity(),dinnerTables.get(i).getAreaID(), dinnerTables.get(i).getId()));
            }
        }
        gridAdapter = new GridAdapter(getContext(),listName);
        gridView.setAdapter(gridAdapter);
//        gridAdapter.notifyDataSetChanged();

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent in = new Intent(getActivity(), ListMenu.class);
                String tenban = gridAdapter.getItem(position).getDinnerTableName();
                int idBan = gridAdapter.getItem(position).getDinnerTableID();
                Bundle bundle = new Bundle();
                bundle.putString("TenBan",tenban);
                bundle.putInt("idBan",idBan);
                in.putExtra("Name",bundle);
                startActivity(in);
            }
        });
    }

    @Override
    public void ListArea(List<Area> listAreas) {
        areas = listAreas;
    }
}

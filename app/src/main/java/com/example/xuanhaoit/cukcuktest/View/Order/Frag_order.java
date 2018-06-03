package com.example.xuanhaoit.cukcuktest.View.Order;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.xuanhaoit.cukcuktest.Adapter.OrderAdapter;
import com.example.xuanhaoit.cukcuktest.Adapter.listOrderAdapter;
import com.example.xuanhaoit.cukcuktest.Model.Area;
import com.example.xuanhaoit.cukcuktest.Model.Bill;
import com.example.xuanhaoit.cukcuktest.Model.DinnerTable;
import com.example.xuanhaoit.cukcuktest.Model.list_order;
import com.example.xuanhaoit.cukcuktest.Presenter.Pre_Diagrams.IPre_Diagrams;
import com.example.xuanhaoit.cukcuktest.Presenter.Pre_Diagrams.Pre_Diagrams;
import com.example.xuanhaoit.cukcuktest.Presenter.Pre_Order.Pre_Order;
import com.example.xuanhaoit.cukcuktest.R;
import com.example.xuanhaoit.cukcuktest.Utils.DatabaseHandler;
import com.example.xuanhaoit.cukcuktest.View.Diagrams.IDiagrams;
import com.example.xuanhaoit.cukcuktest.View.Menu.ListMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XuanHaoIT on 10/08/2017.
 */

public class Frag_order extends Fragment implements IDiagrams {

    DatabaseHandler databaseHandler;
    listOrderAdapter listOrderAdapter;
    List<Bill> list = new ArrayList<>();
    List<list_order> list_orders = new ArrayList<>();
    RecyclerView recyclerView;
    Pre_Order pre_order;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_order,container,false);

        databaseHandler = new DatabaseHandler(getContext());
        recyclerView = view.findViewById(R.id.rv_orders);

        Pre_Diagrams pre_diagrams = new Pre_Diagrams(this);
        pre_diagrams.GetArea();
        pre_diagrams.GetDinnerTable();
//        list.add(new list_order("Bàn 1.1","5 người","25/5/2018", "120.000", 0));
//        list.add(new list_order("Bàn 1.2","5 người","25/5/2018", "120.000", 1));

        return view;
    }

    @Override
    public void ListArea(List<Area> listAreas) {

    }

    @Override
    public void ListDinnerTable(List<DinnerTable> dinnerTables) {
        pre_order = new Pre_Order(getContext());
       list = pre_order.getListBill();
        Log.d("hahah", String.valueOf(list.size()));
        listOrderAdapter = new listOrderAdapter(getContext(), list, dinnerTables);
        recyclerView.setAdapter(listOrderAdapter);
        listOrderAdapter.notifyDataSetChanged();
        recyclerView.setLayoutManager(new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.VERTICAL,
                false));
    }
}

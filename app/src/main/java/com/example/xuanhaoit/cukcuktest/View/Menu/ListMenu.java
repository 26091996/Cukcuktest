package com.example.xuanhaoit.cukcuktest.View.Menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.xuanhaoit.cukcuktest.Adapter.ListMenuAdapter;
import com.example.xuanhaoit.cukcuktest.Model.Product;
import com.example.xuanhaoit.cukcuktest.Presenter.Pre_Menu.Pre_Menu;
import com.example.xuanhaoit.cukcuktest.R;
import com.example.xuanhaoit.cukcuktest.View.HomeActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XuanHaoIT on 26/09/2017.
 */

public class ListMenu extends Activity implements IMenu {

    Button btn_HuyBo, btn_DongY;
    RecyclerView listMenu;
    ListMenuAdapter adapter;
    private String TenBan;
    private int idBan;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_menu);
        init();

        Intent in = getIntent();
        Bundle bun = in.getBundleExtra("Name");
        TenBan = bun.getString("TenBan");
        idBan = bun.getInt("idBan",0);

        Pre_Menu pre_menu = new Pre_Menu(this);
        pre_menu.GetAll();

    }

    public void init() {
        listMenu =  findViewById(R.id.lv_menu);
        btn_DongY = findViewById(R.id.btn_DongY);
        btn_HuyBo = findViewById(R.id.btn_HuyBo);

    }

    @Override
    public void GetDSAll(List<Product> listAll) {
        Log.d("product", String.valueOf(listAll.size()));
        adapter = new ListMenuAdapter(this, listAll);
        listMenu.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        listMenu.setLayoutManager(linearLayoutManager);
        listMenu.getLayoutManager().onRestoreInstanceState(listMenu.getLayoutManager().onSaveInstanceState());

        ///////////// get all visibility items
        btn_DongY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(ListMenu.this, More_Table.class);
                ArrayList<Product> visMenus = new ArrayList<>();
                List<Product> menus = adapter.getList();
//                int sl = adapter.sl;
                for (Product m : menus) {

                    if (m.isVisibility()) visMenus.add(m);
                }
                Log.d("hhhhhhh", visMenus.size() + "");
//                iMore_table.GetMenuVisible(visMenus);
                in.putParcelableArrayListExtra("List", visMenus);
                in.putExtra("TenBan",TenBan);
//                in.putExtra("soluong",sl);
                in.putExtra("idBan",idBan);
                startActivity(in);
            }
        });
        btn_HuyBo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(ListMenu.this, HomeActivity.class);
                startActivity(in);
            }
        });

        ///////////////
    }
}

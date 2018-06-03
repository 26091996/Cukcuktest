package com.example.xuanhaoit.cukcuktest.View.Menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xuanhaoit.cukcuktest.Adapter.DetailAdapter;
import com.example.xuanhaoit.cukcuktest.Model.Bill;
import com.example.xuanhaoit.cukcuktest.Model.BillDetail;
import com.example.xuanhaoit.cukcuktest.Model.Product;
import com.example.xuanhaoit.cukcuktest.Presenter.Pre_Order.Pre_Order;
import com.example.xuanhaoit.cukcuktest.Presenter.Pre_Order.Pre_OrderSever;
import com.example.xuanhaoit.cukcuktest.R;
import com.example.xuanhaoit.cukcuktest.Utils.DatabaseHandler;
import com.example.xuanhaoit.cukcuktest.Utils.StringUtils;
import com.example.xuanhaoit.cukcuktest.View.HomeActivity;
import com.example.xuanhaoit.cukcuktest.View.Order.IOrder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by leroi on 11/08/2017.
 */

public class More_Table extends AppCompatActivity implements View.OnClickListener {

    DetailAdapter detailAdapter;
    Pre_Order pre_order;
    DatabaseHandler databaseHandler;
    List<Product> menus = new ArrayList<>();
    RecyclerView rv;
    ImageButton img_Cancel,img_Save;
    TextView txt_TongTien, txt_Ban;
    private String TenBan;
    private Bill bill;
    private int money;
    private int idBan;
    private long id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.more_table);
        init();
        id = new Date().getTime();
        databaseHandler = new DatabaseHandler(this);
        menus = getIntent().getParcelableArrayListExtra("List");
        TenBan = getIntent().getStringExtra("TenBan");
        idBan = getIntent().getIntExtra("idBan",0);
        for (int i = 0;i<menus.size();i++)
        {
            if (menus.get(i)!=null)
            {
            money += (menus.get(i).getProductPrice()*menus.get(i).getQuanity());
            }
        }
        rv = findViewById(R.id.rv_moretable);
        txt_Ban.setText(TenBan);
        txt_TongTien.setText("Tổng tiền: "+money);

        detailAdapter = new DetailAdapter(this, menus);
        rv.setAdapter(detailAdapter);
        rv.setLayoutManager(new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false));
    }

    public void init() {
        img_Cancel = (ImageButton) findViewById(R.id.img_Cancel);
        img_Save = (ImageButton) findViewById(R.id.img_Save);
        txt_TongTien = (TextView) findViewById(R.id.txt_TongTien);
        txt_Ban = (TextView) findViewById(R.id.txt_Ban);
        img_Cancel.setOnClickListener(this);
        img_Save.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.img_Cancel:
                Intent in = new Intent(More_Table.this, HomeActivity.class);
                startActivity(in);
                break;
            case R.id.img_Save:
                InsertBill();
                Intent in1 = new Intent(More_Table.this, HomeActivity.class);
                startActivity(in1);
                break;
        }
    }
    public void InsertBill()
    {
        pre_order = new Pre_Order(this);
        Log.d("id", "InsertBill: "+id);
        pre_order.InsertBill((int) id,idBan, StringUtils.getDate(),money,2,0);
        for (int i=0;i<menus.size();i++)
        {
            Log.d("id1", "InsertBill: "+id);

            pre_order.InsertBillDetail((((int) id/1000)+i),(int) id,menus.get(i).getProductId(),menus.get(i).getProductPrice(),menus.get(i).getQuanity(),"Nothing");
        }
        Toast.makeText(this,"Thành công",Toast.LENGTH_LONG).show();
    }

}

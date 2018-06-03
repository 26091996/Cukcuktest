package com.example.xuanhaoit.cukcuktest.View.Order;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.xuanhaoit.cukcuktest.Adapter.OrderDetailAdapter;
import com.example.xuanhaoit.cukcuktest.Model.Area;
import com.example.xuanhaoit.cukcuktest.Model.Bill;
import com.example.xuanhaoit.cukcuktest.Model.BillDetail;
import com.example.xuanhaoit.cukcuktest.Model.DinnerTable;
import com.example.xuanhaoit.cukcuktest.Model.Product;
import com.example.xuanhaoit.cukcuktest.Presenter.Pre_Diagrams.Pre_Diagrams;
import com.example.xuanhaoit.cukcuktest.Presenter.Pre_Menu.Pre_Menu;
import com.example.xuanhaoit.cukcuktest.Presenter.Pre_Order.Pre_Order;
import com.example.xuanhaoit.cukcuktest.Presenter.Pre_Order.Pre_OrderSever;
import com.example.xuanhaoit.cukcuktest.R;
import com.example.xuanhaoit.cukcuktest.Utils.StringUtils;
import com.example.xuanhaoit.cukcuktest.View.Diagrams.IDiagrams;
import com.example.xuanhaoit.cukcuktest.View.HomeActivity;
import com.example.xuanhaoit.cukcuktest.View.Menu.IMenu;

import java.util.ArrayList;
import java.util.List;

public class Order_Detail extends AppCompatActivity implements IMenu, IDiagrams, IOrder, View.OnClickListener {

    private int pos;
    OrderDetailAdapter detailAdapter;
    Pre_Order pre_order;
    private int idArea;
    List<BillDetail> billDetails = new ArrayList<>();
    List<Product> productList = new ArrayList<>();
    RecyclerView rv_tcb;
    TextView txt_DinnerTable, txt_route_detail, txt_order_date_detail, txt_delivery_date_detail, txt_total_detail;
    ImageButton img_send, img_ok, img_save;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        pos = getIntent().getIntExtra("pos", 0);
        pre_order = new Pre_Order(this);
        Init();
        getList();
        Pre_Menu pre_menu = new Pre_Menu(Order_Detail.this);
        pre_menu.GetAll();
        Pre_Diagrams pre_diagrams = new Pre_Diagrams(this);
        pre_diagrams.GetDinnerTable();
        pre_diagrams.GetArea();
        Log.d("ahihi", "onCreate: " + productList.size());

        Log.d("sdads", "onCreate: "+pre_order.getListBill().get(pos).getGrandTotal());
        txt_total_detail.setText(pre_order.getListBill().get(pos).getGrandTotal()+"");
        txt_delivery_date_detail.setText(StringUtils.getTime());
    }

    public void Init() {
        rv_tcb = findViewById(R.id.rv_tcb);
        txt_DinnerTable = findViewById(R.id.tv_dinnerTable);
        txt_delivery_date_detail = findViewById(R.id.tv_delivery_date_detail);
        txt_order_date_detail = findViewById(R.id.tv_order_date_detail);
        txt_route_detail = findViewById(R.id.tv_route_detail);
        txt_total_detail = findViewById(R.id.tv_total_detail);
        img_ok = findViewById(R.id.img_OK);
        img_save = findViewById(R.id.img_SaveDetail);
        img_send = findViewById(R.id.img_SendDetail);

        img_send.setOnClickListener(this);
        img_save.setOnClickListener(this);
        img_ok.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.img_SendDetail:
                Pre_OrderSever pre_orderSever = new Pre_OrderSever(this,this);
                pre_orderSever.addBill();
                addBillDetail();
                Intent in1 = new Intent(Order_Detail.this, HomeActivity.class);
                startActivity(in1);
                break;
            case R.id.img_SaveDetail:
                pre_order.DeleteBill((int) pre_order.getListBill().get(pos).getBillID());
                Intent in2 = new Intent(Order_Detail.this, HomeActivity.class);
                startActivity(in2);
                break;
            case R.id.img_OK:
                break;
        }
    }
    public void getList() {
        Log.d("ahihi4", "getList: " + pre_order.getListBill().size());
        Log.d("ahihi5", "getList: " + pos);
        Log.d("ahihi8", "getList: " + pre_order.getBillDetail().size());
        for (BillDetail obj : pre_order.getBillDetail()) {
            if (obj.getBillID() == pre_order.getListBill().get(pos).getBillID()) {
                billDetails.add(obj);
            }
        }
        Log.d("ahihi1", "onCreate: " + billDetails.size());
    }

    @Override
    public void GetDSAll(List<Product> listAll) {
        Log.d("listAll", "GetDSAll: " + listAll.size());
        for (BillDetail billDetail : billDetails)
            for (Product product : listAll)
                if (billDetail.getProductID() == product.getProductId()) {
                    productList.add(product);
                }
        Log.d("ahhihi6", "GetDSAll: " + productList.size());
        detailAdapter = new OrderDetailAdapter(this, productList);
        rv_tcb.setAdapter(detailAdapter);
        detailAdapter.notifyDataSetChanged();
        rv_tcb.setLayoutManager(new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false));
    }

    @Override
    public void ListArea(List<Area> listAreas) {
        Log.d("ahhihi56", "GetDSAll: " + idArea);

        for (int i = 0; i < listAreas.size(); i++)
            if (listAreas.get(i).getAreaId() == idArea)
                txt_route_detail.setText(listAreas.get(i).getAreaName());
    }

    @Override
    public void ListDinnerTable(List<DinnerTable> dinnerTables) {
        for (int j = 0; j < dinnerTables.size(); j++)
            if (pre_order.getListBill().get(pos).getDinnerTableID() == dinnerTables.get(j).getDinnerTableID()) {
                txt_DinnerTable.setText(dinnerTables.get(j).getDinnerTableName() + "");
                idArea = dinnerTables.get(j).getAreaID();
                Log.d("ahhihi57", "GetDSAll: " + idArea);

            }
    }

    @Override
    public Bill addBill() {
        Bill bill = new Bill((int) pre_order.getListBill().get(pos).getBillID(), pre_order.getListBill().get(pos).getDinnerTableID(),pre_order.getListBill().get(pos).getBillDate(),pre_order.getListBill().get(pos).getGrandTotal(),pre_order.getListBill().get(pos).getEmployeeID());
        pre_order.DeleteBill((int) pre_order.getListBill().get(pos).getBillID());
        return bill;
    }

    public void addBillDetail() {
        Log.d("ahihi23", "onCreate: " + billDetails.size());
        for (BillDetail obj:billDetails)
        {
                Pre_OrderSever pre_orderSever = new Pre_OrderSever(this);
                pre_orderSever.addBillDetail(obj);
                Log.d("ahihi20", "addBillDetail: "+obj.getBillID());
                pre_order.DeleteBillDetail(obj.getBillDetailID());
        }
    }

}

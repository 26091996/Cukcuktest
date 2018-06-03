package com.example.xuanhaoit.cukcuktest.Presenter.Pre_Order;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.xuanhaoit.cukcuktest.CallBack.IService;
import com.example.xuanhaoit.cukcuktest.Model.Bill;
import com.example.xuanhaoit.cukcuktest.Model.BillDetail;
import com.example.xuanhaoit.cukcuktest.Utils.DatabaseHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leroi on 11/09/2017.
 */

public class Pre_Order {
    private DatabaseHandler dbHandler;
    List<Bill> listBill;
    List<BillDetail> listBillDetail;
    Context context;
    IService iService;

    public Pre_Order(Context context) {
        this.context = context;
    }
    public List<Bill> getListBill() {
        Bill bill;
        dbHandler = new DatabaseHandler(context);
        listBill = new ArrayList<>();
        Cursor cursor = dbHandler.getCursor("SELECT * FROM tbl_bill");
        while (cursor.moveToNext()) {
            bill = new Bill(cursor.getInt(0), cursor.getInt(1), cursor.getString(2),
                    cursor.getInt(3), cursor.getInt(4),cursor.getInt(5));
            listBill.add(bill);
        }
        cursor.close();
        return listBill;
    }
    public void InsertBill(int billId, int dinnerTableID, String billDate, int grandTotal, int employeeID,int status) {
        dbHandler = new DatabaseHandler(context);
        dbHandler.ExcuteSQL("INSERT INTO tbl_bill VALUES (" + billId + ", " + dinnerTableID + ", '" + billDate +
                "', " + grandTotal + ", " + employeeID + ","+status+")");
    }
    public void InsertBillDetail(int billDetailId,int billID, int productID, int billDetailPrice, int billDetailQuanity, String billDetailNote)
    {
        dbHandler = new DatabaseHandler(context);
        dbHandler.ExcuteSQL("INSERT INTO tbl_billDetail VALUES (" + billDetailId + "," + productID + ", " + billID +
                ", " + billDetailQuanity + ", " + billDetailPrice +", '"+billDetailNote+"')");
    }
    public List<BillDetail> getBillDetail()
    {
        BillDetail billDetail;
        dbHandler = new DatabaseHandler(context);
        listBillDetail = new ArrayList<>();
        Cursor cursor = dbHandler.getCursor("SELECT * FROM tbl_billDetail");
        while (cursor.moveToNext()) {
            billDetail = new BillDetail(cursor.getInt(0),cursor.getInt(1),cursor.getInt(2),cursor.getInt(3),cursor.getInt(4),cursor.getString(5));
            listBillDetail.add(billDetail);
        }
        cursor.close();
        return listBillDetail;
    }
    public void DeleteBill(int id) {
        try {
            dbHandler = new DatabaseHandler(context);
            SQLiteDatabase db = dbHandler.getWritableDatabase();
            db.delete("tbl_bill", "billId = '" + id + "'", null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void DeleteBillDetail(int id) {
        try {
            dbHandler = new DatabaseHandler(context);
            SQLiteDatabase db = dbHandler.getWritableDatabase();
            db.delete("tbl_billDetail", "billDetailID = '" + id + "'", null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void UpdateBill(int billId, int dinnerTableID, String billDate, int grandTotal, int employeeID,int status)
    {
        DeleteBill(billId);
        InsertBill(billId,dinnerTableID,billDate,grandTotal,employeeID,status);
    }

    public void Update(int billDetailID, int billID, int productID, int billDetailPrice, int billDetailQuanity, String billDetailNote)
    {
        DeleteBillDetail(billDetailID);
        InsertBillDetail(billDetailID,billID,productID,billDetailPrice,billDetailQuanity,billDetailNote);
    }
}

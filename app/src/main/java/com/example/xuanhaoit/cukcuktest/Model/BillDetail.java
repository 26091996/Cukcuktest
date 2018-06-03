package com.example.xuanhaoit.cukcuktest.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BillDetail implements Serializable {

    @SerializedName("billDetailID")
    @Expose
    private Integer billDetailID;

    @SerializedName("billID")
    @Expose
    private Integer billID;

    @SerializedName("productID")
    @Expose
    private Integer productID;

    @SerializedName("billDetailPrice")
    @Expose
    private Integer billDetailPrice;

    @SerializedName("billDetailQuanity")
    @Expose
    private Integer billDetailQuanity;

    @SerializedName("billDetailNote")
    @Expose
    private String billDetailNote;

    public BillDetail(Integer billDetailID, Integer productID, Integer billID,Integer billDetailQuanity, Integer billDetailPrice,  String billDetailNote) {
        this.billDetailID = billDetailID;
        this.billID = billID;
        this.productID = productID;
        this.billDetailPrice = billDetailPrice;
        this.billDetailQuanity = billDetailQuanity;
        this.billDetailNote = billDetailNote;
    }

    public Integer getBillDetailID() {
        return billDetailID;
    }

    public void setBillDetailID(Integer billDetailID) {
        this.billDetailID = billDetailID;
    }

    public Integer getBillID() {
        return billID;
    }

    public void setBillID(Integer billID) {
        this.billID = billID;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public Integer getBillDetailPrice() {
        return billDetailPrice;
    }

    public void setBillDetailPrice(Integer billDetailPrice) {
        this.billDetailPrice = billDetailPrice;
    }

    public Integer getBillDetailQuanity() {
        return billDetailQuanity;
    }

    public void setBillDetailQuanity(Integer billDetailQuanity) {
        this.billDetailQuanity = billDetailQuanity;
    }

    public String getBillDetailNote() {
        return billDetailNote;
    }

    public void setBillDetailNote(String billDetailNote) {
        this.billDetailNote = billDetailNote;
    }
}

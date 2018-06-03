package com.example.xuanhaoit.cukcuktest.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

public class Bill implements Serializable, Parcelable {

    @SerializedName("billID")
    @Expose
    Integer billID;

    @SerializedName("dinnerTableID")
    @Expose
    Integer dinnerTableID;

    @SerializedName("billDate")
    @Expose
    String billDate;

    @SerializedName("grandTotal")
    @Expose
    Integer grandTotal;

    @SerializedName("employeeID")
    @Expose
    Integer employeeID;

    private int status;

    public Bill() {
    }

    public Bill(Integer billID, Integer dinnerTableID, String billDate, Integer grandTotal, Integer employeeID, int status) {
        this.billID = billID;
        this.dinnerTableID = dinnerTableID;
        this.billDate = billDate;
        this.grandTotal = grandTotal;
        this.employeeID = employeeID;
        this.status = status;
    }

    public Bill(Integer billID, Integer dinnerTableID, String billDate, Integer grandTotal, Integer employeeID) {
        this.billID = billID;
        this.dinnerTableID = dinnerTableID;
        this.billDate = billDate;
        this.grandTotal = grandTotal;
        this.employeeID = employeeID;
    }

    protected Bill(Parcel in) {
        if (in.readByte() == 0) {
            billID = null;
        } else {
            billID = in.readInt();
        }
        if (in.readByte() == 0) {
            dinnerTableID = null;
        } else {
            dinnerTableID = in.readInt();
        }
        billDate = in.readString();
        if (in.readByte() == 0) {
            grandTotal = null;
        } else {
            grandTotal = in.readInt();
        }
        if (in.readByte() == 0) {
            employeeID = null;
        } else {
            employeeID = in.readInt();
        }
        status = in.readInt();
    }

    public static final Creator<Bill> CREATOR = new Creator<Bill>() {
        @Override
        public Bill createFromParcel(Parcel in) {
            return new Bill(in);
        }

        @Override
        public Bill[] newArray(int size) {
            return new Bill[size];
        }
    };

    public long getBillID() {
        return billID;
    }

    public void setBillID(Integer billID) {
        this.billID = billID;
    }

    public Integer getDinnerTableID() {
        return dinnerTableID;
    }

    public void setDinnerTableID(Integer dinnerTableID) {
        this.dinnerTableID = dinnerTableID;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public Integer getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(Integer grandTotal) {
        this.grandTotal = grandTotal;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (billID == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(billID);
        }
        if (dinnerTableID == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(dinnerTableID);
        }
        dest.writeString(billDate);
        if (grandTotal == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(grandTotal);
        }
        if (employeeID == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(employeeID);
        }
        dest.writeInt(status);
    }
}

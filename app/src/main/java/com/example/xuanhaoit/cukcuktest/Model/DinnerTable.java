package com.example.xuanhaoit.cukcuktest.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DinnerTable {

    @SerializedName("dinnerTableID")
    @Expose
    private Integer dinnerTableID;
    @SerializedName("dinnerTableName")
    @Expose
    private String dinnerTableName;
    @SerializedName("dinnerTableQuanity")
    @Expose
    private Integer dinnerTableQuanity;
    @SerializedName("areaID")
    @Expose
    private Integer areaID;
    @SerializedName("id")
    @Expose
    private Integer id;

    public DinnerTable(Integer dinnerTableID, String dinnerTableName, Integer dinnerTableQuanity, Integer areaID, Integer id) {
        this.dinnerTableID = dinnerTableID;
        this.dinnerTableName = dinnerTableName;
        this.dinnerTableQuanity = dinnerTableQuanity;
        this.areaID = areaID;
        this.id = id;
    }

    public Integer getDinnerTableID() {
        return dinnerTableID;
    }

    public void setDinnerTableID(Integer dinnerTableID) {
        this.dinnerTableID = dinnerTableID;
    }

    public String getDinnerTableName() {
        return dinnerTableName;
    }

    public void setDinnerTableName(String dinnerTableName) {
        this.dinnerTableName = dinnerTableName;
    }

    public Integer getDinnerTableQuanity() {
        return dinnerTableQuanity;
    }

    public void setDinnerTableQuanity(Integer dinnerTableQuanity) {
        this.dinnerTableQuanity = dinnerTableQuanity;
    }

    public Integer getAreaID() {
        return areaID;
    }

    public void setAreaID(Integer areaID) {
        this.areaID = areaID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

package com.example.xuanhaoit.cukcuktest.Model;

public class list_order {

    String ban,song,thoigian,tien;
    int trangthai;

    public list_order(String ban, String song, String thoigian, String tien, int trangthai) {
        this.ban = ban;
        this.song = song;
        this.thoigian = thoigian;
        this.tien = tien;
        this.trangthai = trangthai;
    }

    public String getBan() {
        return ban;
    }

    public void setBan(String ban) {
        this.ban = ban;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getThoigian() {
        return thoigian;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }

    public String getTien() {
        return tien;
    }

    public void setTien(String tien) {
        this.tien = tien;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }
}

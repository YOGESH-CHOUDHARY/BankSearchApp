package com.example.banksearchapp;

public class PricelyModel {
    private int simg;
    private String sname;
    private String timestamp;
    private String bestprice;

    public PricelyModel(int simg, String sname, String timestamp, String bestprice) {
        this.simg = simg;
        this.sname = sname;
        this.timestamp = timestamp;
        this.bestprice = bestprice;
    }

    public int getSimg() {
        return simg;
    }

    public void setSimg(int simg) {
        this.simg = simg;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getBestprice() {
        return bestprice;
    }

    public void setBestprice(String bestprice) {
        this.bestprice = bestprice;
    }
}

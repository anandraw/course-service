package com.anand.dto;

public class Course {
    private int cid;
    private String cname;
    private int price;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Course(int cid, String cname, int price) {
        this.cid = cid;
        this.cname = cname;
        this.price = price;
    }

    public Course() {
    }
}

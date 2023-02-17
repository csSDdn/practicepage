package com.example.mpddemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

public class Fc
{
    @TableId(type= IdType.AUTO)
    private int fno;
    private int lno;
    private int hno;

    private String price;
    private String area;
    private String location;
    private String lc;

    @Override
    public String toString() {
        return "Fc{" +
                "fno=" + fno +
                ", lno=" + lno +
                ", hno=" + hno +
                ", price='" + price + '\'' +
                ", area='" + area + '\'' +
                ", location='" + location + '\'' +
                ", lc='" + lc + '\'' +
                '}';
    }

    public int getFno() {
        return fno;
    }

    public void setFno(int fno) {
        this.fno = fno;
    }

    public int getLno() {
        return lno;
    }

    public void setLno(int lno) {
        this.lno = lno;
    }

    public int getHno() {
        return hno;
    }

    public void setHno(int hno) {
        this.hno = hno;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLc() {
        return lc;
    }

    public void setLc(String lc) {
        this.lc = lc;
    }
}

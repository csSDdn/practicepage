package com.example.mpddemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

public class Hx
{
    @TableId(type= IdType.AUTO)
    int hno;
    String pic;
   String price;
   String area;

    @Override
    public String toString() {
        return "Hx{" +
                "hno=" + hno +
                ", pic='" + pic + '\'' +
                ", price='" + price + '\'' +
                ", area='" + area + '\'' +
                '}';
    }

    public int getHno() {
        return hno;
    }

    public void setHno(int hno) {
        this.hno = hno;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
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
}

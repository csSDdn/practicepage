package com.example.mpddemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

//楼盘
public class Lp
{
    @TableId(type= IdType.AUTO)
    private int lno ;
    private String lc;
    private boolean status;


    @Override
    public String toString() {
        return "Lp{" +
                "lno=" + lno +
                ", lc='" + lc + '\'' +
                ", status=" + status +
                '}';
    }

    public int getLno() {
        return lno;
    }

    public void setLno(int lno) {
        this.lno = lno;
    }

    public String getLc() {
        return lc;
    }

    public void setLc(String lc) {
        this.lc = lc;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

package com.example.mpddemo.entity;

import java.security.Timestamp;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Appoint
{
    int fno;
    int uno;
    String time;
    int t_long;
    boolean status;


    @Override
    public String toString() {
        return "Appoint{" +
                "fno=" + fno +
                ", uno=" + uno +
                ", time='" + time + '\'' +
                ", t_long=" + t_long +
                ", status=" + status +
                '}';
    }

    public int getFno() {
        return fno;
    }

    public void setFno(int fno) {
        this.fno = fno;
    }

    public int getUno() {
        return uno;
    }

    public void setUno(int uno) {
        this.uno = uno;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getT_long() {
        return t_long;
    }

    public void setT_long(int t_long) {
        this.t_long = t_long;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}

package com.example.mpddemo.controller;

import com.example.mpddemo.entity.Appoint;
import com.example.mpddemo.mapper.AppointMapper;
import com.example.mpddemo.mapper.FcMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Struct;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
public class AppointController
{
    @Autowired//自动注入，将实例化好的对象放入到appointMapper
    private AppointMapper appointMapper;
    @GetMapping("/findAppoint")
    public List<Appoint> find()
    {
        List<Appoint> a= appointMapper.find();
        for(int i=0;i<a.size();i++)
        {
            String tem=a.get(i).getTime();
            SimpleDateFormat b = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
            Date date=new Date();
            String c=b.format(date);
            int tem1=(a.get(i).getTime().charAt(7)-'0')*10+(a.get(i).getTime().charAt(8)-'0');
            int tem2=(c.charAt(7)-'0')*10+(c.charAt(8)-'0');
            if(tem2-tem1>0)
            {
                delete(a.get(i));
            }
        }
        return appointMapper.find();
    }
    @PostMapping("/Appoint/new_Appoint")
    public int save(Appoint appoint)
    {
        SimpleDateFormat a = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        Date date=new Date();
        String b=a.format(date);
        System.out.println(b);
        appoint.setTime(b);
        appoint.setT_long(1);
        appoint.setStatus(false);
        int i=appointMapper.insert(appoint);
        if(i>0)
        {
            return 1;
        }
        else
        {
            return  0;
        }
    }

    @PostMapping("/Appoint/update_Appoint")
    public boolean update(Appoint appoint)
    {
        appoint.setStatus(true);
        int i=appointMapper.update(appoint);
        if(i>0)
        {
            return true;
        }
        else
        {
            return  false;
        }
    }

    @PostMapping("Appoint/delete_Appoint")
    public boolean delete(Appoint appoint)
    {
        int i=appointMapper.delete(appoint);
        if(i>0)
        {
            return true;
        }
        else
        {
            return  false;
        }
    }



}

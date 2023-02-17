package com.example.mpddemo.controller;


import com.example.mpddemo.entity.Fc;
import com.example.mpddemo.entity.Hx;
import com.example.mpddemo.entity.Lp;
import com.example.mpddemo.mapper.FcMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class FcController
{
    @Autowired//自动注入，将实例化好的对象放入到fcMapper
    private FcMapper fcMapper;
    @PostMapping("/Fc/new_Fc")
    public int save(Fc fc)
    {
        int i=fcMapper.insert(fc);
        List<Fc> x=fcMapper.find();
        int idNum=0;
        for(Fc u:x){
            if(idNum<u.getFno()){
                idNum=u.getFno();
            }
        }
        return idNum;

    }

    @GetMapping("/findFc")
    public List<Fc> find()
    {
        return fcMapper.find();
    }
    @GetMapping("/findFc1")
    public List<Fc> find21()
    {
        return fcMapper.find1();
    }
    @GetMapping("/findFc2")
    public  List<Fc> find2(){return fcMapper.find2();}
    @GetMapping("/findYxFc")
    public List<Fc> find1()
    {
        return fcMapper.findyx();
    }

    @PostMapping("/Fc/update_Fc")
    public boolean update_Lp(Fc fc)
    {
        System.out.println("正在更新用户信息"+fc.getFno());
        int i=fcMapper.update_Fc(fc);
        System.out.println("返回值："+i);
        return i > 0;
    }

    @GetMapping("/findFcgm")
    public List<Fc> findfcgm(int id)
    {
        int tem=id;
        System.out.println("接下来的是要素");
        System.out.println(id);
        return fcMapper.findgm(id);
    }

    @GetMapping("/findfb")
    public  List<Fc> findfb()
    {
        return fcMapper.findfb();
    }

    @GetMapping("/findfb1")
    public  List<Fc> findfb1()
    {
        return fcMapper.findgm11();
    }

    @PostMapping("/Fc/delete_Fc")
    public boolean delete(Fc fc)
    {
        int i=fcMapper.delete_Fc(fc);

        if(i>0)
        {
            return true;
        }
        else
        {
            return false;
        }

    }
}

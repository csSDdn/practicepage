package com.example.mpddemo.controller;

import com.example.mpddemo.entity.Lp;
import com.example.mpddemo.entity.User;
import com.example.mpddemo.mapper.LpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class LpController {
    @Autowired//自动注入，将实例化好的对象放入到lpmapper
    private LpMapper lpmapper;
    @PostMapping("/Lp/new_Lp")
    //注释一下，这个模块主要是用来做楼盘登记的
    public int save(Lp lp)
    {
        //设置楼盘处于未发布状态
        lp.setStatus(false);
        int i=lpmapper.insert(lp);
        List<Lp> x=lpmapper.find();
        int idNum=0;
        for(Lp u:x){
            if(idNum<u.getLno()){
                idNum=u.getLno();
            }
        }
        return idNum;

    }

    @GetMapping("/findLps")
    public List<Lp> findLp()
    {
        return  lpmapper.find();
    }

    @PostMapping("/Lp/update_Lp")
    public boolean update_Lp(Lp lp)
    {
        System.out.println("正在更新用户信息"+lp.getLno());
        int i=lpmapper.update_Lp(lp);
        System.out.println("返回值："+i);
        return i > 0;
    }
    @PostMapping("/Lp/delete_Lp")
    public boolean delete(Lp lp)
    {
        int i=lpmapper.delete(lp);
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

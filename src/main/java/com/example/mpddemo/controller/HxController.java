package com.example.mpddemo.controller;

import com.example.mpddemo.entity.Hx;
import com.example.mpddemo.entity.Lp;
import com.example.mpddemo.mapper.HxMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class HxController
{
    @Autowired//自动注入，将实例化好的对象放入到hxMapper
    private HxMapper hxMapper;
    @PostMapping("/Hx/new_Hx")
    public int save(Hx hx)
    {
        int i=hxMapper.insert(hx);
        List<Hx> x=hxMapper.findHx();
        int idNum=0;
        for(Hx u:x){
            if(idNum<u.getHno()){
                idNum=u.getHno();
            }
        }
        return idNum;
    }
    @GetMapping("/findHx")
    public List<Hx> find()
    {
        return hxMapper.findHx();
    }
}

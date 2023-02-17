package com.example.mpddemo.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mpddemo.entity.User;
import com.example.mpddemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@CrossOrigin//这一注解可以解决本控制器的跨域问题
public class UserController {
    @Autowired//自动注入，将实例化好的对象放入到usermapper
    private UserMapper userMapper;
    @GetMapping("/user")
    public String queryUser(){
        List<User> list=userMapper.find();
        System.out.println(list);
        return "查询用户";
    }



    @PostMapping("/user/new_user")
    public int save(User user){
        System.out.println("正在新建用户………………"+user.getUsername());
        int i=userMapper.insert(user);
        System.out.println("返回值："+i);
        if(!(i>0)){
            return 0;
        }
        List<User> x=userMapper.find();
        int idNum=0;
        for(User u:x){
            if(idNum<u.getId()){
                idNum=u.getId();
            }
        }
        return idNum;
    }

    @PostMapping("/user/new_pw")
    public boolean new_pw(User user){
        System.out.println("正在更新密码"+user.getUsername());
        int i=userMapper.update_pw(user);
        System.out.println("返回值："+i);
        return i > 0;
    }
    @PostMapping("/user/update_user")
    public boolean update_user(User user){
        System.out.println("正在更新用户信息"+user.getId());
        int i=userMapper.update_user(user);
        System.out.println("返回值："+i);
        return i > 0;
    }



    @GetMapping("/user/findByPage")
    public IPage findByPage(){
        Page<User> page=new Page<>(0,2);//current从第几条开始取，取几条
        IPage iPage=userMapper.selectPage(page,null);//IPage是描述结果集合的
        return iPage;
    }


    @GetMapping("/findusers")
    public List<User> findusers(){return userMapper.find();}

    @GetMapping("/find_user")
    public List<User> find_user(int id){
        System.out.println("正在查询用户表…………");
        List<User> x=userMapper.find_user_byID(id);
        System.out.println(x);
        return x;
    }


    @PostMapping("/user/delete_user")
    public boolean delete(User user){
        System.out.println("正在删除…………"+user.getUsername());
        int i=userMapper.delete(user);
        return i>0;
    }

//    @GetMapping("/user/login")
//    public boolean login1(@RequestBody User user){
//        System.out.println("这里是登录的输出");
//        System.out.println(user);
//        return true;
//
//    }
    @PostMapping("/user/login")
    public boolean login(User user){
        System.out.println("正在登录……………………");
        List<User> user1=userMapper.find_user_byID(user.getId());
        if(user1.size()==0) return false;
        if(Objects.equals(user1.get(0).getPassword(), user.getPassword())){
            System.out.println(user);
            return true;
        }
        return false;
    }



}

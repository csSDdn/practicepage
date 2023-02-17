package com.example.mpddemo.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

//这一条注解是告诉mybatis，这个类在数据库中对应的表名，以防因表名不一致引发错误
@TableName("user")
public class User {
    @TableId(type= IdType.AUTO)
    private int id;
    @TableField("username")//当表内属性名称不一致时，可以使用此注解
    private String username;
    private String password;
    private String right;
    @TableField(exist = false)//此属性在数据库无对应值
    private int a;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", right='" + right + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }
}

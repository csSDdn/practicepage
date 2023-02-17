package com.example.mpddemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mpddemo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface UserMapper extends BaseMapper<User> {
    //继承BaseMapper，会自动识别User类并生成相应的接口函数，如查询，有selectList函数
    //此处是mybatis-plus的方法
    @Select("select * from user")
    public List<User> find();


    @Select("SELECT * FROM USER WHERE USERNAME=#{username}")
    public List<User> find_user(String username);

    @Select("SELECT * FROM USER WHERE id=#{id}")
    public List<User> find_user_byID(int id);





    @Insert("insert into user values (#{id},#{username},#{password},#{right})")
    public int insert(User user);



    @Delete("delete from user where id=#{id}")
    public int delete(User user);



    @Update("update user set password=#{password} where username=#{username}")
    public int update_pw(User user);

    @Update("update user set username=#{username},password=#{password} where id=#{id}")
    public int update_user(User user);





    //@results对结果集进行映射，描述如何对对象赋值
//    @Select("select * from user")
//    @Results(
//            {
//                @Result(column = "id",property = "id"),//colum放置数据库中列名，property放置类中属性名
//                @Result(column = "id",property = "orders",javaType = List.class,many=@Many(select=""))
//                    //这里是联表查询，程序会调用@many注解中所描述的mapper方法，并将column中的数据作为参数传入其中，将查询的结果放入到orders中
//                    //这里用many属性表示是一个一对多的关系
//                    //若是一对一的关系，使用one属性
//            }
//    )
//    public List<User> findAllUserAndOrder();


}

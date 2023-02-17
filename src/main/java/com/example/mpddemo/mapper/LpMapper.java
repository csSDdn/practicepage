package com.example.mpddemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mpddemo.entity.Lp;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LpMapper extends BaseMapper<Lp>
{
    @Insert("INSERT INTO lp(lno,lc,status) VALUES(#{lno},#{lc},#{status})")
    public int insert(Lp lp);
    @Update("UPDATE lp SET lc=#{lc},`status`=#{status} WHERE lno=#{lno}")
    public int update_Lp(Lp lp);
    @Select("SELECT * FROM lp")
    public List<Lp> find();
    @Delete("delete from lp where lno=#{lno}")
    public  int delete(Lp lp);
}

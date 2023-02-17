package com.example.mpddemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mpddemo.entity.Hx;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HxMapper extends BaseMapper<Hx>
{

    @Insert("INSERT INTO hx(hno,pic,price,area) VALUES(#{hno},#{pic},#{price},#{area})")
    public int insert(Hx hx);

    @Select("select * from hx")
    public List<Hx> findHx();
}

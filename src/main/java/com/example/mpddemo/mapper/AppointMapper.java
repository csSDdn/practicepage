package com.example.mpddemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mpddemo.entity.Appoint;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AppointMapper extends BaseMapper<Appoint>
{
    @Select("select * from appoint")
    public List<Appoint> find();
    @Insert("insert into appoint(uno,fno,time,t_long,status) values(#{uno}," +
            "#{fno},#{time},#{t_long},#{status})")
    public int insert(Appoint appoint);

    @Update("UPDATE appoint SET `status`=true WHERE uno=#{uno} and fno=#{fno}")
    public int update(Appoint appoint);

    @Delete("delete from appoint where fno=#{fno} and uno=#{uno}")
    public int delete(Appoint appoint);

}

package com.example.mpddemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mpddemo.entity.Fc;
import com.example.mpddemo.entity.Lp;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FcMapper extends BaseMapper<Fc>
{
    @Insert("INSERT INTO fc(fno,lno,hno,location,lc) VALUES(#{fno},#{lno},#{hno},#{location},#{lc})")
    public int insert(Fc fc);
    @Select("SELECT * FROM (\n" +
            "SELECT * FROM b WHERE b.`status`=1\n" +
            ") k WHERE k.gmstatus !=1 OR k.gmstatus is NULL")
    public List<Fc> find();

    @Select("SELECT * FROM b WHERE b.gmstatus =1 and b.status=1 ")
    public List<Fc> find1();
    @Select("SELECT * FROM \n" +
            "(SELECT c.* FROM c,lp WHERE c.lno=lp.lno AND lp.`status`=TRUE) a\n" +
            " WHERE not EXISTS (\n" +
            "SELECT * from appoint WHERE appoint.fno=a.fno\n" +
            ") ")
    public List<Fc> findyx();

    @Select("SELECT * FROM c WHERE EXISTS\n" +
            "(\n" +
            "SELECT * FROM appoint WHERE appoint.fno=c.fno and appoint.status=false AND appoint.uno=#{id}\n" +
            ")")
    public List<Fc> findgm(int id);

    @Select("SELECT * FROM c WHERE  not EXISTS\n" +
            "(\n" +
            "SELECT * FROM appoint WHERE appoint.fno=c.fno and appoint.`status`=TRUE\n" +
            ")")
    public List<Fc> findgm11();

    @Select("SELECT * FROM a WHERE a.`status`=0")
    public  List<Fc> find2();

    @Select("SELECT c.* FROM c,lp WHERE c.lno=lp.lno AND lp.`status`=TRUE")
    public List<Fc> findfb();

    @Update("UPDATE fc SET lno=#{lno},hno=#{hno},location=#{location},area=#{area},price=#{price},lc=#{lc} WHERE fno=#{fno}")
    public int update_Fc(Fc fc);

    @Delete("delete from fc where fno=#{fno}")
    public int delete_Fc(Fc fc);
}

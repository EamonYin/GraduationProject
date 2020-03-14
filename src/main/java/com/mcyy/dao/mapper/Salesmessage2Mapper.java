package com.mcyy.dao.mapper;

import com.mcyy.entity.Salesmessage;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface Salesmessage2Mapper {

    //三表查询出，完整的销售信息
    List<Salesmessage> SelectAllSalesmessage();
    List<Salesmessage> SelectDayInventory(@Param("time0") String time0, @Param("time1") String time1);
    List<Salesmessage> SelectUname();
    List<Salesmessage> SelectByUname(@Param("uname") String uname);
    List<String> SelectSaleTime();
    int insertSalesmessage(@Param("smmid") String smname, @Param("smuid") String smuid, @Param("data") Date data, @Param("count") int count);

}

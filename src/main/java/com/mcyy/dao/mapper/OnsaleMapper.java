package com.mcyy.dao.mapper;

import com.mcyy.entity.Onsale;
import com.mcyy.entity.OnsaleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OnsaleMapper {
    long countByExample(OnsaleExample example);

    int deleteByExample(OnsaleExample example);

    int deleteByPrimaryKey(Integer oId);

    int insert(Onsale record);

    int insertSelective(Onsale record);

    List<Onsale> selectByExample(OnsaleExample example);

    Onsale selectByPrimaryKey(Integer oId);

    int updateByExampleSelective(@Param("record") Onsale record, @Param("example") OnsaleExample example);

    int updateByExample(@Param("record") Onsale record, @Param("example") OnsaleExample example);

    int updateByPrimaryKeySelective(Onsale record);

    int updateByPrimaryKey(Onsale record);
}
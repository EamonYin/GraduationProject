package com.mcyy.dao.mapper;

import com.mcyy.entity.Returns;
import com.mcyy.entity.ReturnsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReturnsMapper {
    long countByExample(ReturnsExample example);

    int deleteByExample(ReturnsExample example);

    int deleteByPrimaryKey(Integer rId);

    int insert(Returns record);

    int insertSelective(Returns record);

    List<Returns> selectByExample(ReturnsExample example);

    Returns selectByPrimaryKey(Integer rId);

    int updateByExampleSelective(@Param("record") Returns record, @Param("example") ReturnsExample example);

    int updateByExample(@Param("record") Returns record, @Param("example") ReturnsExample example);

    int updateByPrimaryKeySelective(Returns record);

    int updateByPrimaryKey(Returns record);
}
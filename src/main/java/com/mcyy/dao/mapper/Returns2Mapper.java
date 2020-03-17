package com.mcyy.dao.mapper;

import com.mcyy.entity.Returns;
import com.mcyy.entity.ReturnsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Returns2Mapper {
   List<Returns> Selectallreturns();
}
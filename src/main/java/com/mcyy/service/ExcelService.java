package com.mcyy.service;

import com.mcyy.entity.Excel;
import com.mcyy.entity.ExcelExample;

import java.util.List;

/**
 * @Author XiaoMing
 * @create 2020/3/5 21:34
 */
public interface ExcelService {

    //把Excel插入到数据库
    int InsertExcel(Excel record);

    //查询数据库Excel表是不是有数据
    List<Excel> ExcelIsNull(ExcelExample example);

    //清空Excel表所有数据
    int DeleteExcel();
}

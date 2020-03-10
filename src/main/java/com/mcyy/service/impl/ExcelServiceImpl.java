package com.mcyy.service.impl;

import com.mcyy.dao.mapper.ExcelMapper;
import com.mcyy.entity.Excel;
import com.mcyy.entity.ExcelExample;
import com.mcyy.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author XiaoMing
 * @create 2020/3/5 21:35
 */
@Service
public class ExcelServiceImpl implements ExcelService {

    @Autowired
    ExcelMapper excelMapper;

    @Override
    public int InsertExcel(Excel record) {
        return excelMapper.insert(record);
    }

    @Override
    public List<Excel> ExcelIsNull(ExcelExample example) {
        return excelMapper.selectByExample(example);
    }

    @Override
    public int DeleteExcel() {
        return excelMapper.DeleteExcel();
    }
}

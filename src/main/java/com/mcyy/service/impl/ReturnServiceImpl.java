package com.mcyy.service.impl;

import com.mcyy.dao.mapper.MedicineMapper;
import com.mcyy.dao.mapper.OnsaleMapper;
import com.mcyy.dao.mapper.Returns2Mapper;
import com.mcyy.dao.mapper.ReturnsMapper;
import com.mcyy.entity.Medicine;
import com.mcyy.entity.MedicineExample;
import com.mcyy.entity.Onsale;
import com.mcyy.entity.Returns;
import com.mcyy.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author XiaoMing
 * @create 2020/3/17 11:34
 */
@Service
public class ReturnServiceImpl implements ReturnService {
    @Autowired
    Returns2Mapper returns2Mapper;
    @Autowired
    ReturnsMapper returnsMapper;
    @Autowired
    MedicineMapper medicineMapper;
    @Autowired
    OnsaleMapper onsaleMapper;

    @Override
    public List<Returns> SelectAllReturns() {
        return returns2Mapper.Selectallreturns();
    }

    @Override
    public int InsertReturns(Returns record) {
        return returnsMapper.insertSelective(record);
    }

    @Override
    public List<Medicine> SelectAllMedicine(MedicineExample example) {
        return medicineMapper.selectByExample(example);
    }

    /*@Override
    public int InsertOnSale(Onsale record) {
        return onsaleMapper.insertSelective(record);
    }*/

    @Override
    public Medicine SelectMedicineById(Integer mId) {
        return medicineMapper.selectByPrimaryKey(mId);
    }
}

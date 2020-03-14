package com.mcyy.service.impl;

import com.mcyy.dao.mapper.MedicineMapper;
import com.mcyy.dao.mapper.Salesmessage2Mapper;
import com.mcyy.dao.mapper.SalesmessageMapper;
import com.mcyy.entity.Medicine;
import com.mcyy.entity.MedicineExample;
import com.mcyy.entity.Salesmessage;
import com.mcyy.entity.SalesmessageExample;
import com.mcyy.service.SaleMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author XiaoMing
 * @create 2020/3/7 19:15
 */
@Service
public class SaleMessageServiceImpl implements SaleMessageService {

    @Autowired
    Salesmessage2Mapper salesmessage2Mapper;

    @Autowired
    SalesmessageMapper salesmessageMapper;

    @Autowired
    MedicineMapper medicineMapper;

    @Override
    public List<Salesmessage> SellectAllSalesmessage() {
        return salesmessage2Mapper.SelectAllSalesmessage();
    }

    @Override
    public int InsertSalemsg(Salesmessage salesmessage) {
        return salesmessageMapper.insert(salesmessage);
    }

    @Override
    public Medicine SelectMedicine(Integer mId) {
        return medicineMapper.selectByPrimaryKey(mId);
    }

    @Override
    public int UpdateInventory(Medicine record, MedicineExample example) {
        return medicineMapper.updateByExampleSelective(record,example);
    }
}

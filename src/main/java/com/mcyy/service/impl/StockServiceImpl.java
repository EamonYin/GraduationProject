package com.mcyy.service.impl;

import com.mcyy.dao.mapper.MedicineMapper;
import com.mcyy.dao.mapper.Stock2Mapper;
import com.mcyy.dao.mapper.StockMapper;
import com.mcyy.entity.Medicine;
import com.mcyy.entity.MedicineExample;
import com.mcyy.entity.Stock;
import com.mcyy.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author XiaoMing
 * @create 2020/3/16 17:07
 */
@Service
public class StockServiceImpl implements StockService {

    @Autowired
    MedicineMapper medicineMapper;
    @Autowired
    StockMapper stockMapper;
    @Autowired
    Stock2Mapper stock2Mapper;

    @Override
    public List<Medicine> AllMedicine(MedicineExample medicineExample) {
        return medicineMapper.selectByExample(medicineExample);
    }

    @Override
    public Medicine TheMedicine(Integer mId) {
        return medicineMapper.selectByPrimaryKey(mId);
    }

    @Override
    public int UpdateTheMedicin(Medicine record, MedicineExample example) {
        return medicineMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int InsertDrugStock(Stock record) {
        return stockMapper.insert(record);
    }

    @Override
    public List<Stock> SelectAllStock() {
        return stock2Mapper.SelectAllStock();
    }
}

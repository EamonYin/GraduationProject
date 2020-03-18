package com.mcyy.service.impl;

import com.mcyy.dao.mapper.MedicineMapper;
import com.mcyy.dao.mapper.OnsaleMapper;
import com.mcyy.entity.Medicine;
import com.mcyy.entity.MedicineExample;
import com.mcyy.entity.Onsale;
import com.mcyy.entity.OnsaleExample;
import com.mcyy.service.OnSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author XiaoMing
 * @create 2020/3/17 10:17
 */
@Service
public class OnSaleServiceImpl implements OnSaleService {

    @Autowired
    OnsaleMapper onsaleMapper;
    @Autowired
    MedicineMapper medicineMapper;

    @Override
    public int InsertOnSale(Onsale record) {
        return onsaleMapper.insertSelective(record);
    }

    @Override
    public List<Onsale> SelectAllOnSale(OnsaleExample example) {
        return onsaleMapper.selectByExample(example);
    }

    @Override
    public Onsale SelectTheOnSale(Integer oId) {
        return onsaleMapper.selectByPrimaryKey(oId);
    }

    @Override
    public int UpdateOnSale(Onsale record,OnsaleExample example) {
        return onsaleMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int UpdateRemark(Medicine record, MedicineExample example) {
        return medicineMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int DeleteById(Integer oId) {
        return onsaleMapper.deleteByPrimaryKey(oId);
    }
}

package com.mcyy.service.impl;

import com.mcyy.dao.mapper.MedicineMapper;
import com.mcyy.entity.Medicine;
import com.mcyy.entity.MedicineExample;
import com.mcyy.service.DrugsManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author XiaoMing
 * @create 2020/3/14 16:24
 */
@Service
public class DrugsManagementServiceImpl implements DrugsManagementService {

    @Autowired
    MedicineMapper medicineMapper;

    @Override
    public List<Medicine> DrugsAllMsg(MedicineExample example) {
        return medicineMapper.selectByExample(example);
    }

    @Override
    public int InsertDrugMsg(Medicine medicine) {
        return medicineMapper.insertSelective(medicine);
    }

    @Override
    public int SelectTheDrugId(String m_name, BigDecimal m_price, int m_inventory, Date m_pastdate, String m_classify) {
        return medicineMapper.SelectTheDrugId(m_name,m_price,m_inventory,m_pastdate,m_classify);
    }

    @Override
    public int updateTheDrugId(Medicine record, MedicineExample example) {
        return medicineMapper.updateByExampleSelective(record,example);
    }
}

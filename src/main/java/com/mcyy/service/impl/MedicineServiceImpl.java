package com.mcyy.service.impl;

import com.mcyy.dao.mapper.MedicineMapper;
import com.mcyy.entity.MedicineExample;
import com.mcyy.entity.Medicine;
import com.mcyy.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author XiaoMing
 * @create 2020/3/7 20:11
 */
@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    MedicineMapper medicineMapper;

    @Override
    public List<Medicine> selectAll(MedicineExample example) {
        return medicineMapper.selectByExample(example);
    }

    @Override
    public int updaterk(Medicine record,MedicineExample example) {
        return medicineMapper.updateByExampleSelective(record,example);
    }

    @Override
    public List<Medicine> selectMedicine(MedicineExample example) {
        return medicineMapper.selectByExample(example);
    }
    @Override
    public int updateMedicine(Medicine record, MedicineExample example) {
        return medicineMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int deleteMedicine(MedicineExample example) {
        return medicineMapper.deleteByExample(example);
    }

}

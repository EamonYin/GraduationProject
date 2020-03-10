package com.mcyy.service;

import com.mcyy.entity.Medicine;
import com.mcyy.entity.MedicineExample;

import java.util.List;

/**
 * @Author XiaoMing
 * @create 2020/3/7 20:10
 */
public interface MedicineService {
    //查询所有药品信息
    List<Medicine> selectAll(MedicineExample example);
}

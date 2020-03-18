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

    //修改记录
    int updaterk(Medicine record,MedicineExample example);

    //编辑 先查找 再修改
    List<Medicine> selectMedicine(MedicineExample example);
    int updateMedicine(Medicine record,MedicineExample example);

    //删除药品
    int deleteMedicine(MedicineExample example);

    //通过OnSale表中的药品名查找Medicine表中对应的药
    Medicine SelectMedicineByName(String MedicineName);

}

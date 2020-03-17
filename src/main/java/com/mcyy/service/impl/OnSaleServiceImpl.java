package com.mcyy.service.impl;

import com.mcyy.dao.mapper.OnsaleMapper;
import com.mcyy.entity.Onsale;
import com.mcyy.service.OnSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author XiaoMing
 * @create 2020/3/17 10:17
 */
@Service
public class OnSaleServiceImpl implements OnSaleService {

    @Autowired
    OnsaleMapper onsaleMapper;

    @Override
    public int InsertOnSale(Onsale record) {
        return onsaleMapper.insertSelective(record);
    }
}

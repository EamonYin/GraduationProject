package com.mcyy.service.impl;

import com.mcyy.dao.mapper.ClientMapper;
import com.mcyy.entity.Client;
import com.mcyy.entity.ClientExample;
import com.mcyy.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author XiaoMing
 * @create 2020/3/15 17:20
 */
@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientMapper clientMapper;

    @Override
    public Client SelectTheClient(String c_clientname , String c_phonenum) {
        return clientMapper.SelectTheClient(c_clientname,c_phonenum);
    }

    @Override
    public int InsertTheClient(Client client) {
        return clientMapper.InsertTheClient(client);
    }

    @Override
    public List<Client> SelectAllClient() {
        return clientMapper.SelectAllClient();
    }

    @Override
    public Client SelectClientById(int cId) {
        return clientMapper.SelectClientById(cId);
    }

    @Override
    public int UpDateClientById(Client record, ClientExample example) {
        return clientMapper.updateByExampleSelective(record,example);
    }
}

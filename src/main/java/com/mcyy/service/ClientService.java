package com.mcyy.service;

import com.mcyy.entity.Client;
import com.mcyy.entity.ClientExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author XiaoMing
 * @create 2020/3/15 17:20
 */
public interface ClientService {
    //根据客户名，客户手机号查询客户是否存在
    Client SelectTheClient(String c_clientname,String c_phonenum);
    //在client表创建用户（插入salemessage_add业务中的新客户）
    int InsertTheClient(Client client);
    //查询所有Client
    List<Client> SelectAllClient();
    //根据Id查询对应的Client
    Client SelectClientById(int cId);
    //更新指定Client信息
    int UpDateClientById(Client record,ClientExample example);

}

package com.mcyy.dao.mapper;

import com.mcyy.entity.Client;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author XiaoMing
 * @create 2020/3/15 17:07
 */
public interface ClientMapper {
    //根据客户名，客户手机号查询客户是否存在
    Client SelectTheClient(@Param("cClientname")String cClientname,@Param("cPhonenum")String cPhonenum);
    //在client表创建用户（插入salemessage_add业务中的新客户）
    int InsertTheClient(Client client);
    //查询所有Client
    List<Client> SelectAllClient();
    //根据Id查询对应的Client
    Client SelectClientById(@Param("cId")int cId);
    //根据id更新用户信息
    int UpDateClientById(@Param("record") Client record, @Param("cId")Integer cId);
    //根据id删除用户
    int DeleteClientById(Integer id);
//    @Options(useGeneratedKeys = true,keyProperty = "c_id", keyColumn = "cId")
//    int InsertTheClient(@Param("cname")String cname , @Param("cpassword")String cpassword , @Param("cphonenum")String cphonenum);
}

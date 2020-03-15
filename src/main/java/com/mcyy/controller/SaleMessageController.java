package com.mcyy.controller;

import com.mcyy.entity.Client;
import com.mcyy.entity.Medicine;
import com.mcyy.entity.MedicineExample;
import com.mcyy.entity.Salesmessage;
import com.mcyy.service.impl.ClientServiceImpl;
import com.mcyy.service.impl.MedicineServiceImpl;
import com.mcyy.service.impl.SaleMessageServiceImpl;
import com.mcyy.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author XiaoMing
 * @create 2020/3/7 18:22
 */
@Controller
public class SaleMessageController {


    /**
     * 文件上传功能
     *
     * @param file
     * @return
     * @throws IOException
     */
    //获取当此上传文件名
    String fileName = null;
    @Autowired
    MedicineServiceImpl msi;
    @Autowired
    SaleMessageServiceImpl smsi;
    @Autowired
    UserServiceImpl usi;
    @Autowired
    ClientServiceImpl csi;
    //存储每一次上传的文件名
    List<Object> allfilename = new ArrayList<>();

    /**
     * 为salemessage-add页面提供数据
     * @param request
     * @return
     */
    @RequestMapping(value = "/addsalemessage", method = {RequestMethod.GET, RequestMethod.POST})
    public String AddSaleMessage(HttpServletRequest request) {

        /*查询所有注册用户名以及用户id——0315老版本，选择指定用户，不能创建新用户*/
        /*UserExample userExample = new UserExample();
        List<User> users = usi.SelectUser(userExample);
        session.setAttribute("users", users);*/

        /*查询所有注册药品名以及药品id*/
        HttpSession session = request.getSession();
        MedicineExample medicineExample = new MedicineExample();
        List<Medicine> medicines = msi.selectAll(medicineExample);
        session.setAttribute("medicines", medicines);

        return "salemessage-add";
    }

    /**
     * 查询所有销售记录
     *
     * @param request
     * @return 销量页面
     */
    @RequestMapping(value = "/salemessage", method = {RequestMethod.GET, RequestMethod.POST})
    public String SaleMessage(HttpServletRequest request) {
        List<Salesmessage> salesmessages = smsi.SellectAllSalesmessage();

        HttpSession session = request.getSession();
        session.setAttribute("salesmessages", salesmessages);
        System.out.println(salesmessages);

        return "SaleMessage";
    }

    @RequestMapping(value = "/submitting_add", method = {RequestMethod.GET, RequestMethod.POST})
    public String submitting(HttpServletRequest request) throws ParseException {

        //数据库salemessage表存的是用户id和药名id，所以，此处获取的是id
        String ClientName = request.getParameter("ClientName");
        String ClientPhone = request.getParameter("ClientPhone");
        String drugName_id = request.getParameter("DrugName_id");
        String purchased = request.getParameter("Purchased");
        String salesTime = request.getParameter("SalesTime");

        System.out.println("哆啦A梦" + ClientName + "," + ClientPhone + "," + drugName_id + "," + purchased + "," + salesTime);

        //字符串时间转date
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = simpleDateFormat.parse(salesTime);

        //查看客户是否为新用户
        Client client = csi.SelectTheClient(ClientName, ClientPhone);
        //客户不存在
        if (client == null) {
            Client client1 = new Client();
            client1.setcClientname(ClientName);
            client1.setcPhonenum(ClientPhone);
            client1.setcPassword("000000");
            //在client表创建用户,返回c_id
            csi.InsertTheClient(client1);
            //查找c_id
            int cId = client1.getcId();
            //插入salemessage表
            Salesmessage salesmessage1 = new Salesmessage();
            int Inventory = Integer.parseInt(purchased);
            salesmessage1.setSmInventory(Inventory);
            int Medicineid = Integer.parseInt(drugName_id);
            salesmessage1.setSmMedicineid(Medicineid);
            salesmessage1.setSmUserid(cId);
            salesmessage1.setSmData(date);
            System.out.println("用户不存在");
            smsi.InsertSalemsg(salesmessage1);
        }
        //客户存在
        else {
            Salesmessage salesmessage = new Salesmessage();
            int Inventory = Integer.parseInt(purchased);
            salesmessage.setSmInventory(Inventory);
            int Medicineid = Integer.parseInt(drugName_id);
            salesmessage.setSmMedicineid(Medicineid);
            salesmessage.setSmUserid(client.getcId());
            salesmessage.setSmData(date);
            System.out.println("客户存在直接插入");
            smsi.InsertSalemsg(salesmessage);
        }

 /*       //将前台获取数据持久化到数据库中
        Salesmessage salesmessage = new Salesmessage();
        int Inventory = Integer.parseInt(purchased);
        salesmessage.setSmInventory(Inventory);
        int Medicineid = Integer.parseInt(drugName_id);
        salesmessage.setSmMedicineid(Medicineid);
        salesmessage.setSmUserid(Integer.parseInt(userName_id));
        salesmessage.setSmData(date);

        smsi.InsertSalemsg(salesmessage);

        //更新medicine表库存
        Medicine medicine1 = smsi.SelectMedicine(Medicineid);
        Integer OldInventory = medicine1.getmInventory();
        Medicine medicine = new Medicine();
        Integer NewInventory = OldInventory - Inventory;
        medicine.setmInventory(NewInventory);
        MedicineExample medicineExample = new MedicineExample();
        MedicineExample.Criteria criteria = medicineExample.createCriteria();
        criteria.andMIdEqualTo(Medicineid);
        int i = smsi.UpdateInventory(medicine, medicineExample);
        System.out.println("添加后，库存更新："+i);
*/
        return "SaleMessage";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(MultipartFile file) throws IOException {
        //得到上传文件名
        fileName = file.getOriginalFilename();
        //存储每一次上传的文件名
        allfilename.add(fileName);
        //文件上传地址
        String path = "F:\\file";
        //创建文件流
        File dir = new File(path, fileName);
        //如果父目录不存在，连同父目录一起创建。
        if (!dir.exists()) {
            dir.mkdirs();
        }
        //MultipartFile自带的解析方法
        file.transferTo(dir);
        return "SaleMessage";
    }

}

package com.mcyy.controller;

import com.mcyy.entity.Medicine;
import com.mcyy.entity.MedicineExample;
import com.mcyy.service.impl.DrugsManagementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author XiaoMing
 * @create 2020/3/14 16:18
 */
@Controller
public class DrugsManagementController {

    @Autowired
    DrugsManagementServiceImpl dmsi;

    /**
     * 进入药品管理页面
     * @param request
     * @return
     */
    @RequestMapping("/GoDrugManage")
    public String GoDrugManage(HttpServletRequest request){
        MedicineExample medicineExample = new MedicineExample();
        List<Medicine> DrugsMsgs = dmsi.DrugsAllMsg(medicineExample);
        System.out.println("hahaha"+DrugsMsgs);
        int nums = DrugsMsgs.size();

        HttpSession session = request.getSession();
        session.setAttribute("DrugMsgs",DrugsMsgs);
        session.setAttribute("nums",nums);

        return "DrugsManagement";
    }

    /**
     * 跳转添加药品弹出层
     * @return
     */
    @RequestMapping("/GoDrugManageAdd")
    public String GoDrugManageAdd(){
        return "DrugsManagement_add";
    }

    @RequestMapping(value = "/AddDrugMsg" , method = {RequestMethod.POST,RequestMethod.GET})
    public String AddDrugMsg(HttpServletRequest request) throws ParseException {
        String drug_name = request.getParameter("drug_name");
        String drug_price = request.getParameter("drug_price");
        String drug_count = request.getParameter("drug_count");
        String drug_date = request.getParameter("drug_date");
        String drug_classify = request.getParameter("drug_classify");
        //将前台获取信息set到medicine中
        Medicine medicine = new Medicine();
        medicine.setmName(drug_name);
        //格式化价格类型
        BigDecimal drug_pricel = new BigDecimal(drug_price);
        medicine.setmPrice(drug_pricel);
        //格式化库存类型
        int drug_count1 = Integer.parseInt(drug_count);
        medicine.setmInventory(drug_count1);
        //格式化获取到的时间类型
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(drug_date);
        medicine.setmPastdate(date);

        medicine.setmClassify(drug_classify);

        //持久化到数据库
        int i = dmsi.InsertDrugMsg(medicine);

        //查询指定的添加药品，并返回m_id(int)
        int drug_id = dmsi.SelectTheDrugId(drug_name, drug_pricel, drug_count1, date , drug_classify);
        System.out.println("查询指定的添加药品，并返回m_id(int)"+drug_id);

        //更新 medicine表 中 m_medicineid = m_id
        Medicine medicine1 = new Medicine();
        medicine1.setmMedicineid(drug_id);
        MedicineExample medicineExample = new MedicineExample();
        MedicineExample.Criteria criteria = medicineExample.createCriteria();
        criteria.andMIdEqualTo(drug_id);
        int i1 = dmsi.updateTheDrugId(medicine1, medicineExample);
        System.out.println("更新了！！！！"+i1);

        return "DrugsManagement";


    }

}

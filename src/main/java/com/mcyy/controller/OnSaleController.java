package com.mcyy.controller;

import com.alibaba.fastjson.JSON;
import com.mcyy.entity.Medicine;
import com.mcyy.entity.MedicineExample;
import com.mcyy.entity.Onsale;
import com.mcyy.entity.OnsaleExample;
import com.mcyy.service.impl.MedicineServiceImpl;
import com.mcyy.service.impl.OnSaleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 问题药品页面
 * @Author XiaoMing
 * @create 2020/3/17 10:16
 */
@Controller
public class OnSaleController {
    @Autowired
    OnSaleServiceImpl ossi;
    @Autowired
    MedicineServiceImpl msi;

    /**
     * 跳转OnSale页，并查表显示
     * @param request
     * @return
     */
    @RequestMapping("/GoOnsalePage")
    public String GoOnsalePage(HttpServletRequest request){
        OnsaleExample onsaleExample = new OnsaleExample();
        List<Onsale> onsales = ossi.SelectAllOnSale(onsaleExample);
        HttpSession session = request.getSession();
        session.setAttribute("OnSales",onsales);

        return "OnSale";
    }

    /**
     * 根据要编辑的药品id，返回给前台显示药品其他信息
     * @param request
     * @param OnSaleDrugId
     */
    @RequestMapping(value = "/ShowOnSaleMsg" , method = RequestMethod.POST)
    public void ShowOnSaleMsg(HttpServletRequest request , String OnSaleDrugId , HttpServletResponse response) throws IOException {
        Onsale onsale = ossi.SelectTheOnSale(Integer.parseInt(OnSaleDrugId));

        request.setAttribute("TheOnSale",onsale);
        String result = JSON.toJSONString(onsale);
        PrintWriter pw = response.getWriter();
        pw.write(result);
        pw.flush();
        pw.close();
    }

    /**
     * 更新对应药品Osale表o_count数量,添加medicine表remark
     * @param request
     */
    @RequestMapping(value = "/UpDateOnSale")
    public void UpDate(HttpServletRequest request){
        String onSaleId = request.getParameter("OnSaleId");
        String onSaleCount = request.getParameter("OnSaleCount");
        String mRemark = request.getParameter("mRemark");
        String oName = request.getParameter("oName");

        //更新OnSale表的Count
        Onsale oldonsale = ossi.SelectTheOnSale(Integer.parseInt(onSaleId));
        Integer OldCount = oldonsale.getoCount();
        Integer NewCount = OldCount - Integer.parseInt(onSaleCount);
        OnsaleExample onsaleExample = new OnsaleExample();
        OnsaleExample.Criteria OnSalecriteria = onsaleExample.createCriteria();
        OnSalecriteria.andOIdEqualTo(Integer.parseInt(onSaleId));
        Onsale onsale = new Onsale();
        onsale.setoCount(NewCount);
        ossi.UpdateOnSale(onsale,onsaleExample);

        //更新Medicine表Remark
        Medicine medicine = msi.SelectMedicineByName(oName);
        medicine.setmRemark(medicine.getmRemark()+";"+mRemark);
        MedicineExample medicineExample = new MedicineExample();
        MedicineExample.Criteria medicinecriteria = medicineExample.createCriteria();
        medicinecriteria.andMNameEqualTo(oName);
        msi.updateMedicine(medicine,medicineExample);

    }

    /**
     * 删除OnSale表指定对象
     * @param request
     */
    @RequestMapping("/DeleteIt")
    public String  DeleteIt(HttpServletRequest request,String OnSaleId){
        ossi.DeleteById(Integer.parseInt(OnSaleId));
        return "redirect:/GoOnsalePage";
    }

}

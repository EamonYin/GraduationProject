package com.mcyy.controller;

import com.alibaba.fastjson.JSON;
import com.mcyy.entity.Medicine;
import com.mcyy.entity.MedicineExample;
import com.mcyy.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Controller
public class MedicineController {

    @Autowired
    MedicineService medicineService;

    /**
     *  跳转medicine页面
      * @param model
     * @return
     */
    @RequestMapping("/medicine")
    public String medicine(Model model){
        MedicineExample example = new MedicineExample();
        List<Medicine> list = medicineService.selectAll(example);
        int num = list.size();
        model.addAttribute("num",num);
        for(int i=0;i<list.size();i++){
            Date etime = list.get(i).getmPastdate();
            //当前时间
            Date date = new Date();
            int day = (int) ((date.getTime()-etime.getTime())/(1000*3600*24));
            //库存
            int inv = list.get(i).getmInventory();
            if(day>0&&inv<11){
                list.get(i).setmState("过期 库存过低");
            }else if(day>0&&inv>10){
                list.get(i).setmState("过期");
            }else if(day<0&&inv<11){
                list.get(i).setmState("库存过低");
            }else{
                list.get(i).setmState("正常");
            }
        }
        model.addAttribute("list",list);
        return  "medicine";
    }

    /**
     * 添加记录
     * @param request
     * @return
     */
    @RequestMapping("/addRemark")
    public String updatark(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("r1"));
        request.getParameter("mRemark");
        Medicine medicine = new Medicine();
        MedicineExample medicineExample = new MedicineExample();
        medicine.setmRemark(request.getParameter("mRemark"));
        MedicineExample.Criteria criteria = medicineExample.createCriteria();
        criteria.andMMedicineidEqualTo(id);
        int i = medicineService.updaterk(medicine,medicineExample);
        return "redirect:/medicine";
    }

    /**
     * 查询药品信息，然后修改
     * @param request
     * @param response
     * @param mmid
     * @return
     */
    @RequestMapping("/selectMedicine")
    public String yao(HttpServletRequest request, HttpServletResponse response, int mmid){
        MedicineExample medicineExample = new MedicineExample();
        MedicineExample.Criteria criteria = medicineExample.createCriteria();
        criteria.andMMedicineidEqualTo(mmid);
        List<Medicine> ls = medicineService.selectMedicine(medicineExample);
        Medicine md = ls.get(0);
        request.setAttribute("asc",md);
        String result = JSON.toJSONString(md);
        try {
            PrintWriter pw = response.getWriter();
            pw.write(result);
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 更新药品信息
     * @param request
     * @return
     */
    @RequestMapping("/updateMedicine")
    public String updateMedicine(HttpServletRequest request){
        Medicine medicine = new Medicine();
        MedicineExample medicineExample = new MedicineExample();
        medicine.setmMedicineid(Integer.parseInt(request.getParameter("mMedicineid")));
        medicine.setmName(request.getParameter("mName"));
        medicine.setmClassify(request.getParameter("mClassify"));
        medicine.setmPrice(new BigDecimal(request.getParameter("mPrice")));
        MedicineExample.Criteria criteria = medicineExample.createCriteria();
        criteria.andMMedicineidEqualTo(Integer.parseInt(request.getParameter("mMedicineid")));
        int i = medicineService.updateMedicine(medicine,medicineExample);
        return "redirect:/medicine";
    }

    /**
     * 删除药品
     * @param mMedicineid
     * @return
     */
    @RequestMapping("/deleteMedicine")
    public String deleteMedicine(int mMedicineid){
        MedicineExample medicineExample = new MedicineExample();
        MedicineExample.Criteria criteria = medicineExample.createCriteria();
        criteria.andMMedicineidEqualTo(mMedicineid);
        int i = medicineService.deleteMedicine(medicineExample);
        return "redirect:/medicine";
    }

    /**
     * 模糊查询
     * @param model
     * @param mn
     * @return
     */
    @RequestMapping("/selectM")
    public String selectM(Model model,String mn){
        MedicineExample medicineExample = new MedicineExample();
        MedicineExample.Criteria criteria = medicineExample.createCriteria();
        criteria.andMNameLike("%"+mn+"%");

        List<Medicine> list = medicineService.selectMedicine(medicineExample);
        int num = list.size();
        model.addAttribute("num",num);
        for(int i=0;i<list.size();i++){
            Date etime = list.get(i).getmPastdate();
            //当前时间
            Date date = new Date();
            int day = (int) ((date.getTime()-etime.getTime())/(1000*3600*24));
            //库存
            int inv = list.get(i).getmInventory();
            if(day>0&&inv<11){
                list.get(i).setmState("过期 库存过低");
            }else if(day>0&&inv>10){
                list.get(i).setmState("过期");
            }else if(day<0&&inv<11){
                list.get(i).setmState("库存过低");
            }
        }
        model.addAttribute("list",list);
        return "medicine";
    }

}

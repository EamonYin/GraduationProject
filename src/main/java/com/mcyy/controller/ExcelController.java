package com.mcyy.controller;

import com.alibaba.excel.EasyExcel;
import com.mcyy.entity.Excel;
import com.mcyy.entity.ExcelExample;
import com.mcyy.service.impl.ExcelServiceImpl;
import com.mcyy.service.impl.TestSelectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author XiaoMing
 * @create 2020/3/1 18:47
 */
@Controller
public class ExcelController {

    @Autowired
    ExcelServiceImpl esi;

    @RequestMapping("/goexcel")
    public String ExcelPage(){
        return "ExcelPage";
    }

    /**
     * 解析上传的excel表格，并显示到页面上
     * @param file
     * @param request
     * @return
     * @throws IOException
     */

    List<Excel> ExcelList = null;

    @RequestMapping("/import")
    public String ImportExcel(@RequestParam MultipartFile file , HttpServletRequest request) throws IOException {

        ExcelExample example = new ExcelExample();
        List<Excel> nullornot = esi.ExcelIsNull(example);
        if(nullornot.size() != 0){
            esi.DeleteExcel();
        }

        InputStream inputStream = file.getInputStream();

        ExcelList = EasyExcel.read(inputStream)
                .head(Excel.class)
                // 设置sheet,默认读取第一个
                .sheet()
                // 设置标题所在行数
                .headRowNumber(1)
                .doReadSync();

        System.out.println(ExcelList);

        //持久化excel表
        for (Excel excel : ExcelList) {
            esi.InsertExcel(excel);
        }

        HttpSession session = request.getSession();
        session.setAttribute("excels" , ExcelList);

        return "redirect:/goexcel";
    }

    /**
     * 导出页面上的excel表
     * @param response
     * @throws IOException
     */
    @RequestMapping("/export")
    public void ExportExcel(HttpServletResponse response) throws IOException {

        // 获取页面上的Excel
        List<Excel> excels = new ArrayList<>();
        //将页面上的数据导出成excel
        for ( Excel excel : ExcelList) {
            excels.add(excel);
        }

        //设置JSP页面导出为excel表
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 防止中文乱码
        String fileName = URLEncoder.encode("导出", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), Excel.class)
                .sheet("sheet0")
                .doWrite(excels);
    }



}

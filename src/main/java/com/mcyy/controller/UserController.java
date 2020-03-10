package com.mcyy.controller;

import com.mcyy.entity.User;
import com.mcyy.entity.UserExample;
import com.mcyy.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserServiceImpl usi;

    /**
     * 用户登录业务
     * @param response
     * @param request
     * @param userExample
     * @return 登录页面
     */
    @RequestMapping("/opinionUser")
    public String OpinionUser(HttpServletResponse response, HttpServletRequest request, UserExample userExample) {
        String username = null;
        String pwd = null;
        //查询用户
        List<User> users = usi.SelectUser(userExample);

        System.out.println("所有" + users);

        //获取前台输入的用户名
        String uname = request.getParameter("name");
        //获取前台输入的用户密码
        String password = request.getParameter("password");
        System.out.println("前台获取用户名" + uname);
        System.out.println("嵌套获取密码" + password);

        //遍历数据库中的用户集合中的，用户名，密码，权限
        for (User u : users) {
            username = u.getuUsername();
            pwd = u.getuPassword();
            Integer limit = u.getuLimit();
            System.out.println("增强循环" + username + pwd);

            //管理人员进入index首页
            if (uname.equals(username) && password.equals(pwd)&& limit==0) {
                System.out.println("1111111111111111111111111");
                return "index";

            //非管理员进入 medicineList 页面
            }else if(uname.equals(username) && password.equals(pwd) && limit!=0){
                return "redirect:/medicineList";
            }
        }
        System.out.println("2222222222222222222222222222");
        return "login";
    }

    /**
     * 用户注册
     * @param request
     * @return
     */
    @RequestMapping("/registerUser")
    public String registerUser(HttpServletRequest request) {
        //获取前端注册页面，输入的注册用户名，密码
        String rname = request.getParameter("rname");
        String rpassword = request.getParameter("rpassword");

        System.out.println("前台获取(注册)用户名" + rname);
        System.out.println("嵌套获取（注册）密码" + rpassword);

            //将注册的新用户（管理员）持久化
            User user = new User();
            user.setuUsername(rname);
            user.setuPassword(rpassword);
            user.setuLimit(0);
            usi.InsertUser(user);
            return "login";

    }


}

package com.mcyy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    /**
     * 登录页面
     * @return
     */
    @RequestMapping("/login")
    public String text(){
        return "login";
    }

    /**
     * 系统welcome页（index页右侧）
     * @return
     */
    @RequestMapping("/welcome")
    public String welcome(){
        return "welcome";
    }

}

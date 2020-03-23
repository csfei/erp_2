package com.cuisf.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2020-03-21.
 */
@Controller
@RequestMapping("/sys")
public class SystemController {

    /**
     * 跳转到登录界面
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin(){

        return "system/index/login";

    }
    /**
     * 跳转到首界面
     * @return
     */
    @RequestMapping("/index")
    public String toIndex(){

        return "system/index/index";
    }
}

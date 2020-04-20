package com.cuisf.sys.controller;

import com.cuisf.sys.common.ActiverUser;
import com.cuisf.sys.common.ResultObj;
import com.cuisf.sys.common.WebUtils;
import com.cuisf.sys.entity.Loginfo;
import com.cuisf.sys.service.LoginfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by Administrator on 2020-03-23.
 */
@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    LoginfoService loginfoService;

    @RequestMapping("/login")
    public ResultObj login(String loginname,String pwd){
        Subject subject = SecurityUtils.getSubject();

        AuthenticationToken token = new UsernamePasswordToken(loginname, pwd);

        try {
            subject.login(token);
            ActiverUser activerUser = (ActiverUser) subject.getPrincipal();
            WebUtils.getSession().setAttribute("user",activerUser.getUser());
            //记录登录日志
            Loginfo loginfo  = new Loginfo();
            loginfo.setLoginname(activerUser.getUser().getName()+"-"+activerUser.getUser().getLoginname());
            loginfo.setLoginip(WebUtils.getRequest().getRemoteAddr());
            loginfo.setLogintime(new Date());
            loginfoService.save(loginfo);

            return ResultObj.LOGIN_SUCCESS;
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return ResultObj.LOGIN_ERROR_PASS;
        }

    }
}

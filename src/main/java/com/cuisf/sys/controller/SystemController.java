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


    /**
     * 跳转到桌面
     * @return
     */
    @RequestMapping("/toDeskManager")
    public String toDeskManager(){

        return "system/index/deskManager";
    }



    /**
     * 跳转到日志管理界面
     * @return
     */
    @RequestMapping("/toLoginfoManager")
    public String toLoginfoManager() {

        return "system/loginfo/loginfoManager";
    }

    /**
     * 跳转到日志管理界面
     * @return
     */
    @RequestMapping("/toNoticeManager")
    public String toNoticeManager() {

        return "system/notice/noticeManager";
    }

    /**
     * 跳转到部门管理界面
     * @return
     */
    @RequestMapping("/toDeptManager")
    public String toDeptManager() {

        return "system/dept/deptManager";
    }
    /**
     * 跳转到部门管理界面--left
     * @return
     */
    @RequestMapping("/toDeptLeft")
    public String toDeptLeft() {

        return "system/dept/deptLeft";
    }
    /**
     * 跳转到部门管理界面 --right
     * @return
     */
    @RequestMapping("/toDeptRight")
    public String toDeptRight() {

        return "system/dept/deptRight";
    }
    /**
     * 跳转到c菜单管理界面
     * @return
     */
    @RequestMapping("/toMenuManager")
    public String toMenuManager() {

        return "system/menu/menuManager";
    }
    /**
     * 跳转到菜单管理界面--left
     * @return
     */
    @RequestMapping("/toMenuLeft")
    public String toMenuLeft() {

        return "system/menu/menuLeft";
    }
    /**
     * 跳转到菜单管理界面 --right
     * @return
     */
    @RequestMapping("/toMenuRight")
    public String toMenuRight() {

        return "system/menu/menuRight";
    }
    /**
     * 跳转到权限管理界面
     * @return
     */
    @RequestMapping("/toPermissionManager")
    public String toPermissionManager() {

        return "system/permission/permissionManager";
    }
    /**
     * 跳转到权限管理界面--left
     * @return
     */
    @RequestMapping("/toPermissionLeft")
    public String toPermissionLeft() {

        return "system/permission/permissionLeft";
    }
    /**
     * 跳转到权限菜单管理界面 --right
     * @return
     */
    @RequestMapping("/toPermissionRight")
    public String toPermissionRight() {

        return "system/permission/permissionRight";
    }

    /**
     * 跳转到角色管理界面
     * @return
     */
    @RequestMapping("/toRoleManager")
    public String toRoleManager() {

        return "system/role/roleManager";
    }

    /**
     * 跳转到用户管理界面 --right
     * @return
     */
    @RequestMapping("/toUserManager")
    public String toUserManager() {

        return "system/user/userManager";
    }

}

package com.cuisf.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cuisf.sys.common.*;
import com.cuisf.sys.entity.Permission;
import com.cuisf.sys.entity.User;
import com.cuisf.sys.service.PermissionService;
import com.cuisf.sys.vo.PermissionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020-03-25.
 */
@RestController
@RequestMapping("menu")
public class MenuController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/loadIndexLeftMenuJson")
    public DataGridView loadIndexLeftMenuJson(PermissionVo permissionVo){

        QueryWrapper<Permission> queryWrapper = new QueryWrapper();
        queryWrapper.eq("type", Constast.TYPE_MEAU);
        queryWrapper.eq("available",Constast.AVALIABLE_TRUE);
        User user = (User) WebUtils.getSession().getAttribute("user");
        List<Permission> list =null;
        if (user.getType() == Constast.USER_TYPE_SUPER){
            list = permissionService.list(queryWrapper);
        }else {
            //TODO  根据用户ID+角色+权限去查询
        }

        //构造层级关系
        List<TreeNode> treeNodes = new ArrayList<>();
        for (Permission p :list) {
            Integer id = p.getId();
            Integer pid=p.getPid();
            String title=p.getTitle();
            String icon=p.getIcon();
            String href=p.getHref();
            Boolean spread = p.getOpen() == Constast.OPEN_TURE ? true : false;
            treeNodes.add(new TreeNode(id, pid, title, icon, href, spread));
        }

        List<TreeNode> build = TreeNodeBuilder.build(treeNodes, 1);

        return new DataGridView(build);
    }
}

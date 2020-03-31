package com.cuisf.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.cuisf.sys.common.DataGridView;
import com.cuisf.sys.entity.Loginfo;
import com.cuisf.sys.service.LoginfoService;
import com.cuisf.sys.vo.LoginfoVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2020-03-31.
 */
@RestController
@RequestMapping("/loginfo")
public class LoginfoController {

    @Autowired
    private LoginfoService loginfoService;


    @RequestMapping("/loadAllLoginfo")
    public DataGridView loadAllLoginfo(LoginfoVo loginfoVo){
        IPage<Loginfo> page = new Page<>(loginfoVo.getPage(),loginfoVo.getLimit());
        QueryWrapper<Loginfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank("loginfoVo.getLoginname()"),"loginname",loginfoVo.getLoginname());
        queryWrapper.like(StringUtils.isNotBlank("loginfoVo.getLoginip()"),"loginIp",loginfoVo.getLoginip());
        queryWrapper.ge(loginfoVo.getStartTime() != null ,"loginTime",loginfoVo.getStartTime());
        queryWrapper.ge(loginfoVo.getEndTime() != null ,"loginTime",loginfoVo.getEndTime());

        this.loginfoService.page(page ,queryWrapper);

        return new DataGridView(page.getTotal(),page.getRecords());
    }

}

package com.cuisf.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.cuisf.sys.common.Constast;
import com.cuisf.sys.common.DataGridView;
import com.cuisf.sys.common.ResultObj;
import com.cuisf.sys.entity.Loginfo;
import com.cuisf.sys.service.LoginfoService;
import com.cuisf.sys.vo.LoginfoVo;
import com.sun.xml.internal.ws.developer.Serialization;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Administrator on 2020-03-31.
 */
@RestController
@RequestMapping("/loginfo")
public class LoginfoController {

    @Autowired
    private LoginfoService loginfoService;


    /**
     * 加载所有的登录日志文件
     * @param loginfoVo
     * @return
     */
    @RequestMapping("/loadAllLoginfo")
    public DataGridView loadAllLoginfo(LoginfoVo loginfoVo){
        IPage<Loginfo> page = new Page<>(loginfoVo.getPage(),loginfoVo.getLimit());
        QueryWrapper<Loginfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(loginfoVo.getLoginname()),"loginname",loginfoVo.getLoginname());
        queryWrapper.like(StringUtils.isNotBlank(loginfoVo.getLoginip()),"loginIp",loginfoVo.getLoginip());
        queryWrapper.ge(loginfoVo.getStartTime() != null ,"loginTime",loginfoVo.getStartTime());
        queryWrapper.le(loginfoVo.getEndTime() != null ,"loginTime",loginfoVo.getEndTime());

        this.loginfoService.page(page ,queryWrapper);

        return new DataGridView(page.getTotal(),page.getRecords());
    }

    /**
     *
     * 删除登录日志
     * @param id
     * @return
     */
    @RequestMapping("deleteLoginfo")
    public ResultObj deleteLoginfo(Integer id){

        try {
            this.loginfoService.removeById(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }

    }
    /**
     *
     * 批量删除登录日志
     * @param
     * @return
     */
    @RequestMapping("batchDeleteLoginfo")
    public ResultObj batchDeleteLoginfo(LoginfoVo loginfoVo){

        try {
            Collection<Serializable> idList = new ArrayList<Serializable>();
            for (Integer id:loginfoVo.getIds()) {
                idList.add(id);
            }
            this.loginfoService.removeByIds(idList);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }

    }

}

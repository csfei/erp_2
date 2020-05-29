package com.cuisf.bus.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cuisf.bus.entity.Customer;
import com.cuisf.bus.entity.Provider;
import com.cuisf.bus.service.CustomerService;
import com.cuisf.bus.service.ProviderService;
import com.cuisf.bus.vo.CustomerVo;
import com.cuisf.bus.vo.ProviderVo;
import com.cuisf.sys.common.Constast;
import com.cuisf.sys.common.DataGridView;
import com.cuisf.sys.common.ResultObj;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by cuisf on 2020-05-25.
 */
@RestController
@RequestMapping("provider")
public class providerController {

    @Autowired
    private ProviderService providerService;

    /**
     * 加载所有的客户
     * @return
     */
    @RequestMapping("loadAllProvider")
    public DataGridView loadAllProvider(ProviderVo providerVo){
        IPage<Provider> page = new Page<>(providerVo.getPage(),providerVo.getLimit());
        QueryWrapper<Provider> queryWrapper = new QueryWrapper<>();

        queryWrapper.like(StringUtils.isNotBlank(providerVo.getProvidername()),"providername",providerVo.getProvidername());
        queryWrapper.like(StringUtils.isNotBlank(providerVo.getPhone()),"phone",providerVo.getPhone());
        queryWrapper.like(StringUtils.isNotBlank(providerVo.getConnectionperson()),"connectionpersion",providerVo.getConnectionperson());
        this.providerService.page(page,queryWrapper);
        return new DataGridView(page.getTotal(),page.getRecords());
    }

    /**
     * 添加客户
     * @param providerVo
     * @return
     */
    @RequestMapping("addProvider")
    public ResultObj addProvider(ProviderVo providerVo){
        try {
            this.providerService.save(providerVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 更新客户
     * @param providerVo
     * @return
     */
    @RequestMapping("updateProvider")
    public ResultObj updateProvider(ProviderVo providerVo){
        try {
            this.providerService.updateById(providerVo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    /**
     * 删除客户
     * @param id
     * @return
     */
    @RequestMapping("deleteProvider")
    public ResultObj deleteProvider(Integer  id){

        try {
            this.providerService.removeById(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 批量删除
     * @param providerVo
     * @return
     */
    @RequestMapping("batchDeleteProvider")
    public ResultObj batchDeleteProvider(ProviderVo providerVo){
        try {
            Collection<Serializable> idList = new ArrayList<>();
            for (Integer id:providerVo.getIds()) {
                idList.add(id);
            }
            this.providerService.removeByIds(idList);
            return ResultObj.DISPATCH_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DISPATCH_ERROR;
        }
    }

    /**
     * 加载所有可用的供应商
     */
    @RequestMapping("loadAllProviderForSelect")
    public DataGridView loadAllProviderForSelect() {
        QueryWrapper<Provider> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("available", Constast.AVALIABLE_TRUE);
        List<Provider> list = this.providerService.list(queryWrapper);
        return new DataGridView(list);
    }
}

package com.cuisf.bus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2020-05-25.
 */
@Controller
@RequestMapping("/bus")
public class BusinessController {

    /**
     *   跳转到客户管理界面
     * @return
     */
    @RequestMapping("toCustomerManager")
    public String toCustomerManager(){

        return "business/customer/customerManager";
    }
    /**
     *   跳转到供应商管理界面
     * @return
     */
    @RequestMapping("toProviderManager")
    public String toProviderManager(){

        return "business/provider/providerManager";
    }

    /**
     *   跳转到商品管理界面
     * @return
     */
    @RequestMapping("toGoodsManager")
    public String toGoodsManager(){

        return "business/goods/goodsManager";
    }
}

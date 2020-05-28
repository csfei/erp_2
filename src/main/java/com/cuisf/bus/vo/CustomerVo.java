package com.cuisf.bus.vo;

import com.cuisf.bus.entity.Customer;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * Created by Administrator on 2020-05-25.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CustomerVo extends Customer {


    private static final long serialVersionUID=1L;

    private Integer page = 1;
    private Integer limit = 10;
    private Integer[] ids;
}

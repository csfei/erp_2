package com.cuisf.bus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cuisf.bus.entity.Customer;
import com.cuisf.bus.mapper.CustomerMapper;
import com.cuisf.bus.service.CustomerService;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2020-05-25.
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper,Customer> implements CustomerService {
}

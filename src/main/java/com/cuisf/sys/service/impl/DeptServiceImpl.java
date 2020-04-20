package com.cuisf.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cuisf.sys.entity.Dept;
import com.cuisf.sys.mapper.DeptMapper;
import com.cuisf.sys.service.DeptService;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2020-04-20.
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {
}

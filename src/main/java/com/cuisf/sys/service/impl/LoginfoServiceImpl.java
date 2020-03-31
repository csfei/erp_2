package com.cuisf.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cuisf.sys.entity.Loginfo;
import com.cuisf.sys.mapper.LoginfoMapper;
import com.cuisf.sys.service.LoginfoService;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2020-03-31.
 */
@Service
public class LoginfoServiceImpl extends ServiceImpl<LoginfoMapper, Loginfo> implements LoginfoService {
}

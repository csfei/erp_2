package com.cuisf.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cuisf.sys.entity.User;
import com.cuisf.sys.mapper.UserMapper;
import com.cuisf.sys.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2020-03-23.
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}

package com.cuisf.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cuisf.sys.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cuisf
 * @since 2020-03-21
 */
public interface UserService extends IService<User> {

    /**
     * 保存用户和角色之间的关系
     * @param uid
     * @param ids
     */
    void saveUserRole(Integer uid, Integer[] ids);
}

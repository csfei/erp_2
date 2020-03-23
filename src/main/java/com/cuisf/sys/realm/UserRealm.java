package com.cuisf.sys.realm;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cuisf.sys.common.ActiverUser;
import com.cuisf.sys.entity.User;
import com.cuisf.sys.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2020-03-21.
 */
public class UserRealm extends AuthorizingRealm{

    @Autowired
    private UserService userService;

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    /**
     *认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token ) throws AuthenticationException {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("loginname",token.getPrincipal().toString());
        User sysUser = userService.getOne(queryWrapper);

        if (null != sysUser){
            ActiverUser activerUser = new ActiverUser();
            activerUser.setUser(sysUser);

            ByteSource credentialsSalt = ByteSource.Util.bytes(sysUser.getSalt());
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(activerUser, sysUser.getPwd(), credentialsSalt, this.getName());
            return info;
        }
        return null;
    }

    /**
     *  授权
     */
        @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
}

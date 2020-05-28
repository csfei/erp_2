package com.cuisf.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cuisf.sys.entity.Role;
import com.cuisf.sys.mapper.RoleMapper;
import com.cuisf.sys.service.RoleService;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2020-04-28.
 */

@Service
public class roleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {


    @Override
    public boolean removeById(Serializable id) {
        //根据角色ID删除sys_role_permission
        this.getBaseMapper().deleteRolePermissionByRid(id);
        //根据角色ID删除sys_role_user
        this.getBaseMapper().deleteRoleUserByRid(id);
        return super.removeById(id);
    }

    /**
     * 根据角色ID查询当前角色拥有的所有的权限或菜单ID
     */
    @Override
    public List<Integer> queryRolePermissionIdsByRid(Integer roleId) {
        return this.getBaseMapper().queryRolePermissionIdsByRid(roleId);
    }

    /**
     * 保存角色和菜单权限之间的关系
     */
    @Override
    public void saveRolePermission(Integer rid, Integer[] ids) {
        RoleMapper roleMapper = this.getBaseMapper();
        //根据rid删除sys_role_permission
        roleMapper.deleteRolePermissionByRid(rid);
        if (ids != null && ids.length > 0) {
            for (Integer pid : ids) {
                roleMapper.saveRolePermission(rid, pid);
            }
        }
    }

    /**
     * 查询当前用户拥有的角色ID集合
     */
    @Override
    public List<Integer> queryUserRoleIdsByUid(Integer id) {
        return this.getBaseMapper().queryUserRoleIdsByUid(id);
    }
}
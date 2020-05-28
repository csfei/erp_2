package com.cuisf.sys.vo;

import com.cuisf.sys.entity.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by Administrator on 2020-04-28.
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class RoleVo extends Role {
    /**
     *
     */
    private static final long serialVersionUID = 1L;


    private Integer page = 1;
    private Integer limit = 10;
}
package com.cuisf.sys.vo;

import com.cuisf.sys.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by Administrator on 2020-04-30.
 */

@Data
@EqualsAndHashCode(callSuper=false)
public class UserVo extends User {/**
 *
 */

private static final long serialVersionUID = 1L;


    private Integer page=1;
    private Integer limit=10;

}


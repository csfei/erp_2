package com.cuisf.sys.vo;

import com.cuisf.sys.entity.Dept;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by Administrator on 2020-04-20.
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class DeptVo extends Dept {/**
 *
 */
private static final long serialVersionUID = 1L;


    private Integer page=1;
    private Integer limit=10;

}

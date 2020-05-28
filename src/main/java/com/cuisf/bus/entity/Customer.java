package com.cuisf.bus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Created by cuisf on 2020-05-25.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)   //chain 一个布尔值。如果为真，产生的setter返回的this而不是void。默认是假。如果fluent=true，那么chain默认为真
@TableName("bus_customer")
@ToString
public class Customer implements Serializable{

    private static final long serialVersionUID=1L;

    @TableId(value ="id",type= IdType.AUTO)
    private  Integer id;

    private String customername;

    private String zip;

    private String address;

    private String telephone;

    private String connectionperson;

    private String phone;

    private String bank;

    private String account;

    private String email;

    private String fax;

    private Integer available;

}

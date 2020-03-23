package com.cuisf.sys.common;

import com.cuisf.sys.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * Created by Administrator on 2020-03-21.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActiverUser {

    private User user;

    private List<String> roles;

    private List<String> permissions;
}

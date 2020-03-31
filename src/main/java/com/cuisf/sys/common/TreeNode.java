package com.cuisf.sys.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;

/**
 * Created by Administrator on 2020-03-24.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeNode {

    private  Integer id;
    private  Integer pid;
    private String title;
    private String icon;
    private String  href;
    private Boolean spread;

    private List<TreeNode> children = new ArrayList<TreeNode>();


    public TreeNode(Integer id, Integer pid, String title, String icon, String href, Boolean spread) {
        this.id = id;
        this.pid = pid;
        this.title = title;
        this.icon = icon;
        this.href = href;
        this.spread = spread;
    }
}

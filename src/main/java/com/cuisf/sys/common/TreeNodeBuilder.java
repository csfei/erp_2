package com.cuisf.sys.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020-03-24.
 */
public class TreeNodeBuilder {

    /**
     * 把没有层级关系的集合形成存在层级关系的集合
     * @param treeNodes
     * @param topPid
     * @return
     */
    public  static List<TreeNode> build(List<TreeNode> treeNodes,Integer topPid){

        List<TreeNode> nodes = new ArrayList<>();
        for (TreeNode n1: treeNodes ) {
            if (n1.getPid() == topPid){
                nodes.add(n1);
            }
            for (TreeNode n2: treeNodes ){
                if(n1.getId() == n2.getPid()){
                        n1.getChildren().add(n2);
                }
            }
        }

        return nodes;
    }
}

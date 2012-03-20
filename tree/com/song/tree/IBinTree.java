package com.song.tree;

import com.song.node.BinTreeNode;
import com.song.node.INode;
import com.song.strategy.IStrategy;

/**
 * Created by IntelliJ IDEA.
 * User: song
 * Date: 12-3-20
 * Time: 下午4:54
 * To change this template use File | Settings | File Templates.
 */
public interface IBinTree {

    public void createTree(BinTreeNode root,IStrategy strategy);
    public void addNode(Object data);
    public BinTreeNode find(Object data);
    public void middleOrder(BinTreeNode root);

}

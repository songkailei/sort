package com.song.tree;

import com.song.node.BinTreeNode;
import com.song.node.INode;
import com.song.strategy.IStrategy;

/**
 * Created by IntelliJ IDEA.
 * User: song
 * Date: 12-3-20
 * Time: 下午5:06
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractBinTree implements IBinTree {
    public BinTreeNode root;
    public IStrategy strategy;

    public void createTree(BinTreeNode root,IStrategy strategy)
    {
        this.root = root;
        this.strategy = strategy;
    }

    public abstract void addNode(Object data);


    public abstract BinTreeNode find(Object obj);


    public abstract void middleOrder(BinTreeNode root);



}

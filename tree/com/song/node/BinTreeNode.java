package com.song.node;

/**
 * Created by IntelliJ IDEA.
 * User: song
 * Date: 12-3-20
 * Time: 下午4:44
 * To change this template use File | Settings | File Templates.
 * 二叉树节点
 */
public class BinTreeNode implements INode {

    public Object Data;       //数据域
    public BinTreeNode parent; //父节点
    public BinTreeNode lChild; //左子树
    public BinTreeNode rChild; //右子树


    public BinTreeNode(Object Data, BinTreeNode parent,BinTreeNode lChild,BinTreeNode rChild)
    {
        this.Data = Data;
        this.parent = parent;
        this.lChild = lChild;
        this.rChild = rChild;
    }
    /*
     实现INode接口
     */
    public Object getData() {
        return Data;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setData(Object obj) {
        this.Data = obj;
        //To change body of implemented methods use File | Settings | File Templates.
    }
}

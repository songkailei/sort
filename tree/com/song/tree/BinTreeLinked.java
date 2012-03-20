package com.song.tree;

import com.song.node.BinTreeNode;
import com.song.node.INode;

/**
 * Created by IntelliJ IDEA.
 * User: song
 * Date: 12-3-20
 * Time: 下午8:17
 * To change this template use File | Settings | File Templates.
 */
public class BinTreeLinked extends AbstractBinTree{

    @Override
    public void addNode(Object Data) {
        BinTreeNode nowNode = root;
        BinTreeNode newNode = null;
        do{
             newNode = nowNode;
             if(strategy.compare(nowNode.Data,Data)==1)
                 nowNode = nowNode.lChild;
             else if(strategy.compare(nowNode.Data,Data)==-1)
                 nowNode = nowNode.rChild;
        }while(nowNode != null);
        if(strategy.compare(newNode.Data,Data)==1)
            newNode.lChild = new BinTreeNode(Data,newNode,null,null);
        else if(strategy.compare(newNode.Data,Data)==-1)
            newNode.rChild =  new BinTreeNode(Data,newNode,null,null);
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public BinTreeNode find(Object obj) {
        BinTreeNode nowNode = root;
        if(strategy.equal(nowNode.Data,obj))
            return nowNode;
        else
        {
            while(nowNode!=null&&nowNode.Data!=obj)
            {
                if(strategy.compare(nowNode.Data, obj)==1)
                    nowNode = nowNode.lChild;
                else if(strategy.compare(nowNode.Data,obj)==-1)
                    nowNode = nowNode.rChild;
            }
        }
        return nowNode;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void middleOrder(BinTreeNode root) {
        if(root != null)
        {
            middleOrder(root.lChild);
            System.out.println(root.Data);
            middleOrder(root.rChild);
        }
        //To change body of implemented methods use File | Settings | File Templates.
    }
}

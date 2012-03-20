package com.song.tree;

import com.song.node.BinTreeNode;
import com.song.node.INode;
import com.song.strategy.DefaultStrategy;
import com.song.strategy.IStrategy;

/**
 * Created by IntelliJ IDEA.
 * User: song
 * Date: 12-3-20
 * Time: 下午8:53
 * To change this template use File | Settings | File Templates.
 */
public class BinTreeTest {
    public static void main(String args[])
    {
        BinTreeNode root = new BinTreeNode("a",null,null,null);
        IStrategy strategy = new DefaultStrategy();
        IBinTree binTree = new BinTreeLinked();
        binTree.createTree(root,strategy);
        binTree.addNode("b");
        binTree.addNode("c");
        binTree.addNode("g");
        binTree.addNode("y");
        binTree.addNode("r");
        binTree.addNode("e");
        binTree.addNode("d");
        binTree.addNode("f");
        binTree.middleOrder(root);
        BinTreeNode node = binTree.find("e");
        System.out.println(node.parent.Data);

    }
}

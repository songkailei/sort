package test;

/**
 * Created by IntelliJ IDEA.
 * User: song
 * Date: 11-8-3
 * Time: 上午9:59
 * 二叉排序树
 * To change this template use File | Settings | File Templates.
 */
public class OrderTree {
    public Node root;              //根节点放在外面
    public OrderTree(int data)
    {
        root = new Node(data,null,null,null);
    }
    public void addNode(int data)
    {
        Node nowNode = root;
        Node newNode = null;
        do{
            newNode = nowNode;
            if(nowNode.data>data)
                nowNode = nowNode.left;
            else nowNode = nowNode.right;
        }while (nowNode!=null);
        if(newNode.data>data)
            newNode.left = new Node(data,null,null,newNode);
        else newNode.right = new Node(data,null,null,newNode);
    }
    public void middleOrder(Node node)
    {
        if(node!=null)
        {
            middleOrder(node.left);
            System.out.println(node);
           // node.toString();
            middleOrder(node.right);
        }
    }
    public Node findNode(int data)
    {
        Node nowNode = root;
        if(nowNode.data==data)
            return nowNode;
        while((nowNode != null)&&(nowNode.data != data)){      //刚才一直在报错，是因为这两个条件写反了，导致nowNode为空时nowNode.data报错
        if(nowNode.data>data)
            nowNode = nowNode.left;
        else nowNode = nowNode.right;
        }
        return nowNode;
    }
    public void deleteNode(int data)
    {
        Node tagNode = findNode(data);
        if(tagNode==null)
            return;
        if(tagNode.left==null&&tagNode.right==null)
        {
            if(tagNode.parent.left==tagNode)
            {
                tagNode.parent.left=null;
            }
            if(tagNode.parent.right==tagNode)
            {
                tagNode.parent.right=null;
            }
            return ;
        }
        if(tagNode.left!=null && tagNode.right==null)
        {
            if(tagNode.parent.right == tagNode)
            {
                tagNode.parent.right = tagNode.left;
                //tagNode.left.parent = tagNode.parent;
            }
            if(tagNode.parent.left == tagNode)
            {
                tagNode.parent.left = tagNode.left;
            }
            tagNode.left.parent = tagNode.parent;
            return ;
        }
        if(tagNode.left == null && tagNode.right !=null)
        {
            if(tagNode.parent.right == tagNode)
            {
                tagNode.parent.right = tagNode.right;
            }
            if(tagNode.parent.left == tagNode)
            {
                tagNode.parent.left = tagNode.right;
            }
            tagNode.right.parent = tagNode.parent;
            return ;
        }
        if(tagNode.left != null && tagNode.right != null)
        {
            Node leftMaxNode = tagNode.left;
            while (leftMaxNode.right != null)
            {
                leftMaxNode = leftMaxNode.right;
            }
            if(leftMaxNode.left!=null)
            {
                leftMaxNode.parent.right = leftMaxNode.left;
                leftMaxNode.left.parent = leftMaxNode.parent;
            }
            else leftMaxNode.parent.right = null;

            leftMaxNode.parent = tagNode.parent;
            if(tagNode.parent.left == tagNode)
            {
                leftMaxNode.parent.left = leftMaxNode;
            }
            if(tagNode.parent.right == tagNode)
            {
                leftMaxNode.parent.right = leftMaxNode;
            }
            leftMaxNode.left = tagNode.left;
            leftMaxNode.right = tagNode.right;
            leftMaxNode.left.parent = leftMaxNode;
            leftMaxNode.right.parent = leftMaxNode;
            tagNode.left = null;
            tagNode.right = null;
            tagNode.parent = null;
        }
    }
    public static void main(String args[])
    {
        OrderTree ot = new OrderTree(7);
        ot.addNode(4);
        ot.addNode(1);
        ot.addNode(2);
        ot.addNode(5);
        ot.addNode(5);
        ot.addNode(13);
        ot.addNode(10);
        ot.addNode(12);
        ot.addNode(15);
        ot.addNode(14);
        ot.addNode(18);
        ot.middleOrder(ot.root);
        ot.deleteNode(1);
        ot.middleOrder(ot.root);
        //Node node = ot.findNode(16);
        //System.out.print(node);
        //System.out.print("parent: "+node.parent+" left: "+node.left+" right: "+node.right);
    }
}

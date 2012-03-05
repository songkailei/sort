package test;

/**
 * Created by IntelliJ IDEA.
 * User: song
 * Date: 11-8-3
 * Time: 上午9:51
 * To change this template use File | Settings | File Templates.
 */
public class Node {
    public int data;
    public Node left;
    public Node right;
    public Node parent;

    public Node(int data,Node left,Node right,Node parent)
    {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
    public String toString()
    {
        return "[data:"+this.data+"]";
    }
}

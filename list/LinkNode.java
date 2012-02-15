package com.java.list;

public class LinkNode<E> {
	
	public E data;
	public LinkNode<E> prevNode;
	public LinkNode<E> nextNode;
	
	
	public LinkNode(E data,LinkNode<E> prevNode,LinkNode<E> nextNode)
	{
		this.data = data;
		this.prevNode = prevNode;
		this.nextNode = nextNode;
	}
	

}

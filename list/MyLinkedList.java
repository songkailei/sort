package com.java.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList<E> implements List<E> {
	
	public int size;
	public LinkNode<E> headNode;
	public LinkNode<E> tailNode;
	
	public MyLinkedList()
	{
		headNode = null;
		tailNode = null;
	}

	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		if(size==0)
		{
			headNode = new LinkNode<E>(e,null,tailNode);
			size ++;
			//System.out.println(size);
			return true;
		}
		else
		{
			if(tailNode == null)
			{
				tailNode = new LinkNode<E>(e,headNode,null);
				size ++;
				return true;
			}
			else
			{
				LinkNode<E> linkNode = tailNode;
				tailNode.prevNode.nextNode = linkNode;
				//linkNode.
				tailNode = new LinkNode<E>(e,linkNode,null);
				linkNode.nextNode = tailNode;
				size ++;
				//System.out.println(tailNode.data+"");
				return true;
			}
		}
		
	}
	
	public LinkNode<E> findNodeByIndex(int index)
	{
		if(index==0)
		{
			return headNode;
		}
		else if(0<index&&index<size)
		{
			LinkNode<E> linkNode = headNode;
			while(index!=0)
			{
				linkNode = linkNode.nextNode;
				index--;
			}
			return linkNode;
		}
		else
			return null;
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		if(findNodeByIndex(index)!=null&&index>0&&index<size-1)
		{
			LinkNode<E> linkNode = findNodeByIndex(index);
			LinkNode<E> addNode = new LinkNode<E>(element,linkNode.prevNode,linkNode);
			linkNode.prevNode.nextNode = addNode;
			linkNode.prevNode = addNode;
			size++;
		}
		else if(index == 0)
		{
			LinkNode<E> linkNode = headNode;
			headNode = new LinkNode<E>(element,null,linkNode);
			linkNode.prevNode = headNode;
			size++;
		}
		else if(index == size-1)
		{
			add(element);
			//size++;
		}
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		LinkNode<E> linkNode = tailNode;
		while(size>1)
		{
			//linkNode.nextNode = null;
			linkNode.data = null;
			linkNode = linkNode.prevNode;
			linkNode.nextNode.prevNode = null;
			linkNode.nextNode = null;
			size--;
		}
		headNode = null;
		tailNode = null;
		size=0;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		LinkNode<E> linkNode = headNode;
		for(int i=0;i<size;i++)
		{
			if((Object)linkNode.data==o)
			{
				return true;
			}
			linkNode = linkNode.nextNode;
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return (E)(findNodeByIndex(index).data);
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		LinkNode<E> linkNode = headNode;
		for(int i=0;i<size;i++)
		{
			if((Object)linkNode.data==o)
			{
				return i;
			}
			linkNode = linkNode.nextNode;
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(size!=0)
		return false;
		else return true;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		LinkNode<E> linkNode = tailNode;
		for(int i=size-1;i>=0;i--)
		{
			if((Object)linkNode.data==o)
			{
				return i;
			}
			linkNode = linkNode.prevNode;
		}
		return -1;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean remove()
	{
		if (size > 2) {
			LinkNode<E> linkNode = tailNode;
			tailNode = tailNode.prevNode;
			tailNode.nextNode = null;
			tailNode.prevNode.nextNode = tailNode;
			linkNode.prevNode = null;
			linkNode.nextNode = null;
			linkNode = null;
			size--;
			return true;
		}
		else if(size==2)
		{
			System.out.println("-----------------");
			headNode.nextNode=null;
			tailNode.prevNode = null;
			tailNode = null;
			size--;
			return true;
		}
		else if(size==1)
		{
			headNode = null;
			tailNode = null;
			size--;
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		int index = indexOf(o);
		if(remove(index)!=null)
		return true;
		else return false;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		if(index==size-1)
		{
			if(size>1){
				E e = (E) tailNode.data;
				remove();
				return e;
			}
			else
			{
				E e = (E)headNode.data;
				remove();
				return e;
			}
		}
		else if((index<size-1)&&size>2)
		{
			
			LinkNode<E> linkNode = findNodeByIndex(index);
			E e = (E)linkNode.data;
			linkNode.prevNode.nextNode = linkNode.nextNode;
			linkNode.nextNode.prevNode = linkNode.prevNode;
			linkNode.data = null;
			linkNode.nextNode = null;
			linkNode.prevNode = null;
			size--;
			return e;
		}
		else if(size == 2)
		{
			//del headnode
			E e = (E)headNode.data;
			headNode = null;
			headNode.nextNode = null;
			headNode.data = null;
			headNode = tailNode;
			tailNode = null;
			headNode.prevNode =null;
			size --;
			return e;
		}
		return null;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String toString()
	{
		StringBuffer sb = new StringBuffer("[");
		LinkNode<E> linkNode = headNode;
		//System.out.println(tailNode.prevNode.data);
		while(linkNode!=null)
		{
			sb.append("["+linkNode.data+"],");
			linkNode = linkNode.nextNode;
		}
		return sb+"]";
	}
	
	public static void main(String args[])
	{
		MyLinkedList<String> list = new MyLinkedList<String>();
		list.add("song");
		list.add("kai");
		list.add("lei");
		list.add("ma");
		list.add("rui");
		System.out.println(list.size);
		System.out.println(list.toString());
		list.add(4, "angle");
		System.out.println(list.toString());
		System.out.println(list.contains("angle"));
		System.out.println(list.size);
		list.remove();
		System.out.println(list.toString());
		System.out.println(list.size);
		list.remove(2);
		System.out.println(list.toString());
		System.out.println(list.size);
		list.remove("kai");
		System.out.println(list.toString());
		System.out.println(list.size);
		System.out.println(list.remove(1));
		System.out.println(list.toString());
		System.out.println(list.size);
		list.clear();
	}

}

package com.java.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList<E> implements List<E>{

	public Object[] object;
	public int elementSize;
	
	public MyArrayList()
	{
		object = new Object[20];
	}
	
	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		add(elementSize,e);
		return false;
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		if(index == elementSize)
		{
			object[index] = element;
			elementSize ++;
		}
		else
		{
			int moveSize = elementSize - index - 1;
			System.arraycopy(object, index+1, object, index, moveSize);
			object[index] = element;
			elementSize ++;
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
		if(elementSize == 0)return;
		for(int i=0;i<elementSize;i++)
			object[i] = null;
		elementSize = 0;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		for(int i=0;i<elementSize;i++)
		{
			if(object[i] == o)
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		if(index < elementSize)
			return (E)object[index];
		else
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		for(int i=0;i<elementSize;i++)
		{
			if(object[i]==o)
				return i;
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(elementSize==0)
			return true;
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		for(int i=elementSize-1;i>=0;i--)
		{
			if(object[i]==o)
				return i;
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

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		//int moveSize = 0;
		for(int i=0;i<elementSize;i++)
		{
			if(object[i]==o)
			{
				object[i]=null;
				int moveSize = elementSize - i - 1;
				System.arraycopy(object, i+1, object, i, moveSize);
				elementSize --;
				return true;
			}
			
		}
		return false;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		if(index<elementSize)
		{
			Object o = object[index];
			object[index] = null;
			int moveSize = elementSize - index - 1;
			System.arraycopy(object, index+1, object, index, moveSize);
			elementSize --;
			return (E)o;
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
		return elementSize;
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
	
	public String toSting()
	{
		StringBuffer str = new StringBuffer("[");
		for(int i=0;i<elementSize;i++)
		{
			str.append("["+object[i].toString()+"],");
		}
		if(elementSize>0)
		{
			return str.substring(0,str.lastIndexOf(","))+"]";
		}
		return str+"]";
	}
	
	public static void main(String args[])
	{
		MyArrayList<String> myList = new MyArrayList<String>();
		myList.add("1");
		myList.add("2");
		myList.add("3");
		System.out.println(myList.toSting());
		myList.remove("3");
		System.out.println(myList.toSting());
		myList.add("3");
		System.out.println(myList.toSting());
		System.out.println(myList.contains("2"));
		System.out.println(myList.isEmpty());
		myList.clear();
		System.out.println(myList.toSting());
		System.out.println(myList.isEmpty());
	}

}

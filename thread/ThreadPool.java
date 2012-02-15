package com.song.thread;

import java.util.ArrayList;

public class ThreadPool {
	
	public ArrayList<String> clientQueue  = new ArrayList<String>();
	
	public ThreadPool()
	{
		for(int i=0;i<10;i++)
		{
			clientQueue.add(i+"");
		}
		System.out.println("init....");
	}
	
	public synchronized String getClient(int id)
	{
			try {
				while(clientQueue.size()==0)
				{
					System.out.println("task "+id+" waiting for client...");
					wait();
				}
					//wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return clientQueue.remove(0);
	}
	
	public synchronized void addClient(String client)
	{
		try {
			while(clientQueue.size()>=10)
			{
				System.out.println("the client queue is full...");
				wait();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clientQueue.add(client);
		System.out.println("put client into queue....");
		notifyAll();
	}
	
	
	public static void main(String args[])
	{
		ThreadPool tp = new ThreadPool();
		//String client = "new";
		//tp.addClient(client);
		//ArrayList<TaskThread> taskQueue = new ArrayList<TaskThread>();
		for(int i=10;i<500;i=i+10)
		{
			new TaskThread(i,tp).start();
			//taskQueue.add(task);
		}
	}

}

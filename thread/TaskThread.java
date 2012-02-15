package com.song.thread;

public class TaskThread extends Thread{
	
	public int id;
	public String client;
	public ThreadPool tp;
	
	public TaskThread(int id,ThreadPool tp)
	{
		this.id = id;
		//this.client = client;
		this.tp = tp;
	}
	
	public void run()
	{
		System.out.println("start task "+this.id);
		try {
			client = tp.getClient(this.id);
			sleep(this.id);
			System.out.println("client "+client);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tp.addClient(client);
		System.out.println("task "+this.id+"is over...");
	}
}

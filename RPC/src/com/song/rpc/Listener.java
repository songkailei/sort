package com.song.rpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.song.protocol.Invocation;

public class Listener extends Thread {
	
	public ServerSocket socket;
	public Server server;
	
	public Listener(Server server)
	{
		this.server = server;
	}
	
	public void run()
	{
		System.out.println("server@"+server.getport());
		try {
			socket = new ServerSocket(server.getport());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(server.isRunning())
		{
			try{
				Socket client = socket.accept();
				ObjectInputStream obis = new ObjectInputStream(client.getInputStream());
				Invocation invo = (Invocation)obis.readObject();
				server.call(invo);
				ObjectOutputStream obos = new ObjectOutputStream(client.getOutputStream());
				obos.writeObject(invo);
				obos.flush();
				obos.close();
				obis.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		try{
			if(!socket.isClosed()&&socket!=null)
				socket.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}

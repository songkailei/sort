package com.song.rpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.net.Socket;
import java.net.UnknownHostException;
import java.lang.reflect.Method;

import com.song.protocol.Invocation;

public class Client {
	
	public String host;
	public int port;
	public Socket socket;
	public ObjectOutputStream obos;
	public ObjectInputStream obis;
	
	public String getHost() {
		return host;
	}
	
	public void setHost(String host) {
		this.host = host;
	}
	
	public int getPort() {
		return port;
	}
	
	public void setPort(int port) {
		this.port = port;
	}
	
	public Client(String host,int port)
	{
		this.host = host;
		this.port = port;
	}
	
	public void init() throws UnknownHostException, IOException
	{
		socket = new Socket(host,port);
		obos = new ObjectOutputStream(socket.getOutputStream());
	}
	
	public void invoke(Invocation invo) throws UnknownHostException, IOException, ClassNotFoundException {
		init();
		//System.out.println("写入数据");
		obos.writeObject(invo);
		obos.flush();
		obis = new ObjectInputStream(socket.getInputStream());
		
		Invocation result = (Invocation) obis.readObject();
		
		invo.setResult(result.getResult());
	}
	
     public static <T> T getProxy(final Class<T> clazz,String host,int port) {
		
		final Client client = new Client(host,port);
		InvocationHandler handler = new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				Invocation invo = new Invocation();
				invo.setInterfaces(clazz);
				invo.setMethod(new com.song.protocol.Method(method.getName(),method.getParameterTypes()));
				invo.setParams(args);
				client.invoke(invo);
				return invo.getResult();
			}
		};
		//动态创建接口的实现类
		T t = (T) Proxy.newProxyInstance(Client.class.getClassLoader(), new Class[] {clazz}, handler);
		return t;
	}

}

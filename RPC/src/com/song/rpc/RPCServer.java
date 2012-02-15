package com.song.rpc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.song.protocol.Invocation;

public class RPCServer implements Server {

	public int port = 50070;
	public Listener listen;
	public boolean isRunning = true;
	public Map<String,Object> interfaceMap = new HashMap<String,Object>();
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("rpcserver@"+this.port);
		listen = new Listener(this);
		listen.start();
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		this.isRunning = false;
	}

	@Override
	public void register(Class interfaceDefiner, Class impl) {
		// TODO Auto-generated method stub
		try {
			this.interfaceMap.put(interfaceDefiner.getName(), impl.newInstance());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void call(Invocation invo) {
		// TODO Auto-generated method stub
		Object obj = interfaceMap.get(invo.getInterfaces().getName());
		if(obj!=null)
		{
			try {
				//动态生成实现类方法
				Method m = obj.getClass().getMethod(invo.getMethod().getMethodName(), invo.getMethod().getParams());
				Object result = m.invoke(obj, invo.getParams());
				invo.setResult(result);
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	@Override
	public boolean isRunning() {
		// TODO Auto-generated method stub
		return isRunning;
	}

	@Override
	public int getport() {
		// TODO Auto-generated method stub
		return port;
	}

}

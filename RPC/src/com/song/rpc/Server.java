package com.song.rpc;

import com.song.protocol.Invocation;

public interface Server {
	
	public void start();
	public void stop();
	public void register(Class interfaceDefiner,Class impl);
	public void call(Invocation invo);
	public boolean isRunning();
	public int getport();

}

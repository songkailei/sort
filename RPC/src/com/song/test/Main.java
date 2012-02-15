package com.song.test;

import com.song.impl.*;
import com.song.rpc.RPCServer;
import com.song.rpc.Server;



public class Main {
	public static void main(String[] args) {
		Server server = new RPCServer();
		server.register(ReadFile.class, RomoteReadFile.class);
		server.start();
	}

}

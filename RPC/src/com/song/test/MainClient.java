package com.song.test;

import com.song.impl.*;
import com.song.rpc.Client;

public class MainClient {
	public static void main(String[] args) {
		ReadFile rf = Client.getProxy(ReadFile.class, "202.117.16.32", 50070);
		System.out.println(rf.readFile("D:\\twitter.txt"));
	}
}

package com.song.test;

import com.song.impl.ReadFile;
import com.song.impl.RomoteReadFile;

public class ReadFileTest {
	
	public static void main(String args[])
	{
		ReadFile rf = new RomoteReadFile();
		System.out.println(rf.readFile("D:\\twitter.txt"));
	}

}

package com.song.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class RomoteReadFile implements ReadFile {

	@Override
	public String readFile(String path) {
		// TODO Auto-generated method stub
		File f = new File(path);
		StringBuffer sb = new StringBuffer();
		String line;
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			//line = br.readLine();
			while((line = br.readLine()) != null)
			{
				sb.append(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}

}

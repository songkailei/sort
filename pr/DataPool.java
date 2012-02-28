package com.song.test;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: song
 * Date: 12-2-28
 * Time: 下午3:41
 * To change this template use File | Settings | File Templates.
 */
public class DataPool {

    public ArrayList<String> list;

    public DataPool()
    {
       System.out.println("init...");
       list = new ArrayList<String>();
    }

    public synchronized String getData()
    {
        try{
             while(list.size()==0)
              {
                System.out.println("wait for data...");
                wait();
              }
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        String str = list.remove(0);
        notifyAll();
        return str;
    }

    public synchronized void putData(String data)
    {
        try{
             while(list.size()>=10)
             {
                 System.out.println("pool is full...");
                 wait();
             }
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        list.add(data);
        System.out.println("add data to pool...");
        notifyAll();
    }

    public static void main(String args[])
    {
        DataPool dataPool = new DataPool();
        new PutData(dataPool).start();
        new GetData(dataPool).start();
    }

}

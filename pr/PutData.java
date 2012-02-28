package com.song.test;

/**
 * Created by IntelliJ IDEA.
 * User: song
 * Date: 12-2-28
 * Time: 下午4:08
 * To change this template use File | Settings | File Templates.
 */
public class PutData extends Thread{

    public DataPool dataPool;

    public PutData(DataPool dataPool)
    {
        this.dataPool = dataPool;
    }

    public void run()
    {
        System.out.println("PutData is running...");
        try{
             for(int i=0;i<100;i++)
              {
                  dataPool.putData(i+"");
                  sleep(10);
                  System.out.println(i+" is put...");
              }
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}

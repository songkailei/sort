package com.song.test;

/**
 * Created by IntelliJ IDEA.
 * User: song
 * Date: 12-2-28
 * Time: 下午3:55
 * To change this template use File | Settings | File Templates.
 */
public class GetData extends Thread{

    public String data;
    public DataPool dataPool;

    public GetData(DataPool dataPool)
    {
        this.dataPool = dataPool;
    }

    public void run()
    {
        System.out.println("GetData is running...");
        try{
            while (true){
            data = dataPool.getData();
            sleep(10);
            System.out.println("get data:"+data);
            }
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}

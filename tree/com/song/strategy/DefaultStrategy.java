package com.song.strategy;

/**
 * Created by IntelliJ IDEA.
 * User: song
 * Date: 12-3-20
 * Time: 下午4:33
 * To change this template use File | Settings | File Templates.
 */
public class DefaultStrategy implements IStrategy {
    public boolean equal(Object obj1, Object obj2) {
        boolean tmp = obj1.toString().equals(obj2.toString());
        return tmp;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int compare(Object obj1, Object obj2) {
        int tmp = obj1.toString().compareTo(obj2.toString());
        if(tmp == 0)return 0;
        else if(tmp > 0)return 1;
        else return -1;
    }
}

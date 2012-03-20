package com.song.strategy;

/**
 * Created by IntelliJ IDEA.
 * User: song
 * Date: 12-3-20
 * Time: 下午4:26
 * To change this template use File | Settings | File Templates.
 * 比较策略
 */
public interface IStrategy {

    public boolean equal(Object obj1, Object obj2);

    /*
      比较两个对象的大小
      if obj1 > obj2 return 1;
      if obj1 = obj2 return 0;
      if obj1 < obj2 return -1;
     */
    public int compare(Object obj1, Object obj2);
}

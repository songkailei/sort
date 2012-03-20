package com.song.test;

import sun.nio.ch.Interruptible;

/**
 * Created by IntelliJ IDEA.
 * User: song
 * Date: 12-3-20
 * Time: 上午10:29
 * To change this template use File | Settings | File Templates.
 * 使用分治法同时得到数组中的最大和最小值，分治法具体如下：
 * 可以把数组分成两部分a1和a2，在a1和a2中分别找到最大和最小值，然后比较这两个值即可得到结果，为了
 * 得到a1和a2的最大和最小值，可以重复上述过程将这两个数组再次分解，如此直到分解的子数组中只有两个
 * 元素时经过一次比较就可以得到结果。o(n)=3n/2
 */
public class Min_Max {
    public IntPair min_max(int a[],int low,int height)
    {
        IntPair pair = new IntPair();
        if(low>height-2)
        {
            if(a[low]>a[height])
            {
                pair.x = a[low];   //max
                pair.y = a[height];//min
            }
            else
            {
                pair.x = a[height];
                pair.y = a[low];
            }
        }
        else
        {
            int mid = (low+height)/2;
            IntPair p1 = min_max(a,low,mid);
            IntPair p2 = min_max(a,mid+1,height);
            pair.x = p1.x>p2.x?p1.x:p2.x;
            pair.y = p1.y<p2.y?p1.y:p2.y;
        }
        return pair;
    }
    public  static void main(String args[])
    {
        IntPair intPair = new IntPair();
        int a[] = {4,2,6,7,11,3,8,21,16,9,52};
        Min_Max mm = new Min_Max();
        intPair = mm.min_max(a,0,a.length-1);
        System.out.println("max:"+intPair.x+"  min:"+intPair.y);
    }
}

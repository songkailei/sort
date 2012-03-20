/*
*
*问题描述：同时找出数组中的最大值和最小值，要求比较次数为3n/2
*分析：通过n-1次比较可以找到最大值或者最小值，但是同时找到则需2n-2次，与题目不符，另外一思路：成对处理元素，先将一对输入元素相互比较，然后把较大的值与当前最大值比较，较小值与当前最小值比较。
*by song
*2011-10-24
*/
#include <iostream>
#include <stdio.h>
using namespace std;



int M_mmain()
{
	int min,max;
	int a[] = {1,4,5,2,7,9,10,3,6,8};
	int len = sizeof(a)/sizeof(a[0]);
	if(len%2!=0)
	{
		min = a[0];
		max = a[0];
	}
	else
	{
		if(a[0]>a[1])
		{
			max = a[0];
			min = a[1];
		}
		else
		{
			max = a[1];
			min = a[0];
		}
	}
	for(int i=1;i<len-1;i=i+2)
	{
		if(a[i]>a[i+1])
		{
			if(a[i]>max)
				max = a[i];
			if(a[i+1]<min)
				min = a[i+1];
		}
		else
		{
			if(a[i+1]>max)
				max = a[i+1];
			if(a[i]<min)
				min = a[i];
		}
	}
	cout<<"max is:"<<max<<" min is:"<<min<<endl;
	getchar();
	return 0;
}
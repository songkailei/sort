/*
*
*����������ͬʱ�ҳ������е����ֵ����Сֵ��Ҫ��Ƚϴ���Ϊ3n/2
*������ͨ��n-1�αȽϿ����ҵ����ֵ������Сֵ������ͬʱ�ҵ�����2n-2�Σ�����Ŀ����������һ˼·���ɶԴ���Ԫ�أ��Ƚ�һ������Ԫ���໥�Ƚϣ�Ȼ��ѽϴ��ֵ�뵱ǰ���ֵ�Ƚϣ���Сֵ�뵱ǰ��Сֵ�Ƚϡ�
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
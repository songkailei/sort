/*
*题目：输入一个已经按升序排序过的数组和一个数字sum，在数组中查找两个数，使得它们 的和正好是输入的
*/
#include <iostream>
#include <stdio.h>
using namespace std;

void add(int a[],int sum,int len)
{
	int i = 0;
	int j = len-1;
	while(i<j)
	{
		if(a[i]+a[j]>sum)
			j --;
		else if(a[i]+a[j]<sum)
			i ++;
		else
		{
			cout<<a[i]<<"+"<<a[j]<<"="<<sum<<endl;
			break;
		}
			
	}
	if(j<=i)
		cout<<"no"<<endl;
}

int A_main()
{
	int a[8] = {1,3,4,6,7,8,12,15};
	add(a,100,8);
	getchar();
	return 0;
}
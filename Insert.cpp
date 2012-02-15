#include <iostream>
#include <stdio.h>
using namespace std;

void change(int a[])
{
  a[5]=100;
}
int I_main()
{
	int a[6] ={5,2,4,6,1,3};
	int length = sizeof(a)/sizeof(a[0]);
	//std::cout<<sizeof(a)<<std::endl;
	for(int j=1;j<length;j++)
	{
	    int key = a[j];
		int i = j-1;
		while(i>=0&&a[i]>key)
		{
		   a[i+1] = a[i];
		   i --;
		}
		a[i+1] = key;
	}
	for(int i=0;i<length;i++)
	{
	   cout<<a[i]<<endl;
	}
	change(a);
	for(int i=0;i<length;i++)
	{
	   cout<<a[i]<<endl;
	}
	//std::cout<<"htll"<<std::endl;
	getchar();
	return 1;
}
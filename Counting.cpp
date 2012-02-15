#include <iostream>
#include <stdio.h>
using namespace std;

void counting_sort(int a[],int b[],int len,int k)
{
	int *c = new int[k+1];
	for(int i=0;i<k+1;i++)
	{
		c[i] = 0;
	}
	for(int j=0;j<len;j++)
	{
		c[a[j]]=c[a[j]]+1;
	}
	
	for(int i=1;i<k+1;i++)
	{
		c[i]=c[i]+c[i-1];
		//cout<<c[a[i]]<<endl;
	}
	for(int j =len-1;j>=0;j--)
	{
		b[c[a[j]]-1]= a[j];
		c[a[j]] = c[a[j]]-1;
	}
}

int C_main()
{
	int a[8] = {2,5,3,0,2,3,0,3};
	int b[8];
	counting_sort(a,b,8,5);
	for(int i=0;i<8;i++)
		cout<<b[i]<<endl;
	getchar();
	return 0;
}
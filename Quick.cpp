#include <iostream>
#include <stdio.h>
using namespace std;

int partition(int a[],int p,int r)
{
	int x = a[r];
	int i = p - 1;
	for(int j = p;j<r;j++)
	{
		if(a[j]<=x)
		{
			i ++;
			int tmp = a[i];
			a[i] = a[j];
			a[j] = tmp;
		}
	}
	int tmp = a[r];
	a[r] = a[i+1];
	a[i+1] = tmp;
	return i+1;
}

void quicksort(int a[],int p,int r)
{
	if(p<r)
	{
		int q = partition(a,p,r);
		//cout<<q<<endl;
		quicksort(a,p,q-1);
		quicksort(a,q+1,r);
	}
}

int Q_main()
{
	int a[8] = {2,8,7,1,3,5,6,4};
	quicksort(a,0,7);
	for(int i=0;i<8;i++)
	   cout<<a[i]<<endl;
	getchar();
	return 0;
}
#include <iostream>
#include <stdio.h>
using namespace std;
int a[10] = {4,1,3,2,16,9,10,14,8,7};
int len = sizeof(a)/sizeof(a[0]);
int heapsize = len;

void show()
{
	for(int i=0;i<len;i++)
		cout<<"##"<<a[i]<<endl;
}
int left(int i)
{
	return 2*i+1;
}
int right(int i)
{
    return 2*i+2;
}

void max_heapify(int i)
{
	int largest;
    int l = left(i);
    int r = right(i);
    if(l<heapsize&&a[l]>a[i])
    {
      largest = l;    
    }
	else
	{
		largest = i;
	}
	if(r<heapsize&&a[r]>a[largest])
	{
		largest = r;
	}
	if(largest!=i)
	{
		int tmp = a[i];
		a[i] = a[largest];
		a[largest] = tmp;
		max_heapify(largest);
	}
}
void build_max_heap()
{
	for(int i =(len/2-1);i>=0;i--)
	{
		max_heapify(i);
	}
}
void heapsort()
{
	build_max_heap();
	for(int i=(len-1);i>=1;i--)
	{
		int tmp = a[0];
		a[0] = a[i];
		a[i] = tmp;
		heapsize--;
		max_heapify(0);
	}
}
int H_main()
{
	
    heapsort();
	//cout<<"len:"<<len<<endl;
	show();
	//show(a,len);
    getchar();
    return 0;
}
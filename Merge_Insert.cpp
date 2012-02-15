/*
*���ܺϲ�������������ʱ��Ϊnlgn�������������������ʱ��Ϊn2�����ڲ��������еĳ�������ʹ������n�Ƚ�Сʱ�����е�Ҫ����Щ��
*��ˣ��ںϲ������㷨�У����������㹻Сʱ�����ò�������ͱȽϺ����ˡ����⣬��ϸ�۲�ϲ��㷨��֪�����Ƿֵ����ֻʣ������Ԫ���ںϲ��������ϲ��ĺ������ƺ���Щ�˷��ˣ�
*���ϣ����ǶԺϲ������������޸ģ������ò���������Զ�n/k������Ϊk�����б��������Ȼ�����ñ�׼�ĺϲ����ƽ����Ǻϲ���������֤�����������˷���������ʱ��Ϊnk+nlgn/k��
*��������(���Ӧ������ԭ���˰�)��
*/
#include <iostream>
#include <stdio.h>
using namespace std;

void insert(int a[],int s,int t)
{
	for(int j=s+1;j<=t;j++)
	{
	    int key = a[j];
		int i = j-1;
		while(i>=s&&a[i]>key)
		{
		   a[i+1] = a[i];
		   i --;
		}
		a[i+1] = key;
	}
}
void merge(int a[],int p,int q,int r)
{
  int n1 = q-p+1;
  int n2 = r-q;
  int *l = new int[n1+1];
  int *t = new int[n2+1];
  for(int i=0;i<n1;i++)
  {
     l[i] = a[p+i];
  }
  for(int j=0;j<n2;j++)
  {
     t[j] = a[q+j+1];
  }
  l[n1] = 1000000;
  t[n2] = 1000000;
  int i = 0;
  int j = 0;
  for(int k=p;k<=r;k++)
  {
	  //cout<<"###"<<k<<endl;
     if(l[i]<=t[j])
	 {
	    a[k]=l[i];
		i++;
	 }
	 else
	 {
	    a[k]=t[j];
		j++;
	 }
  }
}
void merge_sort(int a[],int p,int r)
{
   if((r-p)>8)
   {
       int q = (p+r)/2;
	   merge_sort(a,p,q);
	   merge_sort(a,q+1,r);
	   merge(a,p,q,r);
   }
   else
   {
	   int q = (p+r)/2;
	   cout<<"##"<<q<<"##"<<p<<"##"<<r<<endl;
	   insert(a,p,q);
	   insert(a,q+1,r);
	   merge(a,p,q,r);
   }
}
int M_main()
{
	int a[16] = {5,2,4,7,1,3,2,6,9,8,11,14,12,10,9,4};
	merge_sort(a,0,15);
	for(int i=0;i<16;i++)
		cout<<a[i]<<endl;
	getchar();
	return 0;
}
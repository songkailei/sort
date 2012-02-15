/*
*尽管合并排序最坏情况运行时间为nlgn，插入排序的最坏情况运行时间为n2，但在插入排序中的常数因子使得它在n比较小时，运行得要更快些。
*因此，在合并排序算法中，当子问题足够小时，采用插入排序就比较合适了。另外，仔细观察合并算法可知，他是分到最后只剩下两个元素在合并，这样合并的函数就似乎有些浪费了，
*综上，考虑对合并排序做以下修改，即采用插入排序策略对n/k个长度为k的子列表进行排序，然后再用标准的合并机制将他们合并起来，经证明（？？）此方法的最坏情况时间为nk+nlgn/k，
*程序如下(这个应该算是原创了吧)：
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
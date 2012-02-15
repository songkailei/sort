#include <iostream>
#include <stdio.h>
using namespace std;

void show(int a[],int len)
{
for(int i=0;i<len;i++)
cout<<a[i]<<endl;
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
//cout<<¡±###¡±<<k<<endl;
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
if(p<r)
{
int q = (p+r)/2;
merge_sort(a,p,q);
merge_sort(a,q+1,r);
merge(a,p,q,r);
}
}
int main()
{
int a[8] = {5,2,4,7,1,3,2,6};
merge_sort(a,0,7);
show(a,8);
getchar();
return 0;
}
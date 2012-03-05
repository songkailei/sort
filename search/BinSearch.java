package com.java.search;

public class BinSearch {
	
   public static int binSearch(int a[],int result)
   {
	   int find = 0;
	   int low = 1;
	   int high = a.length;
	   while((low<=high)&&(find==0))
	   {
		   int mid = (low+high)/2;
		   if(a[mid-1]==result)
			   find = 1;
		   else if(a[mid-1]<result)
		   {
			   low = mid + 1;
		   }
		   else if(a[mid-1]>result)
		   {
			   high = mid - 1;
		   }
	   }
	   return find;
   }
   
   //Recursive
   public static int binSearch2(int a[],int low,int high,int result)
   {
	   //int find = 0;
	   if(low<=high)
	   {
		   int mid = (low+high)/2;
		   if(a[mid-1]==result)
		   {
			   return 1;
		   }
		   else if(a[mid-1]<result)
		   {
			   return binSearch2(a,mid+1,high,result);
		   }
		   else
		   {
			   return binSearch2(a,low,mid-1,result);
		   }
	   }
	   else
	   {
		   return 0;
	   }
		   
	  // return 0;
   }
   
   public static void main(String args[])
   {
	   int a[] = {1,3,6,8,10,14,18,20,23,24,27,31,33,35};
	   int result = BinSearch.binSearch(a, 22);
	   if(result==0)
		   System.out.println("can't find....");
	   else
		   System.out.println("find it....");
	   
	   
	   int result2 = BinSearch.binSearch2(a,0,a.length, 23);
	   if(result2==0)
		   System.out.println("can't find....");
	   else
		   System.out.println("find it....");
   }

}

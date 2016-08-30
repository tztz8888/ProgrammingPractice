package src;


public class FindMedianSortedArrays {
         public void Test()
         {
             int nums1[]={1,2,4};
             int nums2[]={3,5};
             System.out.println(findMedianSortedArrays(nums1,nums2));
           
         }
	 public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		 //reduce to 2 and 2 array, half and half divide
		 int h1=0,t1=nums1.length-1;
                 int h2=0,t2=nums2.length-1;
                 int m1=(h1+t1)/2, m2= (h2+t2)/2;
                 while(true)
                 {
                    if(h1==t1-1 && h2==t2-1)
                        break;
                    m1= (h1+t1)/2;
                    m2= (h2+t2)/2;
                    if(nums1[m1]<nums2[m2]){
                        h1= m1;
                        t2= m2;
                    }
                    else
                    {
                        t1=m1;
                        h1=m2;
                    }
                 }
                 
                 int arr1[]=new int[2];
                 int arr2[]=new int[2];
                 arr1[0]= nums1[h1];
                 arr2[0]= nums2[h1];
                 arr1[1]= nums1[t1];
                 arr2[2]= nums2[t2];
                 
		 return findMedianOfFourNumbers(arr1,arr2,nums1.length,nums2.length);
	 }
	 
	 public double findMedianOfFourNumbers(int []arr1,int []arr2,int m,int n)
	 {
		int first,second;
		if(arr1[0]>arr2[0])
			first= arr1[0];
		else
			first= arr2[0];
		
		if(arr1[1]>arr2[1])
			second=arr2[1];
		else
			second=arr1[1];
		
		if( (m+n)%2==0 ) { //even
			return ((double)first + (double)(second))/2;
		}
		else	//odd
		{
			if(first>second)
				return (double)first;
			else
				return (double)second;
		}
			
	 }
	 
}

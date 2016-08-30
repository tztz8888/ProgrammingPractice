
public class FindMedianSortedArrays {
	 public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		 //reduce to 2 and 2 array, half and half divide
		 
		 return 0;
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

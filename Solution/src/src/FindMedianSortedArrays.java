package src;


public class FindMedianSortedArrays {
         public void test()
         {
             int nums1[]={1};
             int nums2[]={2,3,4};
             System.out.println(findMedianSortedArrays(nums1,nums2));
           
         }
	 public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		 //reduce to 2 and 2 array, half and half divide
                 int m= nums1.length;
                 int n= nums2.length;
		 int h1=0,t1=m-1;
                 int h2=0,t2=n-1;
                 int m1=(h1+t1)/2, m2= (h2+t2)/2;
                 boolean isEven;
                 if((m+n)%2==0)
                     isEven= true;
                 else
                     isEven= false;
                 
                 //sepcial case: one array is empty
                 if(nums1.length==0 && nums2.length==0)
                     return 0.0;
                 else if(nums1.length==0 && nums2.length!=0)
                     return findMedian(nums2);
                 else if(nums1.length!=0 && nums2.length==0)
                     return findMedian(nums1);
                 
                 //for even case
                 if(isEven){
                    while(true)
                    {
                       if(h1>=t1-1 && h2>=t2-1)//if already 2X2, break
                           break;
                       m1= (h1+t1)/2;
                       m2= (h2+t2)/2;
                       if(nums1[m1]<nums2[m2]){ //right side of m1, left side of m2
                               h1= m1;
                               t2= m2;
                       }
                       else if(nums1[m1]>nums2[m2]){//right side of m2, left side of m1
                               t1=m1;
                               h2=m2;
                       }
                       else //equals
                       {
                           if(nums1.length%2==0 && nums2.length%2==0) //all Even
                           {
                               h1= m1;
                               t1= m1+1;
                               h2= m2;
                               t2= m2+1;
                               break;
                           }
                           else if(nums1.length%2==1 && nums2.length%2==1)// all Odd
                           {
                               return nums1[m1];
                           }
                       }
                      System.out.println("h1:"+h1+" t1:"+t1+ " h2:"+h2+" t2:"+t2);
                    }
                    
                    if(h1==t1){
                        if(h1+h2 < m-1-t1+ n-1-t2)
                            return findMedianThreeEven(nums1[h1],nums2[h2],nums2[t2],false);
                        else
                            return findMedianThreeEven(nums1[h1],nums2[h2],nums2[t2],true);
                    }
                    else if(h2==t2){
                        if(h1+h2 < m-1-t1+ n-1-t2)
                            return findMedianThreeEven(nums1[h1],nums2[h2],nums2[t2],false);
                        else
                            return findMedianThreeEven(nums1[h1],nums2[h2],nums2[t2],true);
                    }
                    else{
                        int arr1[]=new int[2];
                        int arr2[]=new int[2];
                        arr1[0]= nums1[h1];
                        arr2[0]= nums2[h2];
                        arr1[1]= nums1[t1];
                        arr2[1]= nums2[t2];

                        System.out.println(arr1[0]+" "+arr1[1]+" "+arr2[0]+" "+arr2[1]);
                        return findMedianOfFourNumbersEven(arr1,arr2);
                    }
                 }
                 else // Odd
                 {
                     while(true)
                    {
                       if(h1>=t1-1 && h2>=t2-1)//if already 2X2 or 2X1, break
                           break;
                       m1= (h1+t1)/2;
                       m2= (h2+t2)/2;
                       if(nums1[m1]<nums2[m2]){ //right side of m1, left side of m2
                               h1= m1;
                               t2= m2;
                       }
                       else{//right side of m2, left side of m1
                               t1=m1;
                               h2=m2;
                       }
                      System.out.println("h1:"+h1+" t1:"+t1+ " h2:"+h2+" t2:"+t2);
                    }
                 }
                 
                 if(h1==t1){
                     return findMedianThree(nums1[h1],nums2[h2],nums2[t2]);
                 }
                 else if(h2==t2){
                     return findMedianThree(nums1[h1],nums1[t1],nums2[t2]);
                 }
                 else {
                    int arr1[]=new int[2];
                    int arr2[]=new int[2];
                    arr1[0]= nums1[h1];
                    arr2[0]= nums2[h2];
                    arr1[1]= nums1[t1];
                    arr2[1]= nums2[t2];
                    if(h1+h2 < m-1-t1+ n-1-t2)  //left side less than right side
                        return findMedianOfFourNumbersOdd(arr1,arr2,false); //get the larger one
                    else
                        return findMedianOfFourNumbersOdd(arr1,arr2,true);  // get the smaller one
                 }
                   
	 }
         
	 public double findMedian(int []arr)
         {
             int n= arr.length;
             if(n%2==0)
                 return ((double)arr[n/2-1] + (double)arr[n/2] )/2;
             else
                 return (double)arr[(n-1)/2];
         }
         
         public double findMedianThree(int a,int b,int c)
         {
             if(a<=b)
             {
                 if(c<=a)
                     return a;
                 else if( c>=b )
                     return b;
                 else
                     return c;
             }
             else
             {
                 if(c>=a)
                     return a;
                 else if(c<=b)
                     return b;
                 else
                     return c;
             }
         }
         
          public double findMedianThreeEven(int a,int b,int c,boolean isSmaller)
          {
              int x=0,y=0;
              System.out.println(a+" "+b+" "+c);
              if(!isSmaller)
              {
                  int min= 1<<31-1;
                  if(a<min)
                  {
                      x=b;
                      y=c;
                      min=a;
                  }
                  if(b<min)
                  {
                       x=a;
                       y=c;
                       min=b;
                  }
                  if(c<min)
                  {
                      x=a;
                      y=b;
                      min=c;
                  }
              }
              else
              {
                  int max=-1<<31;
                  if(a>max)
                  {
                      max=a;
                      x=b;
                      y=c;
                  }
                  if(b>max)
                  {
                      max=b;
                      x=a;
                      y=c;
                  }
                  if(c>max)
                  {
                      max=c;
                      x=a;
                      y=b;
                  }
              }
               return ((double)x+(double)y)/2;
          }
         
	 public double findMedianOfFourNumbersEven(int []arr1,int []arr2)
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
		
                System.out.println("f:"+first+" s:"+second);
		
                return ((double)first + (double)(second))/2;
		/*
		else	//odd
		{
                    if(isFirst){
			if(first<second)
				return (double)first;
			else
				return (double)second;
                    }
                    else
                    {
                        if(first<second)
				return (double)second;
			else
				return (double)first;
                    }
		}*/
	 }
         public double findMedianOfFourNumbersOdd(int []arr1,int []arr2, boolean isSmaller)
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
		
                System.out.println("f:"+first+" s:"+second);
                if(isSmaller){
                       if(first<second)
                               return (double)first;
                       else
                               return (double)second;
                   }
                   else
                   {
                       if(first<second)
                               return (double)second;
                       else
                               return (double)first;
                   }
         }
	 
}

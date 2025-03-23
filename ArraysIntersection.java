package allQuestions;

import java.util.*;

public class ArraysIntersection {
	
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter size of first array");
		int size = s.nextInt();
		System.out.print("Enter element of first array");
		
		int arr1[] = new int[size];
		for(int i=0;i<size;i++)
			arr1[i]= s.nextInt();
		
		System.out.print("Enter size of second array");
		 size = s.nextInt();
		System.out.print("Enter element of second array");
		
		int arr2[] = new int[size];
		for(int i=0;i<size;i++)
			arr2[i]= s.nextInt();
		
		ArrayIntersectionPrinter(arr1,arr2);
		
	}
	
	 public static void ArrayIntersectionPrinter(int arr1[], int arr2[]) {
		 
		 Arrays.sort(arr1);
		 Arrays.sort(arr2);
		 int pointer1= 0;
		 int pointer2 = 0;
		 
		 while(pointer1<arr1.length && pointer2<arr2.length) {
			 
			 if(pointer1!=0 &&  arr1[pointer1]==arr1[pointer1-1]) {
				 pointer1++;
				 continue;
			 }
			 
			 if(pointer2!=0 &&  arr2[pointer2]==arr2[pointer2-1]) {
				 pointer2++;
				 continue;
			 }
			 
			 if(arr1[pointer1]<arr2[pointer2]) {
				 pointer1++;
			 }if(arr1[pointer1]>arr2[pointer2]) {
				 pointer2++;
			 }else {
				 System.out.println(arr1[pointer1]);
				 pointer1++;
				 pointer2++;
			 }
		 }
		 
		 
	 }

}

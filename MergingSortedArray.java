package allQuestions;

import java.util.Arrays;
import java.util.Scanner;

public class MergingSortedArray {

	public static void main(String[] args) {
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
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		 arr1 = MergeSortedArray(arr1, arr2);
		 
		 for(int i=0;i<arr1.length;i++)
				System.out.print(arr1[i]+" ");

	}

	private static int[] MergeSortedArray(int[] arr1, int[] arr2) {
		
		int first=0;
		int second=0;
		int index=0;
		int temp[] =  new int[arr1.length+arr2.length];
		while(first<arr1.length && second<arr2.length) {
			if(arr1[first]<arr2[second]) {
				temp[index]=arr1[first];
				index++;
				first++;
			}else {
				temp[index]=arr2[second];
				index++;
				second++;
			}
		}
		
		
		while (first < arr1.length) {
	        temp[index++] = arr1[first++];
	    }

	    while (second < arr2.length) {
	        temp[index++] = arr2[second++];
	    }
			
		
		
		return temp;
	}

}

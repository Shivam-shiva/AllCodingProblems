package allQuestions;

import java.util.Scanner;

public class Sort01And2 {
	
//	You are given an integer array/list(ARR) of size N. It contains only 0s, 1s and 2s. Write a solution to sort this array/list in a 'single scan'.
//
//	'Single Scan' refers to iterating over the array/list just once or to put it in other words, you will be visiting each element in the array/list just once.
//
//	Note:
//	1. You need to change in the given array/list itself. Hence, no need to return or print anything. 
//	2. You are not allowed to sort the list/array directly.

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter size of array");
		int size = s.nextInt();
		int arr[] = new int[size];
		for(int i=0;i<size;i++)
			arr[i]= s.nextInt();
		
		arr= SortZeroOneTwo(arr);
		for(int i=0;i<size;i++)
			System.out.print(arr[i]+" ");

	}

	private static int[] SortZeroOneTwo(int[] arr) {
		int zeroPos=0;
		int  twoPos=arr.length-1;
		
		for(int i=0;i<=twoPos;) {
			 if(arr[i]==0) {
				int swipe =arr[i];
				arr[i]=arr[zeroPos];
				arr[zeroPos]=swipe;
				zeroPos++;
			}else if(arr[i]==2) {
				int swipe =arr[i];
				arr[i]=arr[twoPos];
				arr[twoPos]=swipe;
				twoPos--;
				continue;
			}
			 
			 i++;
		}
		
		return arr;
	}

}

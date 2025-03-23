package allQuestions;

import java.util.Scanner;

public class BubbleSort {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter size of array");
		int size = s.nextInt();
		int arr[] = new int[size];
		for(int i=0;i<size;i++)
			arr[i]= s.nextInt();
		
		arr= BubbleSortAlgo(arr);
		
		System.out.println("Sorted array is");
		for(int i=0;i<size;i++)
			System.out.print(arr[i]+" ");
	}
	
	public static int[] BubbleSortAlgo(int arr[]) {
		boolean swapped=false;
		for(int i=arr.length-1;i>0;i--) {
			for(int j=0;j<i;j++) {
				if(arr[j]>arr[j+1]) {
					int swipe = arr[j];
					arr[j]= arr[j+1];
					arr[j+1]=swipe;
					swapped=true;
				}
			}
			if(!swapped) 
				break;
				
		}
		return arr;
	}

}

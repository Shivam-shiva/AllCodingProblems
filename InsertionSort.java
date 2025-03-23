package allQuestions;

import java.util.Scanner;

public class InsertionSort {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter size of array");
		int size = s.nextInt();
		int arr[] = new int[size];
		for(int i=0;i<size;i++)
			arr[i]= s.nextInt();
		
        arr= InsertionSortAlgo(arr);
		
		System.out.println("Sorted array is");
		for(int i=0;i<size;i++)
			System.out.print(arr[i]+" ");

	}

	private static int[] InsertionSortAlgo(int[] arr) {
		
		for(int i=1;i<arr.length;i++) {
			for(int j=i;j>0;j--) {
				if(arr[j]<arr[j-1]) {
					int swipe=arr[j];
					arr[j]=arr[j-1];
					arr[j-1] = swipe;
					
				}
			}
		}
		
		return arr;
	}

}

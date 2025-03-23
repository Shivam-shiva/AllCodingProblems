package allQuestions;

import java.util.*;

public class SelectionSort {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter size of array");
		int size = s.nextInt();
		int arr[] = new int[size];
		for(int i=0;i<size;i++)
			arr[i]= s.nextInt();

		System.out.println("Sorted array is ");
		arr= SelectionSortAlgo(arr);
		for(int i=0;i<size;i++)
			System.out.print(arr[i]+" ");

	}
	
	public static int[] SelectionSortAlgo(int arr[]) {
		for(int i=0;i<arr.length-1;i++) {
			int curElem=arr[i];
			for(int j =i;j<arr.length;j++) {
				if(arr[j]<curElem) {
					int swipe = curElem;
					curElem=arr[j];
					arr[j]=swipe;
				}
			}
			arr[i]=curElem;
		}
		return arr;
	}

}

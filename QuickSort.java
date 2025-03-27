package allQuestions;

import java.util.*;

public class QuickSort {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter size of array");
		int size = s.nextInt();
		int arr[] = new int[size];
		for(int i=0;i<size;i++)
			arr[i]= s.nextInt();
		
		quickSort(arr,0,arr.length-1);
		System.out.println("Sorted array is ");
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");


	}

	private static void quickSort(int[] arr, int start,  int end) {
		if(start>=end)
			return;
		
		 int pos = postionFinder(arr,start,end);
		 quickSort(arr,start,pos-1);
		 quickSort(arr,pos+1,end);
		
	}

	private static int postionFinder(int[] arr, int start, int end) {
		
		
		int count=0;
		for(int i=start;i<=end;i++) {
			if(arr[i]<arr[start])
				count++;
		}
		
		int pivotIndex = start+count;
		int swipe=arr[pivotIndex];
		arr[pivotIndex]=arr[start];
		arr[start]= swipe;
		
		int i=start,j=end;
		while (i < pivotIndex && j > pivotIndex) {
            while (arr[i] < arr[pivotIndex]) i++;
            while (arr[j] > arr[pivotIndex]) j--;

            if (i < pivotIndex && j > pivotIndex) {
            	 swipe=arr[i];
        		arr[i]=arr[j];
        		arr[j]= swipe;
                i++;
                j--;
            }
        }
		
		return pivotIndex ;
	}

}

package allQuestions;

import java.util.*;

public class BinarySearch {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter size of array");
		int size = s.nextInt();
		int arr[] = new int[size];
		for(int i=0;i<size;i++)
			arr[i]= s.nextInt();
		
		System.out.println("Enter the target");
		int target = s.nextInt();
		
		System.out.println("Index is "+ BinarySearch(arr,target)+".\nIf -1 then target in not in the array");

	}
	
	
	public static int BinarySearch(int arr[], int target) {
		int start =0;
		int end= arr.length-1;
		Arrays.sort(arr);
		
		while(start<end) {
			int mid=(start+end)/2;
			if(arr[mid]<target) {
				start = mid+1;
				
			}else if(arr[mid]>target) {
				end = mid-1;
				
			}else
				
				return mid;
		}
		return -1;
	}

}

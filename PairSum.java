package allQuestions;

import java.util.Arrays;
import java.util.Scanner;

public class PairSum {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.print("Enter size of array");
		int size = s.nextInt();
		int arr[] = new int[size];
		for(int i=0;i<size;i++)
			arr[i]= s.nextInt();
		
		System.out.print("Enter target");
		int target = s.nextInt();
		UniquePairSumFinder(arr,target);
	}
	
	public static void UniquePairSumFinder(int arr[], int target) {
		Arrays.sort(arr);
		
		int start =0;
		int end = arr.length-1;
		int count=0;
		while(start<end) {
			if(start!=0 && arr[start]==arr[start-1]) {
				start++;
				continue;
			}
			if(end!=arr.length-1 && arr[end]==arr[end+1]) {
				end--;
				continue;
			}
			
			if(arr[start]+arr[end]==target) {
				System.out.println(arr[start]+" "+arr[end]);
				count++;
				start++;
				end--;
			}else if(arr[start]+arr[end]<target) {
				start++;
			}else
				end--;
		}
		
		System.out.println("Total Pair is "+ count);
	}

}

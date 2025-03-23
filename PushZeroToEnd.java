package allQuestions;

import java.util.Scanner;

public class PushZeroToEnd {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.print("Enter size of array");
		int size = s.nextInt();
		int arr[] = new int[size];
		for(int i=0;i<size;i++)
			arr[i]= s.nextInt();
		
		arr= PushesZeroToEnd(arr);
		for(int i=0;i<arr.length;i++)
		System.out.print(arr[i]+" ");
		
	}

	private static int[] PushesZeroToEnd(int[] arr) {
		
		int zeroPos=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=0) {
				int swipe = arr[i];
				arr[i]= arr[zeroPos];
				arr[zeroPos]=swipe;
				zeroPos++;
			}
		}
		
		return arr;
	}

}

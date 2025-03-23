package allQuestions;

import java.util.*;

public class FindDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.print("Enter size of array");
		int size = s.nextInt();
		int arr[] = new int[size];
		for(int i=0;i<size;i++)
			arr[i]= s.nextInt();
		System.out.print("Duplicate number is "+ 	duplicateFinder(arr));
	}
	
	public static int duplicateFinder(int arr[]) {
		Arrays.sort(arr);
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i]==arr[i+1])
				return arr[i];
		}
		return 0;
	}

}

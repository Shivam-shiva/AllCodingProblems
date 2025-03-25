package allQuestions;

import java.util.*;

//Two random integer arrays/lists have been given as ARR1 and ARR2 of size N and M respectively. Both the arrays/lists contain numbers from 0 to 9(i.e. single digit integer is present at every index). The idea here is to represent each array/list as an integer in itself of digits N and M.
//
//You need to find the sum of both the input arrays/list treating them as two integers and put the result in another array/list i.e. output array/list will also contain only single digit at every index.
//
//Note:
//The sizes N and M can be different. 
public class SumOfTwoArray {

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
		
		int output[] = new int[Integer.max(arr1.length, arr2.length)+1];
		
		SumOfArray(arr1, arr2, output);
		
		for(int i=0;i<output.length;i++)
			System.out.print(output[i]+" ");

	}

	private static void SumOfArray(int[] arr1, int[] arr2, int output[]) {
		int i=arr1.length-1;
		int j = arr2.length-1;
		int index= output.length-1;
		int rem=0;
		while(i>=0 && j>=0) {
			int sum = arr1[i]+arr2[j]+rem;
			output[index]=(sum)%10;
			rem = (sum)/10;
			index--;
			i--;
			j--;
		}
		
		if(i>=0) {
			
			int sum = arr1[i]+rem;
			output[index]=(sum)%10;
			rem = (sum)/10;
			index--;
			i--;
		}else if(j>=0) {
			int sum = arr2[j]+rem;
			output[index]=(sum)%10;
			rem = (sum)/10;
			index--;
			j--;
		}
		if(rem>0)
			output[index]=rem;
		
	}

}

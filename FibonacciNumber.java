package allQuestions;

import java.util.*;

public class FibonacciNumber {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a number");
		int num = s.nextInt();
		
		for (int i = 1; i <= num; i++) {
            System.out.print(PrintFibonacci(i) + " ");
        }
	}

	private static int PrintFibonacci(int num) {
		
		
		if(num<=1) 
			return num;
		
		return PrintFibonacci(num-1)+PrintFibonacci(num-2);
	}

}

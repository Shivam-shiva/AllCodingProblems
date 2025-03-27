package allQuestions;

import java.util.Scanner;

public class StringToInteger {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a string of number");
		Integer.parseInt("34563");
		String str = s.next();
		int num = stringToInteger(str, str.length()-1, 0);
		System.out.println(num);

	}

	private static int stringToInteger(String str, int num , int index) {
		if(str.length()==1 || index==str.length()-1) {
			System.out.println(num+" "+(str.charAt(index)-48)+" "+index);
			return str.charAt(index)-48;
		}
		
		int n= (int) ((str.charAt(index)-48)*(Math.pow(10, num)));
		int m = stringToInteger(str,num-1, index+1);
//		System.out.println(num+" "+n+" "+index);
		return n+m;
		
	}

}

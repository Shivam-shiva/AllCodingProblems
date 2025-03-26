package allQuestions;

import java.util.*;

public class AllSubString {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a String");
		
		String  str = s.next();
		System.out.println("All substring of given  String is ");
		PrintAllSubtring(str);
	}

	private static void PrintAllSubtring(String str) {
		
		for(int i=0;i<str.length();i++) {
			for(int j=i+1;j<=str.length();j++) {
				System.out.println(str.substring(i, j));
			}
		}
		
	}

}

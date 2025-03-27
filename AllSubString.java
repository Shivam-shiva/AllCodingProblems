package allQuestions;


//For a given input string(str), write a function to print all the possible substrings.
//
//Substring
//A substring is a contiguous sequence of characters within a string. 
//Example: "cod" is a substring of "coding". Whereas, "cdng" is not as the characters taken are not contiguous
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

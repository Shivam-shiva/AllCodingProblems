package allQuestions;

//Suppose you have a string, S, made up of only 'a's and 'b's. Write a recursive function that checks if the string was generated using the following rules:
//
//a. The string begins with an 'a'
//b. Each 'a' is followed by nothing or an 'a' or "bb"
//c. Each "bb" is followed by nothing or an 'a'
//If all the rules are followed by the given string, return true otherwise return false.



import java.util.*;

public class CheckAB {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		String str = s.next();
		
		boolean bb =str.charAt(0)=='a' &&  checkAB(str);
		System.out.println(bb);

	}

	private static boolean checkAB(String str) {
		if(str.length()<=1)
			return str.length()==0 || str.charAt(0)=='a';
		
		if(str.charAt(0)=='a'){
			boolean b= checkAB(str.substring(1));
			return b&&((str.length()==1) || str.charAt(1)=='a' || str.substring(1, 3).equals("bb"));
			
		}else if(str.charAt(0)=='b'){
			boolean b = checkAB(str.substring(2));
			return b && str.charAt(1)=='b' && (str.length()==2 || str.charAt(2)=='a');
			
		}
		
		return false;
	}

}

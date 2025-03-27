package allQuestions;

import java.util.*;

public class RemoveX {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		String str = s.next();
		char target = s.next().charAt(0);
		
		str = RemoveAllX(str, target,0);
		System.out.println(str);

	}

	private static String RemoveAllX(String str, char target, int index) {
		if(index==str.length())
			return "";
		
		String small= RemoveAllX(str, target, index+1);
		
		//str.charAt(index)==target?return small:return str.charAt(index)+small  can use this in place of below line of code 
		if(str.charAt(index)==target) {
			return small;
		}else {
		    return str.charAt(index)+small;	
		}
		
	}

}

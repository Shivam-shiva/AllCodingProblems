package allQuestions;
import java.util.*;
public class AllQuesStack {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
//		ArrayStack  st = new ArrayStack ();
//		System.out.println(st.isEmpty());
//		System.out.println(st.size()+" "+st.pop());
//		st.push(6);st.push(2);st.push(4);
//		st.push(7);st.push(9);
//		st.push(6);st.push(2);st.push(4);
//		st.push(7);st.push(9);
//		st.pop();st.pop();st.pop();st.pop();st.pop();st.pop();st.pop();st.pop();
//		System.out.println(st.pop()+" "+st.size());
		System.out.print(balancedParanthesis(s.next()));

	}
	
	/*For a given a string expression containing only round brackets or parentheses, check if they are balanced or not. Brackets are said to be balanced if the bracket which opens last, closes first.



	Example:
	Expression: (()())
	Since all the opening brackets have their corresponding closing brackets, we say it is balanced and hence the output will be, 'true'.
	You need to return a boolean value indicating whether the expression is balanced or not.*/
	
	
	public static boolean balancedParanthesis(String str) {
		if(str.length()%2!=0)
			return false;
		
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='(')
				stack.push('(');
			else {
				if(stack.size()==0)
					return false;
				stack.pop();
			}
		}
		
		return stack.size()==0;
	}

}




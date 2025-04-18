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
		System.out.print(minBracketRev(s.next()));

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
	
	/*For a given expression in the form of a string, find if there exist any redundant brackets or not. It is given that the expression contains only rounded brackets or parenthesis and the input expression will always be balanced.

	A pair of the bracket is said to be redundant when a sub-expression is surrounded by unnecessary or needless brackets.

	Example:
	Expression: (a+b)+c
	Since there are no needless brackets, hence, the output must be 'false'.

	Expression: ((a+b))
	The expression can be reduced to (a+b). Hence the expression has redundant brackets and the output will be 'true'.*/
	
	public static boolean redundantBracket(String str) {
		Stack<Character> stack = new Stack<>();

		for(int i=0;i<str.length();i++) {
			Character ch= str.charAt(i);
			if(ch=='(')
				stack.push('(');
			 else if(stack.size()!=0 && stack.peek()=='('&& (ch=='+' || ch=='-'||ch=='*'|| ch=='/')) 
				stack.push(ch);
			 else if(ch==')'&& stack.size()!=0 && (stack.peek()=='+' || stack.peek()=='-' ||stack.peek()=='*' || stack.peek()=='/'))
				 while(stack.pop()!='(');
		}
		return stack.size()!=0;
	}
	
	/*For a given expression in the form of a string, find the minimum number of brackets that can be reversed in order to make the expression balanced. The expression will only contain curly brackets.

	If the expression can't be balanced, return -1.

	Example:
	Expression: {{{{
	If we reverse the second and the fourth opening brackets, the whole expression will get balanced. Since we have to reverse two brackets to make the expression balanced, the expected output will be 2.

	Expression: {{{
	In this example, even if we reverse the last opening bracket, we would be left with the first opening bracket and hence will not be*/
	
	public static int minBracketRev(String str) {
		if(str.length()%2!=0)
			return -1;
		
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<str.length();i++) {
			Character ch = str.charAt(i);
			if(ch=='{')
				stack.push(ch);
			else if(ch=='}') {
				if(!stack.isEmpty() && stack.peek()=='{')
					stack.pop();
				else if(stack.isEmpty() || stack.peek()=='}')
					stack.push('}');
			}
		 }
		int revCount=0;
		while(!stack.isEmpty()) {
			 Character first = stack.pop();
			 Character second = stack.pop();
			 if(first==second)
				 revCount+=1;
			 else 
				 revCount+=2;
		}
		
		return revCount;
	}

}







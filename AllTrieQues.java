package allQuestions;

import java.util.Scanner;

public class AllTrieQues {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.next();
		
		Tries node = new Tries();
		node.insert(s.next());
		node.insert(s.next());
		node.insert(str);
		node.insert(s.next());
		node.insert(s.next());
		node.print();
//		System.out.println(node.search(str));
//		node.remove(str);
//		System.out.println(node.search(str));
		
	}

}

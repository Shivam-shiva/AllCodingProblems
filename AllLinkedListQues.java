package allQuestions;

import java.util.Scanner;

public class AllLinkedListQues {

	public static void main(String[] args) {
		
		LinkedList<Integer> list = new LinkedList<Integer>();
//		System.out.println(list.getSize());
//		list.add(new LinkedListStr<String>("Ram"));
//		list.add(new LinkedListStr<String>("Radha"));
//		list.add(new LinkedListStr<String>("Mohan"));
//		list.add(new LinkedListStr<String>("Reshma"));
//		list.add(new LinkedListStr<Integer>(9));
//		list.add(new LinkedListStr<Integer>(4));
//		list.remove();list.remove();list.remove();list.remove();list.remove();list.remove();
//		list.print();
//		System.out.println(list.getSize());
		
//		/Taking input from user only integer input allowed 
		Scanner s = new Scanner(System.in);
		System.out.println("Enter integer value enter -1 after last element");
		int data = s.nextInt();
		while(data!=-1) {
			list.add(new LinkedListStr<Integer>(data));
			data=s.nextInt();
		}
//		list.setAtIndex(1,new LinkedListStr<Integer>(8) );
//		list.removeAtindex(3);
		list.printRecursiveHelper();
		
	}

}

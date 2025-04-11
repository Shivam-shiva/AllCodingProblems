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
//		list.printRecursiveHelper();
//		list.reverseLL();
		LinkedListStr<Integer> head = list.getHead();
		head=oddEvenLL(head);
		list.print();
	}
	
	
	/*For a given singly linked list of integers, arrange the nodes such that all the even number nodes are placed after the all odd number nodes. The relative order of the odd and even terms should remain unchanged.

	Note :
	1. No need to print the linked list, it has already been taken care. Only return the new head to the list.
	2. Don't create a new linked list.
	3.  Just change the data, instead rearrange the provided list.*/
	
	public static LinkedListStr<Integer> oddEvenLL(LinkedListStr<Integer> head) {
		LinkedListStr<Integer> nextOdd= head;
		LinkedListStr<Integer> curNode=head;
		
		while(curNode!=null) {
			if(curNode.data%2!=0) {
				if(curNode==nextOdd) {
					nextOdd= nextOdd.next;
					curNode=curNode.next;
					continue;
				}
					
				int data = nextOdd.data;
				nextOdd.data=curNode.data;
				LinkedListStr<Integer> node = nextOdd.next;
				while(node!=curNode.next) {
					int dd = node.data;
					node.data= data ;
					data = dd;
					node= node.next;
				}
				nextOdd=nextOdd.next;
				curNode=curNode.next;
			}
			else {
				if(nextOdd.data%2!=0)
					nextOdd=curNode;
				curNode=curNode.next;
			}
		}
		
		return head;
		
	}
	

}







package allQuestions;

import java.util.*;

public class AllLinkedListQues {

	public static void main(String[] args) {
		
		LinkedLists<Integer> list = new LinkedLists<Integer>();
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
//		head=oddEvenLL(head);
		int m=s.nextInt(), n =s.nextInt();
//		head = swapNodeNM(head, m , n);
		head= reverseKNode(head, m);
		
		while(head!=null) {
			System.out.print(head.data+" ");
			head=head.next;
		}
//		list.print();
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
	
//	You have been given a singly linked list of integers along with two integers, 'M,' and 'N.' Traverse the linked list such that you retain the 'M' nodes, then delete the next 'N' nodes. Continue the same until the end of the linked list. Indexing starts from 1.
//
//	To put it in other words, in the given linked list, you need to delete N nodes after every M nodes.
//
//	Note :
//	No need to print the list, it has already been taken care. Only return the new head to the list. You can return null in case where all nodes will be deleted.
	
     
	public static LinkedListStr<Integer> deleteMNNode(LinkedListStr<Integer>  head, int m, int n ){
		if(head==null || n==0)
			return head;
		if(m==0)
			return null;
		
		LinkedListStr<Integer> curNode= head;
		while(curNode!=null) {
			int count=m;
			while(curNode!=null && count>1) {
				curNode=curNode.next;
				count--;
			}
			LinkedListStr<Integer> temp= curNode;
			count = n;
			while(temp!=null && count>=0) {
				temp=temp.next;
				count--;
			}
			if(curNode!=null) {
			curNode.next=temp;
			curNode= curNode.next;
			}
		}
		return head;
	}
	
	
	/*You have been given a singly linked list of integers along with two integers, 'i,' and 'j.' Swap the nodes that are present at the 'i-th' and 'j-th' positions and return the new head to the list.

			Note :
			1. Remember, You need to swap the nodes, not only the data.
			2. Indexing starts from 0.
			3. No need to print the list, it has already been taken care.*/
	
	public static LinkedListStr<Integer> swapNodeNM(LinkedListStr<Integer> head, int m, int n) {
	    if (head == null || m == n) return head;
	    if (m > n) {
	        int temp = m;
	        m = n;
	        n = temp;
	    }

	    LinkedListStr<Integer> curNode = head;
	    LinkedListStr<Integer> firstNode = null;
	    LinkedListStr<Integer> secondNode = null;
	    LinkedListStr<Integer> h1 = null;
	    LinkedListStr<Integer> h2 = null;
	    int idx = 0;

	    while (curNode != null) {
	        if (idx == m - 1) h1 = curNode;
	        if (idx == m) firstNode = curNode;
	        if (idx == n - 1) h2 = curNode;
	        if (idx == n) {
	            secondNode = curNode;
	            break;
	        }
	        curNode = curNode.next;
	        idx++;
	    }

	    if (firstNode == null || secondNode == null) return head;

	    if (h1 != null) h1.next = secondNode;
	    else head = secondNode;

	    if (h2 != null && h2 != firstNode) h2.next = firstNode;
	    else if (h2 == firstNode) h2.next = firstNode;  // adjacent swap case
	    else head = firstNode;

	    LinkedListStr<Integer> temp = firstNode.next;
	    firstNode.next = secondNode.next;
	    secondNode.next = temp;

	    return head;
	}

	
	/*Given a singly linked list of integers, reverse the nodes of the linked list 'k' at a time and return its modified list.

			 'k' is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of 'k,' then left-out nodes, in the end, should be reversed as well.

			Example :
			Given this linked list: 1 -> 2 -> 3 -> 4 -> 5

			For k = 2, you should return: 2 -> 1 -> 4 -> 3 -> 5

			For k = 3, you should return: 3 -> 2 -> 1 -> 5 -> 4
			 Note :
			No need to print the list, it has already been taken care. Only return the new head to the list.*/
	
	public static LinkedListStr<Integer> reverseKNode(LinkedListStr<Integer> head, int k ){
		if(head==null || head.next==null ) {
			return head;
		}
		LinkedListStr<Integer> prev=head;
		LinkedListStr<Integer> cur = head.next;
		LinkedListStr<Integer> next= cur.next;
		int count=1;
		while(cur!=null && count<k) {
			cur.next= prev;
			prev=cur;
			cur=next;
			if(next==null) {
				break;
			}
			next=next.next;
			count++;
		}
		
		LinkedListStr<Integer> small= reverseKNode(cur, k);
		head.next=small;
		return prev;
	}
	
}







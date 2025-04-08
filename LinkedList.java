package allQuestions;

public class LinkedList<T> {
	
	public LinkedListStr<T> head;
	public LinkedListStr<T> nextE ;
	
	public LinkedList() {
		head= null;
		nextE = null;
	}
	
	
	public  LinkedListStr<T> add(LinkedListStr<T> node) {
		if(head==null) {
			head = node;
			nextE =node;
			return head;
		}
		nextE.next= node;
		nextE = node;
		return head;
	}
	
	public LinkedListStr<T> remove(){
		if(head==null) {
			System.out.println("No element to remove");
			return head;
		}
		
		LinkedListStr<T> node= head;
		while(node.next!=nextE) {
			node=node.next;
		}
		nextE=node;
		nextE.next=null;
		
		return head;
	}
	
}

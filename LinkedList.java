package allQuestions;

public class LinkedList<T> {
	
	private LinkedListStr<T> head;
	private LinkedListStr<T> tail ;
	private int size;
	
	public LinkedList() {
		size=0;
	}
	
	public int getSize() {
		 return size;
	}
	
	
	public  void add(LinkedListStr<T> node) {
		if(head==null) {
			head = node;
			tail =node;
			size++;
			return ;
		}
		tail.next= node;
		tail = node;
		size++;
	}
	
	public void remove(){
		if(head==null) {
			System.out.println("No element to remove");
			return;
		}
		if(head.next==null) {
			head= null;
			tail= null;
			size--;
			return;
		}
			
		LinkedListStr<T> node= head;
		while( node.next!=tail) {
			node=node.next;
		}
		tail=node;
		size--;
		tail.next=null;
		
	}
	
	public void setAtPos(int pos , LinkedListStr<T> newNode) {
		if(head==null || pos<0)
			return ;
		
		 if (pos == 1) {
		        newNode.next = head;
		        head = newNode;
		        if (tail == null)
		        	tail = newNode;
		        size++;
		        return;
		    }
		
		LinkedListStr<T> current =head;
		while(pos>1 && current!=null) {
			pos--;
			current=current.next;
		}
		
		 if (current == null || current.next == null) {
		        return;
		    }
		 
		 newNode.next = current.next;
		    current.next = newNode;
		size++;
	}
	
	public void print() {
		if(head==null) {
			System.out.println("No element to print");
			return;
		}
		LinkedListStr<T> node= head;
		while(node!=null) {
			System.out.print(node.data+" ");
			node=node.next;
		}
	}
	
}

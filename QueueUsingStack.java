package allQuestions;
import java.util.*;

public class QueueUsingStack {
	
	private Stack<Integer> original;
	private Stack<Integer> temp;
	 private int size;
	
	public QueueUsingStack() {
		original = new Stack<>();
		temp=new Stack<>();
	}
	
	public int getSize() {
		return size;
	}
	
	public void push(int data) {
		original.push(data);
		size++;
	}
	
	public int pop() {
		if(original.isEmpty()) {
			System.out.println("Queue is empty");
			return -1;
		}
			
		
		while(original.size()>=1) 
			temp.push(original.pop());
		int data = temp.pop();
		while(!temp.isEmpty())
			original.push(temp.pop());
		size--;
        return data;
	}
	
	
	public int peek() {
		if(original.isEmpty()) {
			System.out.println("Queue is empty");
		    return -1;
		}
		
		while(original.size()>=1) 
			temp.push(original.pop());
		int data = temp.peek();
		while(!temp.isEmpty())
			original.push(temp.pop());
        return data;
	}
	

}





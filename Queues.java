package allQuestions;

public class Queues {
	
	private int arr[];
	private int size;
	private int front;
	private int rear;
	private final int arrayIntialSize=5;
	
	public Queues() {
		arr= new int[arrayIntialSize];
	}
	
	public int getSize() {
		return size;
	}
	
	public void enQueue(int data) {
		if(size==arr.length)
			incrArraySize();
		
		if(rear==arr.length && size<arr.length)
			rear=0;
		arr[rear]=data;
		rear++;
		size++;
	}
	
	public int deQueue() {
		if(size==0) {
			System.out.println("Queue has 0 entry");
			return -1;
		}
		int data = arr[front];
		front++;
		if(front>=arr.length)
			front=0;
		size--;
		if(arr.length>arrayIntialSize && size< arr.length/3) 
			decArraySize();
			
		return data;
	}
	
	public int peek() {
		if (size == 0) {
		    System.out.println("Queue is empty");
		    return -1;
		}
		return arr[front];
	}
	
	
	private void incrArraySize() {
		
		int temp[]=arr;
		arr = new int[arr.length*2];
		for(int i=0;i<temp.length;i++) {
			arr[i]= temp[front];
			front++;
			if(front==temp.length)
				front=0;
		}
		front=0;
		rear=size;
	}
	
	public void decArraySize() {
		
		int temp[]= arr;
		arr= new int[arr.length/2];
		for(int i=0;i<size;i++) {
			arr[i]=temp[front];
			front++;
			if(front==temp.length)
				front=0;
		}
		front=0;
		rear=size;
	}
	
	

}

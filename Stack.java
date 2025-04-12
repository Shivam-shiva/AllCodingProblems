package allQuestions;

public class Stack {

	private int[] arr;
	private int index;
	private final int intialArraySize=5;
	
	public Stack() {
		arr= new int[intialArraySize];
	}
	
	
	public void push(int value) {
		if(index==arr.length) 
			doubleTheArray();
			
		arr[index]=value;
		index++;
	}
	
	public int pop() {
		if(index==0) {
			System.out.println("Stack is empty");
			return -1;
		}
		index--;
		if(index>=intialArraySize && index<arr.length/3)
			reduceArraySize();
	    return arr[index];
	}
	
	public int getTop() {
		if(index==0) {
			System.out.println("Stack is empty");
			return -1;
		}
		return arr[index-1];
	}
	
	public int size() {
		return index;
	}
	
	private void doubleTheArray() {
		int temp[] = arr;
		arr=new int[2*arr.length];
		for(int i=0;i<temp.length;i++)
			arr[i]=temp[i];
	}
	
	private void reduceArraySize() {
		int temp[]=arr;
		arr= new int[arr.length/2];
		for(int i=0;i<arr.length;i++)
			arr[i]=temp[i];
	}
}




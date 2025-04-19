package allQuestions;
import java.util.*; 

public class MinPriority {
	
	private ArrayList<Integer> arr;
	private int count;
	
	public MinPriority() {
		arr= new ArrayList<>();
	}
	
	public void print() {
		System.out.println(arr);
	}
	
	
	public void insert(int data) {
		arr.add(data);
		int childIndex = count;
		count++;

		int parentIndex = (childIndex-1)/2;
		
		while(childIndex > 0 && arr.get(parentIndex) > arr.get(childIndex)) {
			int temp = arr.get(parentIndex);
			arr.set(parentIndex, arr.get(childIndex));
			arr.set(childIndex, temp);
			childIndex=parentIndex;
			parentIndex=(childIndex-1)/2;
		}
	}
	
	
	public int removeMin() {
		if(count==0)
			return -1;
		
		int min = arr.get(0);
		count--;
		arr.set(0, arr.get(count));
		arr.set(count, min);
		arr.remove(count);
		int parentIndex = 0;
		int leftChild = 2*parentIndex+1;
		int rightChild = 2*parentIndex+2;
		if(rightChild>=count || leftChild>=count)
			return min;
		int childIndex = arr.get(leftChild)>arr.get(rightChild)?rightChild:leftChild;
		while(childIndex<count && arr.get(childIndex)<arr.get(parentIndex)) {
			int temp = arr.get(childIndex);
			arr.set(childIndex, arr.get(parentIndex));
			arr.set(parentIndex, temp);
			parentIndex = childIndex;
			leftChild = 2*parentIndex+1;
			rightChild = 2*parentIndex+2;
			if(rightChild>=count ) {
				if(leftChild>=count)
					return min;
				childIndex=leftChild;
				continue;
			}
			childIndex = arr.get(leftChild)>arr.get(rightChild)?rightChild:leftChild;
		}
		return min;
	}
	
	public int getMinimum() {
		if(count==0)
			return -1;
		
		return arr.get(0);
	}
	
	public int getSize() {
		return count;
	}
	
	public boolean isEmpty() {
		return count==0;
	}
	
		
	
}

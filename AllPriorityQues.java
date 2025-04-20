package allQuestions;
import java.util.*;

public class AllPriorityQues {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
//		MinPriority queue = new MinPriority();
//		int data = s.nextInt();
//		while(data!=-1) {
//			queue.insert(data);
//			data = s.nextInt();
//		}
//		s.close();
//		queue.print();
//		System.out.print(queue.getMinimum()+" ");
//		System.out.println(queue.removeMin());
//		System.out.println(queue.getSize());
//		queue.print();
//		
//		System.out.print(queue.getMinimum()+" ");
//		System.out.println(queue.removeMin());
//		queue.print();
//		System.out.print(queue.getMinimum()+" ");/
		
		int size = s.nextInt();
//		int arr[] = new int[size];
//		for(int i=0;i<size;i++)
//			arr[i]=s.nextInt();
//		
//		arr=inLineHeapSort(arr);
//		for(int i=0;i<size;i++)
//			System.out.print(arr[i]+" ");/
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i=0;i<size;i++)
			arr.add(s.nextInt());
		
		int index = s.nextInt();
		System.out.println(buyTicket(arr, index));
	}
	
	public static int[] heapSort(int[] arr) {
		if(arr.length==0 || arr.length==1)
			return arr;
		
		MinPriority queue = new MinPriority();
		for(int i=0;i<arr.length;i++) {
			queue.insert(arr[i]);
		}
		
		for(int i=0;i<arr.length;i++) {
			arr[i]=queue.removeMin();
		}
		
		return arr;
	}
	
	
	public static int[] inLineHeapSort(int[] arr) {
		if(arr.length==0 || arr.length==1)
			return arr;
		
		
		for(int i=1; i<arr.length;i++) {
			upHipify(arr, i);
		}
		
		int parentIndex=0;
		int sortedIndex=arr.length-1;
		for(int i=0;i<arr.length;i++) {
			parentIndex=0;
			int temp= arr[parentIndex];
			arr[parentIndex] = arr[sortedIndex];
			arr[sortedIndex]= temp;
			downHipify(arr, parentIndex, sortedIndex);
			sortedIndex--;
		}
		return arr;
	}
	
	
	public static void upHipify(int arr[], int index) {
		int childIndex= index;
		int parentIndex = (childIndex-1)/2;
		while(childIndex>0 && arr[childIndex]<arr[parentIndex]) {
			int temp = arr[childIndex];
			arr[childIndex] = arr[parentIndex];
			arr[parentIndex]=temp;
			childIndex=parentIndex;
			parentIndex = (childIndex-1)/2;	
		}
	}
	
	
	public static void downHipify(int arr[], int parentIndex, int sortedIndex) {
		int childIndex = 0;
		if(sortedIndex>2)
			childIndex= arr[1]<arr[2]?1:2;
		else if(sortedIndex>1 )
			childIndex=1;
		else 
			return ;

		boolean swipe= true;
		while(childIndex<sortedIndex && swipe) {

			swipe= false;
			if(arr[childIndex]<arr[parentIndex]) {
				int temp= arr[childIndex];
				arr[childIndex]= arr[parentIndex];
				arr[parentIndex]=temp;
				parentIndex=childIndex;
				
				if(2*parentIndex+2<arr.length) 
				    childIndex = arr[2*parentIndex+1]<arr[2*parentIndex+2]?2*parentIndex+1:2*parentIndex+2;
				else if(2*parentIndex+2>=arr.length  && 2*parentIndex+1<arr.length)
					childIndex = 2*parentIndex+1;
				else {
					swipe=false;
					continue;
				}
				swipe=true;
			}
		}
	}
	
	
	
	public static int buyTicket(ArrayList<Integer> arr, int myIndex) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
		for(int i=0;i<arr.size();i++)
			maxHeap.add(arr.get(i));
		
		int time=0;
		boolean gotTicket = false;
		while(!gotTicket && arr.size()!=0) {
			if(maxHeap.peek()==arr.get(0)) {
				time++;
				if(myIndex==0)
					return time;
				arr.remove(0);
				maxHeap.poll();
			}else {
				int temp = arr.remove(0);
				arr.add(temp);
			}
			myIndex--;
			if(myIndex==-1)
				myIndex=arr.size()-1;
		}
		
		return time;
	}
	
	

}



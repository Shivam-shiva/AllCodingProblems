package allQuestions;

import java.util.*;

public class AllQueueQues {

	public static void main(String[] args) {
//		Queues qq = new Queues();
		// I have a custom class name LikedList which is generic class so need to pass fully qualified name
		java.util.Queue<Integer> queue = new java.util.LinkedList<Integer>();
		System.out.println("Enter data for queue, enter -1 at last");
		Scanner s = new Scanner(System.in);	
		int data = s.nextInt();
		while(data!=-1) {
			queue.add(data);
			data = s.nextInt();
		}
		
		queue= reverseKElement(queue, s.nextInt());
		s.close();
		while(!queue.isEmpty()) {
			System.out.print(queue.poll()+" ");
		}
//		for(int i=0;i<10;i++) {
//			qq.deQueue();
//		}
//		System.out.println(qq.getSize());
//		qq.enQueue(3);
//		int size = qq.getSize();
//		System.out.println(size);
//		for(int i=0;i<size;i++) {
//			System.out.print(qq.deQueue()+" ");
//		}
	}
	
	
	/*For a given queue containing all integer data, reverse the first K elements.

	You have been required to make the desired change in the input queue itself.

	Example:
	alt txt

	For the above input queue, if K = 4 then after reversing the first 4 elements, the queue will be updated as:
	alt txt

	Detailed explanation ( Input/output format, Notes, Images )
	Constraints :
	1 <= N <= 10^6
	1 <= K <= N
	-2^31 <= data <= 2^31 - 1

	 Time Limit: 1sec*/
	
	public static Queue<Integer> reverseKElement(Queue<Integer> queue, int k){
		if(queue.isEmpty() || k>queue.size())
			return queue;
		
		int size = queue.size()-k;
		Stack<Integer> stack = new Stack<>();

		for(int i=0;i<k;i++)
			stack.add(queue.remove());
		
		for(int i=0;i<k;i++) {
			queue.add(stack.pop());
		}
		
		while(!queue.isEmpty() && size>0) {
			queue.add(queue.remove());
			size--;
		}
		
		return queue;
	}

}




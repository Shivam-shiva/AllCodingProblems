package allQuestions;

import java.util.*;

public class AllQueueQues {

	public static void main(String[] args) {
		Queues qq = new Queues();
		System.out.println("Enter data for queue, enter -1 at last");
		Scanner s = new Scanner(System.in);
		int data = s.nextInt();
		while(data!=-1) {
			qq.enQueue(data);
			data = s.nextInt();
		}
		s.close();
		for(int i=0;i<10;i++) {
			qq.deQueue();
		}
		System.out.println(qq.getSize());
		qq.enQueue(3);
		int size = qq.getSize();
		System.out.println(size);
		for(int i=0;i<size;i++) {
			System.out.print(qq.deQueue()+" ");
		}
		

	}

}

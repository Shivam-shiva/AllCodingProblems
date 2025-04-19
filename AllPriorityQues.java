package allQuestions;
import java.util.*;

public class AllPriorityQues {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		MinPriority queue = new MinPriority();
		int data = s.nextInt();
		while(data!=-1) {
			queue.insert(data);
			data = s.nextInt();
		}
		s.close();
//		queue.print();
		System.out.print(queue.getMinimum()+" ");
		System.out.println(queue.removeMin());
		System.out.println(queue.getSize());
//		queue.print();
		
		System.out.print(queue.getMinimum()+" ");
		System.out.println(queue.removeMin());
//		queue.print();
		System.out.print(queue.getMinimum()+" ");
		
		
		

	}

}

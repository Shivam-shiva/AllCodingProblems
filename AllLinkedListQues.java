package allQuestions;

public class AllLinkedListQues {

	public static void main(String[] args) {
		
		LinkedList<String> list = new LinkedList<String>();
//		System.out.println(list.getSize());
		list.add(new LinkedListStr<String>("Ram"));
		list.add(new LinkedListStr<String>("Radha"));
		list.add(new LinkedListStr<String>("Mohan"));
		list.add(new LinkedListStr<String>("Reshma"));
//		list.add(new LinkedListStr<Integer>(9));
//		list.add(new LinkedListStr<Integer>(4));
//		list.remove();list.remove();list.remove();list.remove();list.remove();list.remove();
		list.print();
//		System.out.println(list.getSize());
	}

}

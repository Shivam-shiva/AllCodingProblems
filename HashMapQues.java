package allQuestions;
import java.util.*;

public class HashMapQues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s= new Scanner(System.in);
		int size = s.nextInt();
		int arr[] = new int[size];
		for(int i=0;i<arr.length;i++) {
			arr[i]=s.nextInt();
		}
		
		ArrayList<Integer> list = longestSeq(arr);
		System.out.print(list);

	}
	
	public static ArrayList<Integer> longestSeq(int[] arr) {
	    ArrayList<Integer> result = new ArrayList<>();
	    if (arr == null || arr.length == 0) 
	        return result;

	    HashMap<Integer, Boolean> map = new HashMap<>();
	    for (int num : arr) {
	        map.put(num, true);
	    }

	    int maxLength = 0;
	    int sequenceStart = 0;

	    for (int num : arr) {
	        if (!map.containsKey(num - 1)) {
	            int currentNum = num;
	            int currentLength = 1;

	            while (map.containsKey(currentNum + 1)) {
	                currentNum++;
	                currentLength++;
	            }

	            if (currentLength > maxLength) {
	                maxLength = currentLength;
	                sequenceStart = num;
	            }
	        }
	    }

	    result.add(sequenceStart);
	    if (maxLength > 1) {
	        result.add(sequenceStart + maxLength - 1);
	    }
	    return result;
	}

}

package allQuestions;
import java.util.*;
public class HuffmanCoding {
	

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		String str = s.next();
		s.close();
		BinaryTreeNode<HuffmanNode> root = frequencyTree(str);
		ArrayList<Byte> arr = new ArrayList<Byte>();
		StringBuffer str1 = new StringBuffer();
		huffmanCode(root, arr, str1);
		System.out.println(arr.size());
		byte code[] = bitPackHuffman(arr);
		for(int i=0;i<code.length;i++)
		System.out.print(code[i]+" ");
	}

	
	private static void huffmanCode(BinaryTreeNode<HuffmanNode> root, ArrayList<Byte> arr, StringBuffer str) {
	    if (root == null) {
	        return;
	    }

	    if (root.left == null && root.right == null) {
	        String strLocal = str.toString();
	        for (char c : strLocal.toCharArray()) {
	            arr.add((byte) (c - '0'));
	        }
	        return;
	    }

	    str.append('0');
	    huffmanCode(root.left, arr, str);
	    str.setLength(str.length() - 1);

	    str.append('1');
	    huffmanCode(root.right, arr, str);
	    str.setLength(str.length() - 1);
	}

	private static byte[] bitPackHuffman(ArrayList<Byte> arr) {
	    StringBuilder allBits = new StringBuilder();

	    for (Byte b : arr) {
	        allBits.append(b == 0 ? '0' : '1');
	    }

	    int length = allBits.length();
	    int numBytes = (length + 7) / 8;
	    byte[] result = new byte[numBytes];

	    int byteIndex = 0;
	    int bitIndex = 0;
	    int currentByte = 0;

	    for (int i = 0; i < length; i++) {
	        currentByte = (currentByte << 1) | (allBits.charAt(i) - '0');
	        bitIndex++;

	        if (bitIndex == 8) {
	            result[byteIndex++] = (byte) currentByte;
	            bitIndex = 0;
	            currentByte = 0;
	        }
	    }

	    if (bitIndex > 0) {
	        currentByte = currentByte << (8 - bitIndex);
	        result[byteIndex] = (byte) currentByte;
	    }

	    return result;
	}

	
	
	public static BinaryTreeNode<HuffmanNode> frequencyTree(String str){
		HashMap<Character, Integer> map = frequencyFinder(str);
		Set<Character> key = map.keySet();
		
		HashMap<Integer, Character> mapChar = new HashMap<>();
		PriorityQueue<Integer> pQueue= new PriorityQueue<>();	
		
		for(Character ch:key) { 
			pQueue.add(map.get(ch));
			mapChar.put(map.get(ch), ch);
		}
		
		Queue<BinaryTreeNode<HuffmanNode>> queue = new LinkedList<>();
		Character ch1 , ch2;
		int firstMinPrio, secondMinPrio;
		BinaryTreeNode<HuffmanNode> node1, node2, root;

		while(pQueue.size()-1!=0) {
			firstMinPrio =pQueue.remove();
			secondMinPrio= pQueue.remove();
			ch1= mapChar.remove(firstMinPrio);
			ch2 = mapChar.remove(secondMinPrio);
			
			if(ch1!='N' && ch2!='N') {
				node1 = new BinaryTreeNode<HuffmanNode>(new HuffmanNode(firstMinPrio,ch1));
				node2 = new BinaryTreeNode<HuffmanNode>(new HuffmanNode(secondMinPrio,ch2));
				root  = new BinaryTreeNode<HuffmanNode>(new HuffmanNode(firstMinPrio+ secondMinPrio,'N'));
				root.left=node1;
				root.right=node2;
				queue.add(root);
				pQueue.add(root.data.prio);
				mapChar.put(root.data.prio, 'N');
			}else if(ch1=='N' && ch2!='N') {
				node2 = new BinaryTreeNode<HuffmanNode>(new HuffmanNode(secondMinPrio,ch2));
				root  = new BinaryTreeNode<HuffmanNode>(new HuffmanNode(firstMinPrio+ secondMinPrio,'N'));
				root.left=queue.poll();
				root.right=node2;
				queue.add(root);
				pQueue.add(root.data.prio);
				mapChar.put(root.data.prio, 'N');
			}else if(ch1!='N' && ch2=='N') {
				node1 = new BinaryTreeNode<HuffmanNode>(new HuffmanNode(firstMinPrio,ch1));
				root  = new BinaryTreeNode<HuffmanNode>(new HuffmanNode(firstMinPrio+ secondMinPrio,'N'));
				root.left=queue.poll();
				root.right=node1;
				queue.add(root);
				pQueue.add(root.data.prio);
				mapChar.put(root.data.prio, 'N');
			}else {
				root  = new BinaryTreeNode<HuffmanNode>(new HuffmanNode(firstMinPrio+ secondMinPrio,'N'));
				root.left=queue.poll();
				root.right=queue.poll();
				queue.add(root);
				pQueue.add(root.data.prio);
				mapChar.put(root.data.prio, 'N');
			}
		}
		return queue.poll();
	}


	private static HashMap<Character, Integer> frequencyFinder(String str) {
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(int i=0;i<str.length();i++) {
			if(map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), map.remove(str.charAt(i))+1);
			}else {
				map.put(str.charAt(i), 1);
			}
		}
//		System.out.println(map);
		return map;
	}
	
}

package allQuestions;
import java.util.*;

class BalanceInfo{
	public int height ;
	public boolean isBalanced;
	
	public BalanceInfo() {}
	
	public BalanceInfo(int height , boolean isBalanced) {
		this.height=height;
		this.isBalanced= isBalanced;
	}
}

class BstInfo{
	public int min ;
	public int max;
	public boolean isBst;
	
	public BstInfo() {}
	
	public BstInfo(int min, int max , boolean isBst) {
		this.min=min;
		this.max=max;
		this.isBst= isBst;
	}
}

class DiameterInfo{
	public int height;
	public int diameter;
	
	public DiameterInfo(int height, int diameter) {
		this.height=height;
		this.diameter=diameter;
	}
}

class Pair<T, U> {
	T minimum;
	U maximum;

	public Pair(T minimum, U maximum) {
		this.minimum = minimum;
		this.maximum = maximum;
	}

}

public class BianryTreeUse {

	public static void main(String[] args) {
		
		System.out.println("Enter root data followed by left child and right child");
		
		BinaryTreeNode<Integer> root = binaryTreeInput();
		print(root);

	}
	
	private static BinaryTreeNode<Integer> binaryTreeInput() {
		Scanner s = new Scanner(System.in);
		
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
		int data = s.nextInt();
		
		BinaryTreeNode<Integer> root =null;
		if(data!=-1) {
		root = new BinaryTreeNode<Integer>(data);
		queue.add(root);
		}
		
		while(!queue.isEmpty()) {
			BinaryTreeNode<Integer> node = queue.remove();
			
//			System.out.println("Enter left of "+ node.data);
			BinaryTreeNode<Integer> leftChild =null;
			data= s.nextInt();
			if(data!=-1) {
				leftChild= new BinaryTreeNode<Integer>(data);
       			queue.add(leftChild);
			}
			node.left=leftChild;
			
//			System.out.println("Enter right of "+ node.data);
			BinaryTreeNode<Integer> rightChild =null;
			data= s.nextInt();
			if(data!=-1) {
				rightChild= new BinaryTreeNode<Integer>(data);
			    queue.add(rightChild);
			}
			node.right=rightChild;
			
		}
		return root;
	}

	public static void print(BinaryTreeNode<Integer> root) {
		if(root==null)
			return;
		
		System.out.print(root.data+": ");
		if(root.left!=null)
			System.out.print("L"+root.left.data);
		if(root.left!=null && root.right!=null)
			System.out.print(" , ");
		if(root.right!=null)
			System.out.print("R"+root.right.data);
		System.out.println();
		
		print(root.left);
		print(root.right);
		
	}
	
	public static int height(BinaryTreeNode<Integer> node) {
		if (node == null)
		    return 0;

		return 1 + Math.max(height(node.left), height(node.right));

	}
	
	public static BalanceInfo isBalanced(BinaryTreeNode<Integer> node) {
		if(node==null)
			return new BalanceInfo(0, true);
		
		BalanceInfo leftInfo =  isBalanced(node.left);
		BalanceInfo rightInfo = isBalanced(node.right);
		
		BalanceInfo cur = new BalanceInfo();
		cur.height= Math.max(leftInfo.height, rightInfo.height)+1;
		cur.isBalanced = (Math.abs( (leftInfo.height-rightInfo.height))<=1) &&
				         (leftInfo.isBalanced && rightInfo.isBalanced);
		
		return cur;
	}
	
	public static DiameterInfo diameterBinaryTree(BinaryTreeNode<Integer> node) {
		if(node==null)
			return new DiameterInfo(0,0);
		
		
		 DiameterInfo left = diameterBinaryTree(node.left);
		 DiameterInfo right = diameterBinaryTree(node.right);

	     int height = 1 + Math.max(left.height, right.height);

	     int diameterThroughNode = left.height + right.height + 1;
    	 int maxDiameter = Math.max(diameterThroughNode, Math.max(left.diameter, right.diameter));

		 return new DiameterInfo(height, maxDiameter);
	}
	
	
//	For a given preorder and inorder traversal of a Binary Tree of type integer stored in an array/list, create the binary tree using the given two arrays/lists. You just need to construct the tree and return the root.
//
//			Note: Assume that the Binary Tree contains only unique elements.
	
	public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {
		if(preOrder.length==0)
			return null;
		
		 if(preOrder.length==1){
	        	BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(preOrder[0]);
	            return root;
	        }
	        BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(preOrder[0]);
	        int i=0 , size=0;
	        while(inOrder[i]!=preOrder[0]) {
				i++;
				size++;
			}
	        int sizeInOrderLeft = i;
			int[] inOrderLeftSubTree= new int[sizeInOrderLeft];
			i=0;
			while(inOrder[i]!=preOrder[0]) {
				inOrderLeftSubTree[i]=inOrder[i];
				i++;
			}
			int[] inOrderRightSubTree= new int[preOrder.length-sizeInOrderLeft-1];
			for(int j=i+1;j<inOrder.length;j++) {
				inOrderRightSubTree[j-i-1]= inOrder[j];
			}
			int[] preOrderLeftSubTree= new int[sizeInOrderLeft];
			int k=1;
			for( k=1;k<=i;k++) {
				preOrderLeftSubTree[k-1] = preOrder[k];
			}
			int[] preOrderRightSubTree= new int[preOrder.length-sizeInOrderLeft-1];
			for(int m=k;m<preOrder.length;m++) {
				preOrderRightSubTree[m-k] =preOrder[m];
			}
			root.left =buildTree(preOrderLeftSubTree,inOrderLeftSubTree );
			root.right = buildTree(preOrderRightSubTree,inOrderRightSubTree );
			
			return root;
	}
	
	
	/*For a given a Binary Tree of type integer, find and return the minimum and the maximum data values.

			Return the output as an object of Pair class, which is already created.

			Note:
			All the node data will be unique and hence there will always exist a minimum and maximum node data.*/
	
	public static Pair<Integer, Integer> minAndMax(BinaryTreeNode<Integer> node){
		if(node==null)
			return new Pair<>(Integer.MAX_VALUE, Integer.MIN_VALUE);
		
		Pair<Integer, Integer> leftPair= minAndMax(node.left);
		Pair<Integer, Integer> rightPair= minAndMax(node.right);
		
		int min= Math.min(node.data, Math.min(leftPair.minimum, rightPair.minimum));
		int max = Math.max(node.data, Math.max(leftPair.maximum, rightPair.maximum));
		
		return new Pair<>(min, max);
	}
	
	
	
	public static void nodeSumK(BinaryTreeNode<Integer> node, int sum, int k, ArrayList<Integer> arr) {
	    if (node == null)
	        return;

	    arr.add(node.data); 
	    sum += node.data;

	    if (node.left == null && node.right == null) {
	        if (sum == k) {
	            System.out.println(arr); // Print path only if valid
	        }
	    } else {
	        nodeSumK(node.left, sum, k, arr);
	        nodeSumK(node.right, sum, k, arr);
	    }

	    arr.remove(arr.size() - 1); 
	}
	
	
	public static BstInfo isBst(BinaryTreeNode<Integer> node){
		if(node==null)
			return new BstInfo(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
		
		BstInfo left= isBst(node.left);
		BstInfo right = isBst(node.right);
		
		boolean bst = false;
		if(left.max<node.data && right.min>=node.data && left.isBst && right.isBst)
			bst=true;
		
		if(bst) {
		int min = Math.min(left.min, node.data);
		int max = Math.max(right.max, node.data);
		return new BstInfo(min, max, true);
		}
		
		
		return new BstInfo(Integer.MAX_VALUE, Integer.MIN_VALUE, false);
	}
	
	public static ArrayList<LinkedList<Integer>> levelWiseLL(BinaryTreeNode<Integer> root){
		
		int level = height(root);
		ArrayList<LinkedList<Integer>> arr = new ArrayList<LinkedList<Integer>>();
		for(int i=0;i<=level;i++) {
			LinkedList<Integer> ll = new LinkedList<>();
			levelWiseLLHelper(root, ll, i, 0);
			if(ll!=null)
				arr.add(ll);
		}
		
		return arr;
	}

	private static void levelWiseLLHelper(BinaryTreeNode<Integer> root, LinkedList<Integer> ll,  int k, int curLevel) {
		if(root==null)
			return ;
		
		if(curLevel==k) {
			ll.add(root.data);
			return ;
		}
		levelWiseLLHelper(root.left, ll, k, curLevel+1);
		levelWiseLLHelper(root.right, ll, k, curLevel+1);
	}
	
}












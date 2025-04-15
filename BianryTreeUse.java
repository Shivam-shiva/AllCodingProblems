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

class DiameterInfo{
	public int height;
	public int diameter;
	
	public DiameterInfo(int height, int diameter) {
		this.height=height;
		this.diameter=diameter;
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

}












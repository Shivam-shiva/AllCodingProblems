package allQuestions;

public class BinarySearchTree {
	
	private BinaryTreeNode<Integer> root;
	
	public BinarySearchTree() {
		this.root=null;
	}
	
	public BinaryTreeNode<Integer> getRoot(){
		return root;
	}
	
	public void insert(int data){
		root = insertHelper(root, data);
	}
	
	private BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> node, int data) {
	    if (node == null) {
	        return new BinaryTreeNode<>(data);
	    }

	    if (data < node.data)
	        node.left = insertHelper(node.left, data);
	    else
	        node.right = insertHelper(node.right, data);

	    return node;
	}

	
	public void remove(int data) {

		root = removeHelper(root, data);
	}

	private BinaryTreeNode<Integer> removeHelper(BinaryTreeNode<Integer> node, int data) {
		if(node==null )
			return node;
		
		if(node.data==data) {
			if(node.left==null)
				return node.right;
			
			else {
				BinaryTreeNode<Integer> newNode = maxFinder(node.left);
				node.data=newNode.data;
				node.left= removeHelper(node.left, newNode.data);
				return node;
			}
				
		}
		
		BinaryTreeNode<Integer> newNode;
		if(node.data>data) {
			newNode=removeHelper(node.left,data);
			node.left=newNode;
		}
		else {
			newNode=removeHelper(node.right, data);
			node.right=newNode;
		}
		
        return node;
	}
	
	public int minData() {
		return minFinder(root).data;
	}
	
	public int maxData() {
		return maxFinder(root).data;
	}
	
	public boolean isPresent(int data) {
		return find(root, data)!=null;
	}
	
	private BinaryTreeNode<Integer> find(BinaryTreeNode<Integer> node, int data) {
		if(node==null)
			return node;
		
		if(node.data==data)
			return node;
		else if(node.data>data)
			return find(node.left,data);
		else 
			return find(node.right,data);
		
	}

	private BinaryTreeNode<Integer> minFinder(BinaryTreeNode<Integer> node ){
		if(node==null)
			return node;
		
		if(node.left==null)
			return node;
		
		return minFinder(node.left);
	}
	
	private BinaryTreeNode<Integer> maxFinder(BinaryTreeNode<Integer> node){
		if(node==null)
			return node;
		
		if(node.right==null)
			return node;
		
		return maxFinder(node.right);
	}
	
	public int height() {
		return heightHelper(root)-1;
	}

	private int heightHelper(BinaryTreeNode<Integer> node) {
		if(node==null)
			return 0;
		return 1+ Math.max(heightHelper(node.left), heightHelper(node.right));
	}
	
	public void inOrderTraversal(){
		inOrderTraversalHelper(root); 
	}
	
	public void inOrderTraversalHelper(BinaryTreeNode<Integer> node){
		if(node==null) {
			return;
		}
		
		inOrderTraversalHelper(node.left);
		System.out.print(node.data+" ");
		inOrderTraversalHelper(node.right);
	}
}

package allQuestions;

public class TrieNode {
	
	public Character data;
	public TrieNode[] children;
	public boolean isTerminal;
	
	
	public TrieNode(Character data) {
		this.data= data;
		this.children= new TrieNode[26];
		this.isTerminal=false;
	}

}

package allQuestions;
import java.util.*;

public class Tries {
	
	private TrieNode root;
	
	public Tries() {
		root = new TrieNode('\0');
	}
	
	
	public void insert(String word) {
		if(word.length()==0)
			return;
		
		TrieNode temp = root;
		for(int i=0;i<word.length();i++) {
			Character cur = word.charAt(i);
			if(temp.children[cur-'a']==null) {
			TrieNode newNode = new TrieNode(cur);
			temp.children[cur-'a'] = newNode;
			}
			temp = temp.children[cur-'a'];
		}
		temp.isTerminal=true;
	}
	
	public boolean search(String word) {
		if(word.length()==0)
			return true;
		
		TrieNode temp = root;
		for(int i=0;i<word.length();i++) {
			Character ch = word.charAt(i);
			if(temp.children[ch-'a']==null)
				return false;
			temp = temp.children[ch-'a'];
		}
		
		if(temp.isTerminal)
			return true;
		return false;
	}
	
	public boolean remove(String word) {
		if(word.length()==0)
			return true;
		
		TrieNode temp = root;
		for(int i=0;i<word.length();i++) {
			Character ch = word.charAt(i);
			if(temp.children[ch-'a']==null)
				return false;
			temp = temp.children[ch-'a'];
		}
		temp.isTerminal=false;
		return true;
	}
	
	public void removeRec(String word) {
		removeRecHelper(root,word);
	}


	private boolean removeRecHelper(TrieNode node, String word) {
		if(word.length()==0) {
			node.isTerminal=false;
			boolean info= true;
			for(int i=0;i<node.children.length;i++) {
				if(node.children[i]!=null) {
					info=false;
				}
			}
			return info;
		}
		boolean noMoreWord=false;
		Character ch = word.charAt(0);
		if(node.children[ch-'a']!=null) {
		    noMoreWord = removeRecHelper(node.children[ch-'a'], word.substring(1));
		    if(noMoreWord)
		    	node.children[ch-'a']= null;
		}
		return noMoreWord && !node.isTerminal;
		
	}
	
	
	public void print() {
		for(int i=0;i<26;i++) {
			if(root.children[i]!=null) {
				StringBuffer word= new StringBuffer("");
				printHelper(root.children[i], word, 0);
				System.out.println();
			}
		}	
	}


	private void printHelper(TrieNode node, StringBuffer word, int lastPrintedLength) {
		if(node==null)
			return;
		 word.append(node.data);

		    if (node.isTerminal) {
		        if (lastPrintedLength == 0) {
		            System.out.print(word.toString());
		        } else {
		            System.out.print("->" + word.substring(lastPrintedLength));
		        }
		        lastPrintedLength = word.length(); 
		    }

		    for (int i = 0; i < 26; i++) {
		        if (node.children[i] != null) {
		            printHelper(node.children[i], word, lastPrintedLength);
		        }
		    }

		    word.deleteCharAt(word.length() - 1);
		
	}
	
	

}




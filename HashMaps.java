package allQuestions;
import java.util.*;
public class HashMaps<K,V> {
	
	private ArrayList<MapNode<K,V>> bucket;
	private final int initialSize=20;
	private int count;
	private int bSize;
	private final double loadFactor=0.7;
	
	public HashMaps() {
		bucket = new ArrayList<>();
		for(int i=0;i<initialSize;i++) {
			bucket.add(null);
		}
		this.count =0;
		this.bSize=initialSize;
	
	}
	
	
	public int size() {
		return count;
	}
	
	public void put(K key , V value) {
		if(count>=loadFactor*bSize)
			reSizeBucket(bSize*2);
		
		int index = getIndex(key);
		MapNode<K,V> newNode;

			newNode = bucket.get(index);
			while(newNode!=null) {
				if(newNode.key.equals(key)) {
					newNode.value=value;
					return;
				}
				newNode=newNode.next;
			}
		
		newNode= new  MapNode<>(key,value);
		newNode.next= bucket.get(index);
		bucket.set( index, newNode);
		count++;
	}
	
	public boolean remove(K key) {
		if(bSize>initialSize && bSize*0.35>count)
			reSizeBucket(bSize/2);
		int index= getIndex(key);
		MapNode<K,V> node= bucket.get(index);
		MapNode<K,V> prev= node;
		if(node!=null) {
			while(node!=null) {
				if (node.key.equals(key)){
					if(node==prev) {
						bucket.set(index, node.next);
						count--;
						return true;
					}
					prev.next=node.next;
					count--;
					return true;
				}
				prev=node;
				node= node.next;
			}
		}
		System.out.println("Key with value " + key +" does not exist.");
		return false;
	}
	
	
	
	public V getValue(K key) {
		V  value=getValueHelper(key);
		if(value!=null)
			return value;
		 throw new NullPointerException("Key with value " + key +" does not exist.");
	}
	
	
	public boolean containsKey(K key) {
		int index = getIndex(key);
		MapNode<K,V> node= bucket.get(index);
		if(node!=null) {
			while(node!=null) {
				if(node.key==key)
					return true;
				node= node.next;
			}
		}
		return false;
	}
	
	
	
	private void reSizeBucket(int bucketSize) {
		this.bSize= bucketSize;
		ArrayList<MapNode<K,V>> temp = bucket;
		this.bucket = new ArrayList<>(Collections.nCopies(bucketSize, null));
		for(int i=0;i<temp.size();i++) {
			if(temp.get(i)!=null) {
				MapNode<K,V> node= temp.get(i);
				while(node!=null) {
					put(node.key, node.value);
					node= node.next;
				}
			}else
				bucket.set(i, null);
		}
		
	}
	
	private V getValueHelper(K key) {
			
			int index= getIndex(key);
			MapNode<K,V> node= bucket.get(index);
			
				if(node!=null) {
					while(node!=null) {
						if(node.key==key)
							return node.value;
						node= node.next;
					}
				}
			return null;
		}
		
	
	private int getIndex(K key) {
		return Math.abs(key.hashCode()) % bSize;
	}

}

//-------------------------------------------------------------------------
//Amanda Nguyen 
//amvanguy@ucsc.edu
//CMPS 12B: Tantalo (Summer 2017)
//
//Program #3: The purpose of this assignment is to implement a Dictionary ADT 
//in Java based on the linked list data structure 
//-------------------------------------------------------------------------
// Dictionary.java 
// Implementation of DictionaryInterface.java
// ------------------------------------------------------------------------

public class Dictionary implements DictionaryInterface{

	//Node: private class
	private class Node{
		Node prev; 
		String key;
		String value; 
		Node next; 

		//Node: constructor #1
		//arguments: none 
		Node(){
			key = null;
			value = null;
		}

		//Node: constructor #2
		//arguments: (String key, String value)
		Node(String k, String val){
			key = k;
			value = val;
			next = null;
			prev = null; 
		}
	}

	private Node head; 		//first node in Dictionary LinkedList 
	private int numItems;	//total number of nodes in Dictionary LinkedList 

	//Dictionary: constructor
	//arguments: none 
	public Dictionary(){
		head = null;
		numItems = 0; 
	}

	//private helper functions -----------------------------------------

	//findKey()
	//arguments: none 
	//function: loops goes through Dictionary LinkedList to search for Node at 'key'
	//return: Node with specified key (if found), null (if not found)
	private Node findKey(String key){
		for(Node N = head; N != null; N = N.next){
			if(N.key == key){
				return N; 
			}
		}
		return null; 
	}

	//traverseList()
	//arguments: none 
	//function: traverses through the list and reverses direction of Dictionary 
	//LinkedList by using prev, current, next pointers 
	//return: void
	private void traverseList(){

		Node current = head; 
		Node next = null; 
		Node prev = null;
		
		while(current != null){
			next = current.next;
			current.next = prev; 
			prev = current; 
			current = next; 
			head = prev; 
		}
	}

	// private String myString (Node N){
	// 	if(N == null){
	// 		return "";
	// 	}else{
	// 		return(N.key + " " + N.value + "\n" + myString(N.next));
	// 	}
	// }

	//ADT operations -------------------------------------------------------

	//isEmpty()
	//arguments: none 
	//function: checks if total number of nodes in list is 0  
	//return: true if Dictionary LinkedList empty, false if not
	public boolean isEmpty(){
		return (numItems == 0);
	}

	//size()
	//arguments: none
	//return: numItems, number of nodes in Dictionary LinkedList 
	public int size(){
		return numItems;
	}

	//lookup()
	//function: checks if specific key is in Dictionary LinkedList 
	//arguments: (String key)
	//return: value of node (if found), null (if not found)
	public String lookup(String key){
		if(findKey(key) == null){
			return null;
		}else{
			Node N = findKey(key);
			return N.value; 
		}
	}

	//insert()
	//function: inserts new node to the head of Dictionary LinkedList
	//arguments: (String key, String value)
	//return: void, throws DuplicateKeyException error if key of inserted value
	//is already present within Dictionary LinkedList
	public void insert(String key, String value) throws DuplicateKeyException{
		if(lookup(key) == null){
			Node N = new Node(key, value);
			N.next = head; 
			head = N; 
			numItems++;
		}else{
			throw new DuplicateKeyException(
				"cannot insert dupilicate keys");
		}
	}

	//delete()
	//function: deletes node with specified string by looping through Dictionary
	//LinkedList and having previous Node point to next Node to delete 
	//arguments: (String key)
	//return: void, throws KeyNotFoundException error if key to be deleted 
	//is not found
	public void delete(String key) throws KeyNotFoundException{
		if(lookup(key) != null){
			for(Node N = head; N.next != null; N = N.next){
					if(N.key == key){
						head = N.next; 
						numItems--;
						return;
					}
					while(N.next.key != key){
						N = N.next;
					}
				N.next = N.next.next; 
				numItems--;
				return; 
			}
		}else{
			throw new KeyNotFoundException(
				"cannot delete non-existent key");
		}

			// }else if(N.next.next == null){
			// 	N.next = null; 
		// 	}else if(N.next.key == key){
		// 		for( ; N.next.next != null; N = N.next){
		// 			N.next = N.next.next;
		// 			System.out.println("case 2"); 
		// 		}
		// 	}else if(N.next.next == null){
		// 		N.next = null; 
		// 		System.out.println("case 3");

		// 	}
		// numItems--;
		// System.out.println("subtract one item");
		// }
	}

	//makeEmpty()
	//function: clears all substances in Dictionary LinkedList by setting head
	//to null and numItems to 0
	//arguments: none
	//return: void 
	public void makeEmpty(){
		head = null; 
		numItems = 0; 
	}

	//toString()
	//function: traverses through the Dictionary LinkedList, prints out in order
	//of how Nodes were inserted
	//arguments: none 
	//return: string that consists of key and value 
	public String toString(){
		traverseList(); 

		StringBuffer sb = new StringBuffer();
		for(Node N = head; N != null; N = N.next){
			sb.append(N.key).append(" ").append(N.value).append("\n"); 
		}

		//traverseList();
		return new String(sb);
	}
}

//-------------------------------------------------------------------------
//Amanda Nguyen 
//amvanguy@ucsc.edu
//CMPS 12B: Tantalo (Summer 2017)
//
//Program #4: The purpose of this assignment is to implement a Queue ADT 
//in Java based on the linked list data structure 
//-------------------------------------------------------------------------
// Queue.java 
// Queue ADT
// ------------------------------------------------------------------------

public class Queue implements QueueInterface{

	private class Node{

		Node prev; 
		Object item; 
		Node next; 

		//Node: constructor #1
		//arguments: none 
		Node(){
			item = null;
		}

		//Node: constructor #2
		//arguments: (Object item)
		Node(Object item){
			this.item = item; 
			next = null;
			prev = null; 
		}
	}

	private Node head; 		//first node in Queue LinkedList 
	private int numItems;	//total number of nodes in Queue LinkedList 

	//Queue: constructor
	//arguments: none 
	public Queue(){
		head = null;
		numItems = 0; 
	}


	//ADT operations -------------------------------------------------------

	//isEmpty()
	//arguments: none 
	//function: checks if total number of nodes in list is 0  
	//return: true if Queue LinkedList empty, false if not
	public boolean isEmpty(){
		return (numItems == 0);
	}

	//size()
	//arguments: none
	//return: numItems, number of nodes in Dictionary LinkedList 
	public int length(){
		return numItems;
	}

	public void enqueue(Object newItem){
		Node N;

		if(head == null){
			head = new Node(newItem);
			numItems++;
		}else{
			N = head; 
			while(N.next != null){
				N = N.next;
			}
			N.next = new Node(newItem);
		}
	}

	public Object dequeue() throws QueueEmptyException{
		if (head == null){
			throw new QueueEmptyException(
				"dequeue() error: cannot dequeue on empty queue");
		}else{
			Node N = head; 
			head = N.next;
			numItems--; 
			return N.item; 
		}
	}

	// peek()
  	// pre: !isEmpty()
  	// post: returns item at front of Queue
  	public Object peek() throws QueueEmptyException{
    	if(head == null){
      		throw new QueueEmptyException("peek() error: cannot peek() on empty queue");
    	}else{
        return head.item;
    }
  }


	public void dequeueAll() throws QueueEmptyException{
		if(head == null){
			throw new QueueEmptyException(
				"dequeueAll() error: cannot dequeueAll on empty queue");
		}else{
			head = null;
			numItems = 0; 
		}
	}

	public String toString(){
		String str = "";
		Node N = head; 
		while(N != null){
			str = str + N.item + " ";
			N = N.next;
		}
		return str; 
	}


}
//-------------------------------------------------------------------------
//Amanda Nguyen 
//amvanguy@ucin.edu
//CMPS 12B: Tantalo (Summer 2017)
//
//Program #4: The purpose of this assignment is to implement a Queue ADT 
//in Java based on the linked list data structure 
//-------------------------------------------------------------------------
// QueueTest.java 
// Test client for Queue.java
// ------------------------------------------------------------------------

public class QueueTest{
	public static void main(String[] arg){

		Queue A = new Queue();

		A.enqueue(1);
		A.enqueue(5);
		A.enqueue(4);

		System.out.println("Size: " + A.length());
		System.out.println("A: " + A);

		A.dequeue();

		System.out.println("A dequeue(): " + A);

		System.out.println("Not empty? " + A.isEmpty());

		A.enqueue(2);

		A.dequeue();

		System.out.println("A dequeue(): "  + A);

		System.out.println("Not empty? " + A.isEmpty());
		System.out.println("Size: " + A.length());
		System.out.println("A: "  + A);

		A.enqueue(7);

		System.out.println("Peek: " + A.peek() );

		A.dequeueAll();

		System.out.println("Size: " + A.length());
		System.out.println("A dequeueAll(): "  + A );
	}
}
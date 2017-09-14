//-------------------------------------------------------------------------
//Amanda Nguyen 
//amvanguy@ucsc.edu
//CMPS 12B: Tantalo (Summer 2017)
//
//Program #3: The purpose of this assignment is to implement a Dictionary ADT 
//in Java based on the linked list data structure 
// -----------------------------------------------------------------------------
// DictionaryTest.java
// Test module for testing Dictionary ADT
// -----------------------------------------------------------------------------

public class DictionaryTest{

	public static void main(String[] args){
		String v; 
		Dictionary A = new Dictionary();

		//A.insert("yo", "what's up");
		//A.insert("hi", "bye");

		A.insert("1", "a");
		A.insert("2", "b");
		A.insert("3", "c");
		A.insert("4","d");
		A.insert("5", "e");

		//System.out.println(A.lookup("yo"));

		System.out.println("Size: " + A.size());


		//System.out.println(A.isEmpty());

		System.out.println("String: \n" + A.toString());

		//A.makeEmpty();

		A.delete("1");
		A.delete("2");
		A.delete("5");

		System.out.println("Size: " + A.size());

		//System.out.println(A.isEmpty());

		System.out.println("String: \n" + A.toString());

	}
}

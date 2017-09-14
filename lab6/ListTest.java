//-------------------------------------------------------------------------
//Amanda Nguyen 
//amvanguy@ucsc.edu
//CMPS 12M: Tantalo (Summer 2017)
//
//Lab #6: The purpose of this assignment is to gain experience with an 
//advanced feature in Java called Generics 
//-----------------------------------------------------------------------------
// ListTest.java
// Test File for List ADT using Java Generics
//-----------------------------------------------------------------------------

class ListTest{

      public static void main(String[] args){

            //List<String> stringList = new List<String>();
            List<Double> intList = new List<Double>();

            //System.out.println(stringList.isEmpty()); 
            System.out.println(intList.isEmpty()); 

            // stringList.add(1, "yo");
            // stringList.add(2, "hi");
            // stringList.add(3, "bye");


            intList.add(1, 93.2); 
            intList.add(2, 5.1);
            intList.add(3, 22.7);
      
            System.out.println("Size: " + intList.size()); 
            System.out.println("Test 1: " + intList);

            // System.out.println("Size: " + stringList.size()); 
            // System.out.println("Test 1: " + stringList);

            // stringList.remove(2);
            // stringList.add(2, "hello");

            intList.remove(2);
            intList.add(2, 47.6);

            // System.out.println(stringList.get(3));
            // System.out.println(stringList.isEmpty()); 
            // System.out.println("Test 2: " + stringList);

            System.out.println(intList.get(2));
            System.out.println(intList.isEmpty()); 
            System.out.println("Test 2: " + intList);
            
            // stringList.removeAll();
            // System.out.println("Size: " + stringList.size()); 
            // System.out.println(stringList.isEmpty()); 

            intList.removeAll();
            System.out.println("Size: " + intList.size()); 
            System.out.println(intList.isEmpty()); 

            System.out.println("Test 3: " + intList);

      }
}
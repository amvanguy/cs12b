//-------------------------------------------------------------------------
//Amanda Nguyen 
//amvanguy@ucsc.edu
//CMPS 12B: Tantalo (Summer 2017)
//
//Program #3: The purpose of this assignment is to implement a Dictionary ADT 
//in Java based on the linked list data structure 
//-------------------------------------------------------------------------
// DuplicateKeyException.java
//-----------------------------------------------------------------------------

public class DuplicateKeyException extends RuntimeException{
   public DuplicateKeyException(String s){
      super(s);
   }
}
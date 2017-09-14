//------------------------------------------------------------------------------
//Amanda Nguyen 
//amvanguy@ucsc.edu
//CMPS 12M: Tantalo (Summer 2017)
//
//Lab #7: The purpose of this assignment is to to translate the Binary Search 
//Tree (BST) based Dictionary in C into Java 
// -----------------------------------------------------------------------------
// Dictionary.java
// Implementation of DictionaryInterface.java using BST as underlying structure
// -----------------------------------------------------------------------------

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Dictionary implements DictionaryInterface{

	//Node: private class
	private class Node{
		String key;
		String value; 
		Node left; 
		Node right; 

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
			left = null; 
			right = null;
		}
	}

	private Node root; 		//first node in Dictionary LinkedList 
	private int numPairs;	//total number of nodes in Dictionary LinkedList 

	//Dictionary: constructor
	//arguments: none 
	public Dictionary(){
		root = null;
		numPairs = 0; 
	}

	//private helper functions -----------------------------------------

	//findKey()
	//arguments: none 
	//function: loops goes through Dictionary LinkedList to search for Node at 'key'
	//return: Node with specified key (if found), null (if not found)
	private Node findKey(Node R, String key){
		if(R == null){
			return null;
		}
		if(key.compareTo(R.key) == 0){
			return R;
		}
		if(key.compareTo(R.key) < 0){
			return findKey(R.left, key);
		}else 
			return findKey(R.right, key);
	}

   // findParent()
   // returns the parent of N in the subtree rooted at R, or returns NULL 
   // if N is equal to R. (pre: R != NULL)
	private Node findParent(Node N, Node R){
		Node P = null; 

		if( N != R){
			P = R; 
			while( P.left != N && P.right != N){
				if((N.key).compareTo(P.key) < 0)
					P = P.left;
				else 
					P = P.right;
			}
			return P;
		}else{
			return null;
		}
	}

   // findLeftmost()
   // returns the leftmost Node in the subtree rooted at R, or NULL if R is NULL.
	private Node findLeftmost(Node R){
		Node L = R; 
		if(L != null){
			for( ; L.left != null; L = L.left);
			return L;  
		}else{
			return null;
		}
	}

   // printInOrder()
   // prints the (key, value) pairs belonging to the subtree rooted at R in order
   // of increasing keys to file pointed to by out.
	private void printInOrder(Node R) throws FileNotFoundException{
		File file = new File("out.txt");
		FileOutputStream fos = new FileOutputStream(file);
		PrintStream ps = new PrintStream(fos);
		System.setOut(ps);

		if(R != null){
			printInOrder(R.left);
			//sb.append(R.key).append(" ").append(R.value).append("\n");
         System.out.print(R.key);
			printInOrder(R.right);
		}

		System.setOut(System.out); 
	}

   // toString() -- private 
   //helper function to toString() -- public 
   private String toString(Node root){
      StringBuilder builder = new StringBuilder();
      if (root == null)
         return "";
      builder.append(toString(root.left));
      builder.append(toString(root.right));
      return builder.append(root.value.toString()).append("  ").append(root.key.toString()).append("\n").toString();
   }

   // deleteAll()
   // deletes all Nodes in the subtree rooted at N.
	private void deleteAll(Node N){
		if( N != null){
			deleteAll(N.left);
			deleteAll(N.right);
		}
	}

	
	//public functions ----------------------------------------------

   // isEmpty()
   // pre: none
   // returns true if this Dictionary is empty, false otherwise
	public boolean isEmpty(){
		return (numPairs == 0);
	}

	// size()
   // pre: none
   // returns the number of entries in this Dictionary
   public int size(){
   	return numPairs; 
   }

   // lookup()
   // pre: none
   // returns value associated key, or null reference if no such key exists
   public String lookup(String key){
 	    if(findKey(root, key) == null){
     	   return null;
	     }else{
			   Node N = findKey(root, key);
			   return N.value; 
		 }
   }

   // insert()
   // inserts new (key,value) pair into this Dictionary
   // pre: lookup(key)==null
   public void insert(String key, String value) throws DuplicateKeyException{
   	Node N, A, B; 

   	if(lookup(key) == null){
   		N = new Node(key, value); 
   		B = null; 
   		A = root; 

   		while (A != null){
   			B = A; 
   			if(key.compareTo(A.key) < 0){
   				A = A.left; 
   			}else{
   				A = A.right; 
   			}
   		}
   		if (B == null){
   			root = N; 
   		}else if(key.compareTo(B.key) < 0){
   			B.left = N; 
   		}else{
   			B.right = N; 
   		}
			numPairs++;
		}else{
  			throw new DuplicateKeyException(
				"cannot insert dupilicate keys");
		}
   		 
   }

   // delete()
   // deletes pair with the given key
   // pre: lookup(key)!=null
   public void delete(String key) throws KeyNotFoundException{
   	Node N, P, S; 
   	if(lookup(key) != null){
   		N  = findKey(root, key); 
   		if(N.left == null && N.right == null){
   			if(N == root){
   				root = null; 
   			}else{
   				P = findParent(N, root);
   				if (P.right == N){
   					P.right = null;
   				}else{
   					P.left = null;
   				}
   			}
   		}else if (N.right == null){
   			if (N == root){
   				root = N.left; 
   			}else{
   				P = findParent(N, root);
   				if(P.right == N){
   					P.right = N.left;
   				}else{
   					P.left = N.left; 
   				}
   			}
			}else if (N.left == null){
				if(N == root){
					root = N.right;
				}else{
					P = findParent(N, root);
					if(P.right == N){
						P.right = N.right; 
					}else{
						P.left = N.left; 
					}
				}
			}else{
				S = findLeftmost(N.right);
				N.key = S.key;
				N.value = S.value;
				P = findParent(S, N);
				if(P.right == S){
					P.right = S.right;
				}else{
					P.left = S.right;
				}
			}
			numPairs--; 
		}else{
			throw new KeyNotFoundException(
			"cannot delete non-existent key");
		}
	}

	// makeEmpty()
	// pre: none
	public void makeEmpty(){
		root = null;
		numPairs = 0;
   }
   	
   // toString()
   // returns a String representation of this Dictionary
   // overrides Object's toString() method
   // pre: none
   public String toString(){
      String s = toString(root);
      String reversed = new StringBuilder(s).reverse().append("\n").toString();
      return reversed; 

      // if (root == null){
      //    return "";
      // }
      // String printOut = printInOrder(root);
      // return printOut;
	}
}
//-------------------------------------------------------------------------
//Amanda Nguyen 
//amvanguy@ucsc.edu
//CMPS 12M: Tantalo (Summer 2017)
//
//Lab #5: The purpose of this assignment is to implement a Dictionary ADT 
//in C based on the linked list data structure 
//-------------------------------------------------------------------------
// Dictionary.c
// Implementation of Dictionary ADT 
// ------------------------------------------------------------------------

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <assert.h>
#include "Dictionary.h"

//private types ----------------------------------------------------------------

typedef struct NodeObj{
	char* key;
	char* value; 
	struct NodeObj* next; 
} NodeObj; 

typedef NodeObj* Node; 

Node newNode(char* k, char* v){
	Node N = malloc(sizeof(NodeObj));
	assert(N != NULL);
	N->key = k;
	N->value = v;
	N->next = NULL;
	return N; 
}

void freeNode(Node* pN){
	if(pN != NULL && *pN != NULL){
		free(*pN);
		*pN = NULL; 
	}
}

//DictionaryObj constructor 
typedef struct DictionaryObj{
	Node top;
	Node bottom;
	int numItems; 
} DictionaryObj; 

//private helper functions ---------------------------------------------------

//findKey()
//arguments: (Dictionary D) (char* k) 
//function: loops goes through Dictionary LinkedList to search for Node at 'key'
//return: Node with specified key (if found), null (if not found)
Node findKey(Dictionary D, char* k){
	Node N; 

	for(N = D->top; N != NULL; N = N->next){
    	if (strcmp(N->key, k) == 0){
        	return N; 
      }
	}
	return NULL; 
}

//traverseList()
//arguments: (Dictionary D) 
//function: traverses through the list and reverses direction of Dictionary 
//LinkedList by using prev, current, next pointers 
//return: void
void traverseList(Dictionary D){
	Node current = D->top;
	Node next = NULL;
	Node prev = NULL;

	while(current != NULL){
		next = current->next;
		current->next = prev; 
		prev = current;
		current = next;
		D->top = prev;
	}
}

//public functions -------------------------------------------------------

// newDictionary()
// constructor for the Dictionary type
Dictionary newDictionary(void){
	Dictionary D = malloc(sizeof(DictionaryObj));
	assert(D != NULL);
	D->top = NULL;
	D->numItems = 0;
	return D;
}

// freeDictionary()
// destructor for the Dictionary type
void freeDictionary(Dictionary* pD){
	if(pD != NULL && *pD != NULL){
		if( !isEmpty(*pD) ){
			makeEmpty(*pD); 
		}
		free(*pD);
		*pD = NULL; 
	}
}

// isEmpty()
// returns 1 (true) if S is empty, 0 (false) otherwise
// pre: none
int isEmpty(Dictionary D){
	// if(D == NULL){
	// 	fprintf(stderr, 
	// 		"Dictionary Error: calling isEmpty() on NULL Dictionary reference\n");
	// 	exit(EXIT_FAILURE);
	// }
	return (D->numItems == 0); 
}

// size()
// returns the number of (key, value) pairs in D
// pre: none
int size(Dictionary D){
	return D->numItems; 
}

// lookup()
// returns the value v such that (k, v) is in D, or returns NULL if no 
// such value v exists.
// pre: none
char* lookup(Dictionary D, char* k){
	Node N;

	if(D == NULL){
      fprintf(stderr, 
              "Dictionary Error: calling lookup() on NULL Dictionary reference\n");
      exit(EXIT_FAILURE);
    }

    if(findKey(D, k) == NULL){
    	return NULL;
    }else{
    	N = findKey(D, k);
    	return N->value;
    	
    }
   return NULL; 
}

// insert()
// inserts new (key,value) pair into D
// pre: lookup(D, k)==NULL
void insert(Dictionary D, char* k, char* v){
	Node N; 

	if(lookup(D, k) == NULL){
		N = newNode(k, v);
		N->next = D->top; 
		D->top = N; 
		D->numItems++; 
		//Node temp = N; 
		return; 
	}else{
		fprintf(stderr, "Dictionary Error: calling insert() on NULL Dictionary reference\n");
    	exit(EXIT_FAILURE);
	}
}

// delete()
// deletes pair with the key k
// pre: lookup(D, k)!=NULL
void delete(Dictionary D, char* k){
	
	Node N;  

  	if(lookup(D, k) != NULL){
  		N = D->top;
  		//printf("%s -- %s\n", N->key, k);
  		if(strcmp(N->key, k) == 0){
  			//Node temp = D->top;
  			D->top = D->top->next;
  			freeNode(&N);
  			//freeNode(&D->top);
  			D->numItems--;
  			return; 
  		}
  		while(N->next != NULL){
  			//printf("%s -- %s\n", N->key, k);
  			if(strcmp(N->next->key, k) == 0){
  				Node temp = N->next;
  				N->next = N->next->next; 
  				freeNode(&temp);
  				D->numItems--; 
  				return;
  			}else{
  				N = N->next;
  			}
  		}
  	}else{
  		fprintf(stderr, "Dictionary Error: calling delete() on Dictionary reference not present\n");
  		exit(EXIT_FAILURE); 
  	} 

//	for(N = D->top; N-> != NULL; N = N->next){
 //if(strcmp(N->key, k) == 0){
 //  				printf("fam 2");
 // // 				Node temp = D->top; 
 // // 				D->top = N->next;
 // // 				D->numItems--; 
 // // 				freeNode(&temp);
 // // 				return;
 // 			}
 //  	//		while(N->next->key != NULL){
 //  				printf("yo");
 // // 				N = N->next;
 //  //			}

 // // 			printf("fam3");
 // // 			Node temp = N->next;
 // // 			N->next = N->next->next; 
 // // 			D->numItems--;
 // // 			freeNode(&temp); 
 // // 			return;
 // // 		}
 // 	}else{
 // 		printf("error" );
 // 		return;
 	
}

// makeEmpty()
// re-sets D to the empty state.
// pre: none
void makeEmpty(Dictionary D){

	if(D == NULL){
		fprintf(stderr, 
			"Dictionary Error: calling makeEmpty() on NULL Dictionary reference");
		exit(EXIT_FAILURE);
	}

	if( D->numItems == 0){
		fprintf(stderr, 
			"Dictionary Error: calling makeEmpty() on empty Dictionary");
		exit(EXIT_FAILURE);
	}

	//Dictionary temp = D; 
	D->top = NULL;
	D->numItems = 0;
	//freeDictionary(&D);

	// while(D->numItems > 0){
	// 	delete(D);
	// }

	// if( pS != NULL && *pS != NULL){
	// 	Node N = (*pS)->top; 
 //     	Node temp;
 //    	while(N != NULL){
 //    		temp = N->next;
 //      		freeNode(&N);
 //      		N = temp; 
 //    	}
    
 //    	freeNode(&N);
 //    	free(*pS);
 //    	*pS = NULL;
 //   }
 //   return; 
}

// printDictionary()
// pre: none
// prints a text representation of D to the file pointed to by out
void printDictionary(FILE *out, Dictionary D){
	Node N;

   	if(D == NULL){
      fprintf(stderr, 
              "Dictionary Error: calling printDictionary() on NULL Dictionary reference\n");
      exit(EXIT_FAILURE);
   	}

   	traverseList(D);

   	for(N = D->top; N!=NULL; N=N->next){
        fprintf(out, "%s %s\n", N->key, N->value);
   	}

   	traverseList(D);
   	//freeNode(&N);
   	return; 
}

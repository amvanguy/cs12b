//------------------------------------------------------------------------------
//Amanda Nguyen 
//amvanguy@ucsc.edu
//CMPS 12B: Tantalo (Summer 2017)
//
//Lab #7: The purpose of this assignment is to recreate the Dictionary ADT in C 
// based on a hash table instead of a linked list
// -----------------------------------------------------------------------------
// DictionaryTest.c
// Test module for Dictionary.c
// -----------------------------------------------------------------------------

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "Dictionary.h"

int main(int argc, char* argv[]){
	
	Dictionary A = newDictionary();

	insert(A, "1", "a");
	insert(A, "2", "b");
	insert(A, "3", "c");
	insert(A, "4","d");
	insert(A, "5", "e");


	printf("yo, it ran\n");

	printf("Size: %d\n", size(A));

	//printf("first delete\n");

	printDictionary(stdout, A);

	delete(A, "1");
	delete(A, "3");
	delete(A, "5"); 

	//makeEmpty(A);

	printf("Size: %d\n", size(A));

	printDictionary(stdout, A);
}

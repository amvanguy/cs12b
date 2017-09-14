/*-------------------------------------------------------------------------
 *Amanda Nguyen 
 *amvanguy@ucsc.edu
 *CMPS 12M: Tantalo (Summer 2017)
 *
 *Lab #3: The purpose of this assignment is to  introduce the C programming 
 *language, including standard input-output functions, command line arguments, 
 *File IO, and compilation with Makefiles.
 *------------------------------------------------------------------------
 * hello.c 
 * Prints "Hello World!" to stdout
 *------------------------------------------------------------------------
 */

#include <stdio.h>
#include <stdlib.h>
#define HELLO_STRING "Hello World!\n"

int main(){
	printf(HELLO_STRING);
 	return EXIT_SUCCESS;
}

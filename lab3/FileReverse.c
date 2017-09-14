/*-------------------------------------------------------------------------
 *Amanda Nguyen 
 *amvanguy@ucsc.edu
 *CMPS 12M: Tantalo (Summer 2017)
 *
 *Lab #3: The purpose of this assignment is to  introduce the C programming 
 *language, including standard input-output functions, command line arguments, 
 *File IO, and compilation with Makefiles.
 *------------------------------------------------------------------------
 * FileReverse.c
 * Take two command line arguments naming the input and output files
 * respectively, read each word in the input file, then
 * print it backwards on a line by itself.
 *------------------------------------------------------------------------
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/*reverse function, swaps letters within word until reversed*/
void stringReverse (char *s){

	if(s == 0 || *s == 0){
		return;
	}

	char *i = s;
    char *j = i + strlen(s) - 1;
    char temp; 

    while(i < j){
    	temp = *i;
    	*i = *j;
    	*j = temp;

    	i++;
    	j--;
 	}
}

int main(int argc, char* argv[]){

	/*declarations of variables*/
	FILE* in;   
	FILE* out; 
	char word[256]; /*allocation of 256 bits for input file*/
	size_t strlen(const char *str);

   /* check command line for correct number of arguments */
   if( argc != 3 ){
      printf("Usage: %s <input file> <output file>\n", argv[0]);
      exit(EXIT_FAILURE);
   }

   /* open input file for reading */
   in = fopen(argv[1], "r");

   if(in == NULL){
      printf("Unable to read from file %s\n", argv[1]);
      exit(EXIT_FAILURE);
   }

   /* open output file for writing */
   out = fopen(argv[2], "w");

   if(out == NULL){
      printf("Unable to write to file %s\n", argv[2]);
      exit(EXIT_FAILURE);
   }

   /* read words from input file, print on separate lines to output file*/
   while( fscanf(in, " %s", word) != EOF){
   		stringReverse(word); 
    	fprintf(out, "%s\n", word);
   }

   /* close input and output files */
   fclose(in);
   fclose(out);

   return(EXIT_SUCCESS);
}
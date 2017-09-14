//-------------------------------------------------------------------------
//Amanda Nguyen 
//amvanguy@ucsc.edu
//CMPS 12M: Tantalo (Summer 2017)
//
//Lab #4: The purpose of this assignment is to  get more practice programming 
//in C, including the character functions in the library ctype.h, and dynamic 
//memory allocation using malloc, calloc, and free
//-------------------------------------------------------------------------
// charType.c  
// Implementation of DictionaryInterface.java
// ------------------------------------------------------------------------

#include	<stdio.h>
#include	<stdlib.h>
#include	<ctype.h>
#include 	<string.h>
#include	<assert.h>

#define MAX_STRING_LENGTH 100

//function prototype 
void extract_chars(char* s, char* a, char* d, char* p, char* w);


//extract_chars()
//arguments: (char* s, char* a, char*d, char* p, char* w)
//function: while line reached the null character, evaluate each character as--
//alphabetic char -> a, numeric char -> d
//punctation char -> p, whitespace char -> w
//return: void, changes the contents of a, d, p, w
void extract_chars(char* s, char* a, char* d, char* p, char* w){
	int i = 0;
	int a_count = 0;
	int d_count = 0;  
	int p_count = 0; 
	int w_count = 0; 


	while(s[i] != '\0' && i < MAX_STRING_LENGTH){

		if(isalpha (s[i]) ){
			a[a_count] = s[i];
			a_count++; 
			i++; 
		}

		if(isdigit (s[i]) ){
			d[d_count] = s[i]; 
			d_count++;
			i++; 
		}

		if(ispunct (s[i]) ){
			p[p_count] = s[i];
			p_count++;
			i++; 
		}

		if(isspace (s[i]) ){
			w[w_count] = s[i];
			w_count++;
			i++; 
		}
	}

	//insert null character at the end to define as strings 
	a[a_count] = '\0';
	d[d_count] = '\0';
	p[p_count] = '\0';
	w[w_count] = '\0'; 
}

// function main which takes command line arguments 
int main(int argc, char* argv[]){

	FILE* in;                          
   	FILE* out;                       
   	char* line;     //string holding each input line              
   	char* a; 		//string holding all alphabetic characters of 'line'
   	char* d;		//string holding all numeric characters of 'line'
   	char* p; 		//string holding all punctuation characters of 'line'
   	char* w; 		//string holding all whitespace characters of 'line'

   	//error-handling -------------------------------------------------

   	//check command line for correct number of arguments 
   	if( argc != 3 ){
      printf("Usage: %s input-file output-file\n", argv[0]);
      exit(EXIT_FAILURE);
   	}

  	//open input file for reading 
   	if((in = fopen(argv[1], "r")) == NULL ){
      	printf("Unable to read from file %s\n", argv[1]);
      	exit(EXIT_FAILURE);
   	}

   	//open output file for writing
   	if((out = fopen(argv[2], "w")) == NULL ){
      	printf("Unable to write to file %s\n", argv[2]);
      	exit(EXIT_FAILURE);
   	}

   	//------------------------------------------------------------

   	//allocate all strings 
   	line = calloc(MAX_STRING_LENGTH, sizeof(char));
   	a = calloc(MAX_STRING_LENGTH, sizeof(char));
   	d = calloc(MAX_STRING_LENGTH, sizeof(char));
   	p = calloc(MAX_STRING_LENGTH, sizeof(char));
   	w = calloc(MAX_STRING_LENGTH, sizeof(char));

   	int lineCount = 1; 

   	//account for if calloc cannot find free blocks of memory
   	assert(line != NULL && a != NULL && d != NULL && p != NULL && w != NULL);
  
   	//read each line in input file
   	//determine whether the new strings a, d, p, w have multiple characters or not
   	//call extract_chars()
   	//print out results to output file 
   	while( fgets(line, MAX_STRING_LENGTH, in) != NULL ){

   		char* charac_a;
   		char* charac_d;
   		char* charac_p;
   		char* charac_w;

   		char singular[] = "character";
   		char plural[] = "characters";

      	extract_chars(line, a, d, p, w);

      	if((int) strlen(a) == 1){
   			charac_a = singular; 
   		}else{
   			charac_a = plural;
   		}

   		if((int) strlen(d) == 1){
   			charac_d = singular; 
   		}else{
   			charac_d = plural; 
   		}

   		if((int) strlen(p) == 1){
   			charac_p = singular; 
   		}else{
   			charac_p = plural; 
   		}

   		if((int) strlen(w) == 1){
   			charac_w = singular; 
   		}else{
   			charac_w = plural; 
   		}

      	fprintf(out, "line %d contains\n", lineCount);
      	fprintf(out, "%d alphabetic %s: %s\n", (int) strlen(a), charac_a, a);
      	fprintf(out, "%d numeric %s: %s\n", (int) strlen(d), charac_d, d);
      	fprintf(out, "%d punctuation %s: %s\n", (int) strlen(p), charac_p, p);
      	fprintf(out, "%d whitespace %s: %s\n", (int) strlen(w), charac_w, w);

      	lineCount++; 
   	}

   	//free all heap memory 
   	free(line);
   	free(a);
   	free(d);
   	free(p);
   	free(w);

   	//close input and output files 
   	fclose(in);
   	fclose(out);

   	return EXIT_SUCCESS;
   
}


int search(char* S, char c){
 // your code goes here
 int i=0;

 while( S[i]!=’\0’ ){
 if( S[i]==c ) break;
 i++;
 }
 if( S[i]==’\0’ ) return -1;
 else return i;
}

char* diff (char* A, char* B){
	int i = 0;
	int count; 
	while(i != '\0'){
		if (search(A[i], B[i]) > -1){
			i++;
			count++; 
		}else{
			int diffCount = 0
			char* diffString = calloc(strlen(A), sizeof(char));
			diffString[diffCount] = A[i]; 
			diffCount++; 
		} 
	}
	diffString[diffCount] = '\0';
	return diffString; 
}

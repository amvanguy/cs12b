//-------------------------------------------------------------------------
//Amanda Nguyen 
//amvanguy@ucsc.edu
//CMPS 12B: Tantalo (Summer 2017)
//
//Program #2: The purpose of this assignment is to practice using command line 
//arguments, file input-output, and manipulation of Strings in java
//-------------------------------------------------------------------------
// Search.java 
// 
// ------------------------------------------------------------------------

import java.io.*;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class Search{

	public static void main(String[] args) throws IOException{

		Scanner file1, file2 = null;
		int lineCount = 0;
		String line; 
		String[] targetWord = new String[args.length-1];
		String[] toBeSearched = null;
		
		// check number of command line arguments is at least 2, print usage message
		
		file1 = new Scanner(new File(args[0]));	//input file from command prompt 
		file2 = new Scanner(new File(args[0]));	//copy of file1

		if(args.length < 2){
 			System.out.println("Usage: Search file <target1> <target2> <target3> ...");
 			System.exit(1);
		}else if(args.length > 2){				//set arguments into targetWord array 
			for(int i = 1; i < args.length; i++){
				targetWord[i-1] = args[i];
			}
		}else if(args.length == 2){
			targetWord[0] = args[1];
		}

		// System.out.println("this is args length " + args.length + " and this is targetWords length " + targetWord.length);
		// for(int i=0; i<targetWord.length; i++){
		// System.out.print(targetWord[i] + " " );
		//}


		//takes input file and counts number of lines in file
		while(file1.hasNextLine()){
			//line = file1.nextLine().trim();
			//toBeSearched[lineCount] = line;
			//System.out.print(line + " " );
			//toBeSearched = line.split("s\\+");
			lineCount++;
			file1.nextLine(); 
		}

		//initializes string arra
		toBeSearched = new String[lineCount];

		//places each line string into each index of array 
		for(int i = 0; i < lineCount; i++){
			line = file2.nextLine();
			toBeSearched[i] = line;  
		}


		// for(int i = 0; i < toBeSearched.length; i++){
		// 	System.out.println(toBeSearched[i]);
		// }

		int[] lineNumber = new int[toBeSearched.length];
		for(int i = 0; i<lineNumber.length; i++){
			lineNumber[i] = i;
		}

		mergeSort(toBeSearched, lineNumber, 0, toBeSearched.length-1);
		// for(int i = 0; i < toBeSearched.length; i++){
		// 	System.out.println(toBeSearched[i]);
		// }

		for(int i = 0; i < targetWord.length; i++){
			int k = binarySearch(toBeSearched, 0, toBeSearched.length-1, targetWord[i]);
			if(k == -1){
				//System.out.println("lol");
				System.out.println(targetWord[i] + " not found");
			}else{ 
				//System.out.println("boop");
				int l = lineNumber[k] + 1;	
				System.out.println(targetWord[i]+ " found on line " + l);
			}
		}

		// for(int i = 0; i < toBeSearched.length; i++){
		// 	System.out.print(toBeSearched[i] + " ");
		// 	System.out.print(lineNumber[i] + " ");
		// 	System.out.println();

		// }	
		// int k = binarySearch(toBeSearched, 0, toBeSearched.length-1, "dictionary");
		// int l = lineNumber[k] + 1;
		// System.out.println(toBeSearched[k] + " in line " + l);	


	}

	static void mergeSort(String[] word, int[] lineNumber, int p, int r){

		int q; 
		if (p < r){
			q = (p+r)/2;
			mergeSort(word, lineNumber, p, q);
			mergeSort(word, lineNumber, q+1, r);
			merge(word, lineNumber, p, q, r);
		}
	}

	static void merge(String[] word, int[] lineNumber, int p, int q, int r){

		int count1 = q-p+1; 
		int count2 = r-q; 

		String[] left = new String[count1];
		String[] right = new String[count2];
		int[] leftCount = new int[count1];
		int[] rightCount = new int[count2];

		int i, j, k;

		for(i=0; i<count1; i++){
			left[i] = word[p+i];
			leftCount[i] = lineNumber[p+i];
		}

		for(j=0; j<count2; j++){
			right[j] =word[q+j+1];
			rightCount[j] = lineNumber[q+j+1]; 
		}

		i=0; j=0;

		for(k=p; k<=r; k++){
			if(i<count1 && j<count2){
				if(left[i].compareTo(right[j]) < 0){
					word[k] = left[i];
					lineNumber[k] = leftCount[i];
					i++;
				}
				else{
					word[k] = right[j];
					lineNumber[k] = rightCount[j];
					j++;
				}
			}
			else if(i<count1){
				word[k] = left[i];
				lineNumber[k] = leftCount[i];
				i++;
			}
			else{
				word[k] = right[j];
				lineNumber[k] = rightCount[j];
				j++;
			}
		}
	}

	static int binarySearch (String[] word, int p, int r, String target){
		int q; 
		if(p >= r){
			if(target.compareTo(word[r]) == 0){
				return r;
			}else{
				return -1; 
			}
		}else{
			q = (p+r)/2;
			if(target.compareTo(word[q]) == 0){
				return q; 
			}else if(target.compareTo(word[q]) > 0){
				//System.out.println("target= " + target + " word[q]= " + word[q]);
				return binarySearch(word, q+1, r, target);
			}else{
				return binarySearch(word, p, q, target);
			}
		}
	}



}
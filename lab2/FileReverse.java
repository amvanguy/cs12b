//-------------------------------------------------------------------------
//Amanda Nguyen 
//amvanguy@ucsc.edu
//CMPS 12M: Tantalo (Summer 2017)
//
//Lab #2: The purpose of this assignment is to practice using command line 
//arguments, file input-output, and manipulation of Strings in java
//-------------------------------------------------------------------------
// FileReverse.java 
// Takes two command line arguments giving the names of the input and output files respectively
// ------------------------------------------------------------------------

import java.io.*;
import java.util.Scanner;
import java.io.FileNotFoundException;

class FileReverse{

	public static void main(String[] args) throws IOException{

 		Scanner in = null;
 		PrintWriter out = null;
 		String line = null;
 		String[] token = null; 
 		int lineCount = 0;

 		// check number of command line arguments is at least 2, print usage message
 		if(args.length < 2){
 			System.out.println("Usage: FileCopy <input file> <output file>");
 			System.exit(1);
 		}
 
 		//first argument = input file, second argument, output file
 		in = new Scanner(new File(args[0]));
 		out = new PrintWriter(new FileWriter(args[1]));
 
 		// read lines from in, write lines to out
 		while(in.hasNextLine()){	//if file has next line
 			lineCount++; 
	         
	        // trim leading and trailing spaces of orig. line, 
	        // then add one trailing space so split works on blank lines

	        line = in.nextLine().trim() + " "; 


	        //split line around white space, puts each token into array 
	        token = line.split("\\s+");

	        for(int i = 0; i < token.length; i++){
	        	String reversed = stringReverse(token[i], token[i].length());
	        	out.println(reversed);
	        	// token[i] = reversed;
	        	// out.println(token[i]);
	        }
 		}
 
 		System.out.println(lineCount);
 		//close files
 		in.close();
 		out.close();
 	}

 	//'stringReverse' function reverses strings using recursion 
 	public static String stringReverse(String s, int n){

 		if(n > 0){
 			return (s.charAt(n-1) + stringReverse(s, n-1));
 		}else{
 			return " ";
 		}
 	}
}
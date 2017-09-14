//Amanda Nguyen
//CMPS 12B (Summer 2017) - P. Tantalo
//June 27th, 2017 

// FileCopy.java
// Illustrates file IO

import java.io.*;
import java.util.Scanner;


class FileCopy{

	public static void main(String[] args) throws IOException{

 		Scanner in = null;
 		PrintWriter out = null;
 		String line = null;
 		int n;

 		// check number of command line arguments is at least 2, print usage message
 		if(args.length < 2){
 			System.out.println("Usage: FileCopy <input file> <output file>");
 			System.exit(1);
 		}
 
 		//first argument = input file, second argument, output file
 		in = new Scanner(new File(args[0]));
 		out = new PrintWriter(new FileWriter(args[1]));
 
 		// read lines from in, write lines to out
 		while( in.hasNextLine() ){	//if file has next line
 			line = in.nextLine();  //line = current line
 			out.println(line);	//prints out current line
 		}
 
 		//close files
 		in.close();
 		out.close();
 	}
}
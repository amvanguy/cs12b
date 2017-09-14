//Amanda Nguyen
//CMPS 12B (Summer 2017) - P. Tantalo
//June 27th, 2017 

// CommandLineArguments.java

class CommandLineArguments{

	public static void main(String[] args){
		
 		int n = args.length;
 		System.out.println("args.length = " + n);
 		for(int i=0; i<n; i++) System.out.println(args[i]);
 	}
}
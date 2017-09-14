//-------------------------------------------------------------------------
//Amanda Nguyen 
//amvanguy@ucsc.edu
//CMPS 12M: Tantalo (Summer 2017)
//
//Lab #1: The purpose of this assignment is to
//(1)get a basic introduction to the Andrew File System(AFS)
//(2)learn how to create an executable jar file containing a
//Java program
//(3) learn to automate compilation and other tasks using Makefiles.
//-------------------------------------------------------------------------
// HelloUser.java 
// Prints greeting to stdout, then prints some environment information.
// ------------------------------------------------------------------------
class HelloUser{
 public static void main( String[] args ){
 	String userName = System.getProperty("user.name");
	String os = System.getProperty("os.name");
 	String osVer = System.getProperty("os.version");
 	String jre = System.getProperty("java.runtime.name");
 	String jreVer = System.getProperty("java.runtime.version");
 	String jvm = System.getProperty("java.vm.name");
 	String jvmVer = System.getProperty("java.vm.version");
 	String javaHome = System.getProperty("java.home");
 	long freemem = Runtime.getRuntime().freeMemory();
 	long time = System.currentTimeMillis();
 
	System.out.println("Hello "+userName);
 	System.out.println("Operating system: "+os+" "+osVer);
 	System.out.println("Runtime environment: "+jre+" "+jreVer);
 	System.out.println("Virtual machine: "+jvm+" "+jvmVer);
 	System.out.println("Java home directory: "+javaHome);
 	System.out.println("Free memory: "+freemem+" bytes");
 	System.out.printf("Time: %tc.%n", time);
 	
	}
}


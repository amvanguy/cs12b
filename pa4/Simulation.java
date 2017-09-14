//-------------------------------------------------------------------------
//Amanda Nguyen 
//amvanguy@ucin.edu
//CMPS 12B: Tantalo (Summer 2017)
//
//Program #4: The purpose of this assignment is to implement a Queue ADT 
//in Java based on the linked list data structure 
//-------------------------------------------------------------------------
// Simulation.java 
// ------------------------------------------------------------------------

import java.io.*;
import java.util.Scanner;

public class Simulation{
	//method to calling Object Job
	public static Job getJob(Scanner in){
    	String[] s = in.nextLine().split(" ");
    	int a = Integer.parseInt(s[0]);
    	int b = Integer.parseInt(s[1]);
     	return new Job(a,b);
   }
   
   	//method to sorting queue array
   	public static void sort(int[] time){
      	for(int k = time.length-1; k>0;k--){
         	for(int j = 1; j<=k; j++){
            	if(time[j]<time[j-1]){
               		int temp = time[j];
               		time[j] = time[j-1];
               		time[j-1] = temp;
            }
         }
      }
   }

	public static void main(String[] args) throws IOException{

		Scanner sc = new Scanner(new File( args[0]) );
		PrintWriter report = new PrintWriter( new FileWriter(args[0] + ".rpt") );
		PrintWriter trace = new PrintWriter( new FileWriter(args[0] + ".trc") );
		int totalWait;
		int maxWait;
		double avgWait;
		Queue storQueue = new Queue();

		if( args.length != 1 ){
			System.err.println("Usage: Simulation <input file>");
			System.exit(1);
		}

		//get number of jobs
		String numJobs = sc.nextLine();
		int m = Integer.parseInt(numJobs);

    	while(sc.hasNext()){
        	storQueue.enqueue((Job)getJob(sc));
    	}


		//heading for trace and report files
		trace.println("Trace file: " + args[0] + ".trc");
		trace.println(m + " Jobs:");
		trace.println(storQueue + "\n");
		report.println("Report file: " + args[0] + ".rpt");
		report.println(numJobs + " Jobs:");
		report.println(storQueue);
		report.println("******************************************************");

		//main loop that runs range of processors from 1 to m-1
		for(int n = 1; n < m; n++){
			totalWait = 0;
			maxWait = 0;
			avgWait = 0.0; 
			int time = 0; 

			Queue[] proQueue = new Queue[n+1];
			for(int i=0; i <= n; i++)
				proQueue[i] = new Queue();

			//copy storQueue into array[0]

			for( int i=0; i < m; i++ ){
				Job j = (Job) storQueue.dequeue();
				j.resetFinishTime();
				proQueue[0].enqueue(j);
				storQueue.enqueue(j);

			}

			trace.println("******************************************************");
       		//singular vs plural proccessor
       		if(n == 1){
         		trace.println(n + " processor:");
       		}else{
         		trace.println(n + " processors:");
       		}
			trace.println("******************************************************");

			while(proQueue[0].isEmpty() || proQueue[0].length() != m || ((Job) proQueue[0].peek()).getFinish() == -1){
				int[] t = new int[proQueue.length];
				if(time == 0){
					trace.println("time=0");
					for(int i = 0; i <= n; i++)
						trace.println(i + ": " + proQueue[i]);
				}
				trace.println();

				//calculates the processing time
				if( time==0 && !proQueue[0].isEmpty() ){
					time = ((Job) proQueue[0].peek()).getArrival();
				}
				else if( !proQueue[0].isEmpty() ){
					Job k = (Job) proQueue[0].peek();
					if( k.getFinish() == -1 )
						t[0] = k.getArrival();
				}

				for( int i = 1; i < proQueue.length; i++ ){
					if( !proQueue[i].isEmpty() )
						t[i] = ( (Job) proQueue[i].peek() ).getFinish();
				}

				sort(t);

				for( int i=0; i<t.length; i++ ){
					if( t[i] != 0 ){
						time = t[i];
						break;
					}
				}//

				//after calculation of finish time, store within rest of array 
				for( int i=1; i<=n; i++ ){
					if( !proQueue[i].isEmpty() && ( (Job)proQueue[i].peek() ).getFinish() == time ){
						proQueue[0].enqueue( proQueue[i].dequeue() );
						if( proQueue[i].length()>0 && ( (Job)proQueue[i].peek() ).getFinish() == -1 ){
							( (Job)proQueue[i].peek() ).computeFinishTime(time);
						}
					}
				}//

				//process jobs
				if( proQueue.length-1==1 && !proQueue[0].isEmpty() && ( (Job)proQueue[0].peek() ).getArrival() == time )
					proQueue[1].enqueue(proQueue[0].dequeue());
				else{
					if( !proQueue[0].isEmpty() && ( (Job)proQueue[0].peek() ).getArrival() == time ){
						int[] length = new int[proQueue.length-1];
						for( int i=0; i<length.length; i++ )
							length[i] = proQueue[i+1].length();
						int index = 0;
						int min = length[0];
						for( int i=1; i<length.length; i++ ){
							if( length[i] < min ){
								min = length[i];
								index = i;
							}
						}
						proQueue[index+1].enqueue(proQueue[0].dequeue());
					}
				}
				for( int i=1; i<proQueue.length; i++ ){
					if( !proQueue[i].isEmpty() && ( (Job)proQueue[i].peek() ).getFinish() == -1 )
						((Job)proQueue[i].peek()).computeFinishTime(time);
				}//

				//print out job processes
				trace.println("time=" + time);
				for( int i=0; i<=n; i++ ){
					trace.println(i + ": " + proQueue[i] );
				}//

			}
			//calculate aveverage and total time
			totalWait = 0;
			int[] allTimes = new int[proQueue[0].length()];
			for(int i = 0; i < allTimes.length; i++){
				allTimes[i] = ( (Job)proQueue[0].peek() ).getWaitTime();
				totalWait = totalWait + allTimes[i];
				proQueue[0].enqueue( proQueue[0].dequeue() );
			}
			sort(allTimes);
			maxWait = allTimes[allTimes.length-1];
			avgWait = (double)totalWait/(double)allTimes.length;

			//print to report file
			report.println(n==1? n + " processor: " : n + " processors: " );
			report.println("totalWait=" + totalWait + ", maxWait=" + maxWait + ", averageWait=" + avgWait );
		}

		trace.close();
		report.close();
		sc.close();

	}

}
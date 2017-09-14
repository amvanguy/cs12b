//Amanda Nguyen
//CMPS 12B (Summer 2017) - P. Tantalo
//June 27th, 2017 

public class Recursion{

	//given main code 
	public static void main(String[] args){
		int[] A = {-1, 2, 6, 12, 9, 2, -5, -2, 8, 5, 7};
 		int[] B = new int[A.length];
 		int[] C = new int[A.length];
 		int minIndex = minArrayIndex(A, 0, A.length-1);
 		int maxIndex = maxArrayIndex(A, 0, A.length-1);

 		for(int x: A) System.out.print(x+" ");
 		System.out.println();

		System.out.println( "minIndex = " + minIndex );
 		System.out.println( "maxIndex = " + maxIndex );
 		reverseArray1(A, A.length, B);
 		for(int x: B) System.out.print(x+" ");
 		System.out.println();

	 	reverseArray2(A, A.length, C);
 		for(int x: C) System.out.print(x+" ");
	 	System.out.println();

 		reverseArray3(A, 0, A.length-1);
 		for(int x: A) System.out.print(x+" ");
 		System.out.println(); 
	}

	//reverses the leftmost n elements in X and inserts into Y
	static void reverseArray1(int[] X, int n, int[] Y){

    	if(n > 0){
        	reverseArray1(X, n-1, Y);	// print leftmost n-1 elements, reversed
        	Y[n-1] = X[X.length - n];
        }          
    }

    //reverses the rightmost n elements in X and inserts into Y 
    static void reverseArray2(int[] X, int n, int[] Y) {

      	if(n > 0){
         	reverseArray2(X, n-1, Y);  
         	Y[X.length - n] = X[n-1];
        }  	
    }

    //reverses array by switching leftmost and rightmost values until median hits
    static void reverseArray3(int [] X, int i, int j){

    	if(i < j){
    		int temp = X[j]; 
    		X[j] = X[i];
    		X[i] = temp; 
    		reverseArray3(X, i+1, j-1);
    	}
    }

    //finds maximum within array using 'MergeSort'
    static int maxArrayIndex(int [] X, int p, int r){

    	int q;

    	if(p < r){
    		q = (p+r)/2;	//q is median of array and splits into two
			int left = maxArrayIndex(X, p, q); 		//left half of array 
			int right = maxArrayIndex(X, q+1, r);	//right half of array 
			if(X[left] > X[right]){
				return left; 
			}else{
				return right; 
			}
    	}else{
    		return p; 
    	}
	}

	//finds minimum within array using 'MergeSort'
	static int minArrayIndex(int [] X, int p, int r){

		int q;
    	if(p < r){
    		q = (p+r)/2;	//q is median array and splits into left and right
			int left = minArrayIndex(X, p, q); 		//left half of array 
			int right = minArrayIndex(X, q+1, r);	//right half of array
			if(X[left] < X[right]){					
				return left; 
			}else{
				return right; 
			}
    	}else{
    		return p; 
    	}
	}

}
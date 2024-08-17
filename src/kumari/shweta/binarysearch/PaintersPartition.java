/**
 * @author Shweta Kumari
 *2024-08-09
 */
package kumari.shweta.binarysearch;

/**
 * Given N boards with length of each boards 
 * a) A Painter takes T unit of time to point 1 unit of length.
 * b) A board can only be painted by one painter.
 * c) A painter can only paint boards placed next to each other (continuous segment
 * Find Minimum no of painters required to paint all boards in X unit of time and return -1 
 * if it is not possible .
 * 
 * Input Constraint :
 * t - time taken to paint the 1 unit of board
 * X - total maximum time alloted for each painter
 * N - No of board to painted 
 * arr[] - length of each N board 
 *
 */
public class PaintersPartition {
	
	//TC ->O(N) SC->O(1)
	 public static int findMinimumNoOfPainter(int t,int X,int N,int arr[]) {
		 int count=1;//  Intialize  with one painter 
		  int timeLeft=X;
		 for(int i=0;i<N;i++ ) {
			 
			 if(arr[i]*t>X) {  
				 return -1;
			 } 
			 
			 if(arr[i]*t<=timeLeft) {
				 timeLeft=arr[i]*t;
			 } else {
				 count++;
				 timeLeft=X-arr[i]*t;
			 }
		 }
		 
		 return count;
	 }

	public static void main(String[] args) {
	
		// Test case 1:
		int t = 2;
		int X = 15;
		int N = 5;
		int arr[] = { 5, 3, 6, 1, 9 };
		int minNoOfPainter = findMinimumNoOfPainter(t, X, N, arr);
		System.out.println("Find minimum no of painter required paint in given time timit" + minNoOfPainter);

		// Test case 2
		int X1 = 30;
		int minNoOfPainter1 = findMinimumNoOfPainter(t, X1, N, arr);
		System.out.println("Find minimum no of painter required paint in given time timit" + minNoOfPainter1);	
	
	}
}

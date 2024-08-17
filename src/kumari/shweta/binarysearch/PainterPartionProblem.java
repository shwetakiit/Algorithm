/**
 * @author Shweta Kumari
 *2024-08-13
 */
package kumari.shweta.searching;

/*
Problem Description
Given 2 integers A and B and an array of integers C of size N. Element C[i] represents the length of ith board.
You have to paint all N boards [C0, C1, C2, C3 … CN-1]. There are A painters available and each of them takes B units of time to paint 1 unit of the board.

Calculate and return the minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of the board.
NOTE:
1. 2 painters cannot share a board to paint. That is to say, a board cannot be painted partially by one painter, and partially by another.
2. A painter will only paint contiguous boards. This means a configuration where painter 1 paints boards 1 and 3 but not 2 is invalid.

Return the ans % 10000003.

Problem Constraints
1 <= A <= 1000
1 <= B <= 10pow6
1 <= N <= 10pow5
1 <= C[i] <= 10 pow6

Input Format
The first argument given is the integer A.
The second argument given is the integer B.
The third argument given is the integer array C.

Output Format
Return minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of board % 10000003.

Example Input
Input 1:

 A = 2
 B = 5
 C = [1, 10]
Input 2:
 A = 10
 B = 1
 C = [1, 8, 11, 3]

Example Output
Output 1:

 50
Output 2:

 11*/
public class PainterPartionProblem {

	/**
	 * @param noOfPainter
	 * @param timePerUnit
	 * @param arr
	 */
	private static int minimumTimetoPaintBoard(int noOfPainter, int timePerUnit, int[] arr) {

		long mod = 10000003;

		int sumOfArray = Arrays.stream(arr).reduce(0, (x, y) -> x + y);
		int maxElement = Arrays.stream(arr).max().getAsInt();
		int maxTime = sumOfArray;

		long left = maxElement;
		long right = maxTime;
		long ans = 0;
		if (noOfPainter == 1) { //If painter only one then It all board should be painted by one painter only/
		
			long result = (right * timePerUnit);
			return (int) (result % mod);
		}
		while (left <= right) {

			long mid = (left + right) / 2;
			boolean isPaintPossible = isItpossibleToPaint(noOfPainter, timePerUnit, arr, mid);
			if (isPaintPossible) {
				ans = mid % mod;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return (int) ((ans * timePerUnit) % mod);
	}

	
	/**
	 * @param noOfPainter
	 * @param timePerUnit
	 * @param arr
	 * @return
	 */
	
	
	private static boolean isItpossibleToPaint(int noOfPainter, int timePerUnit, int[] arr, long mid) {

		int painterCount = 1;
		long sum = 0;
		for (int i = 0; i < arr.length; i++) {

			if ((sum + (arr[i]) <= mid)) {
				sum += (arr[i]);
			} else {
				painterCount++;
				sum = arr[i];

			}

		}
		if (painterCount <= noOfPainter) {
			return true;
		} else {
			return false;
		}

	}
	

	public static void main(String[] args) {
		PainterPartionProblem obj = new PainterPartionProblem();
		//int noOfPainter=2;
		//int timePerUnit=2;
		//int arr[]= {5,3,6,1,9};

		// int noOfPainter=4;
		// int timePerUnit=10;
		// int arr[]= {884,228,442,889};

		// int noOfPainter=3;
		// int timePerUnit=10;
		// int arr[]= {185,186,938,558,655,461,441,234,902,681};

		// int noOfPainter=1;
		// int timePerUnit=10;
		// int arr[]= {1};

		int noOfPainter = 1;
		int timePerUnit = 1000000;
		int arr[] = { 1000000, 1000000 };

		int minTime = minimumTimetoPaintBoard(noOfPainter, timePerUnit, arr);
		System.out.println("Minimum time taken to paint all borads with given no of painters" + minTime);

	  }
}

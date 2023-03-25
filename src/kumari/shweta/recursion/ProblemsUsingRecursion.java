/**
 * @author Shweta Kumari
 *2023-03-25
 */
package kumari.shweta.recursion;

/* 1) Print 1 to N 1,2,3....N
 * 2) Print N to 1 N,N-1,N-2...3,2,1
 * 3) Print Nth Fibnocii 
 * 4)Print factorial of N
 * 
 */
public class ProblemsUsingRecursion {
	// 1. first keep all N,N-1,N-2 N-3 ..3,2 in stack then print from stack
	public static void solve(int A) {
		if (A == 1) {
			System.out.print(1);
			return;
		}
		// System.out.println("**"+A);
		solve(A - 1);
		System.out.print(" " + A);

	}

	// 2 first first print Element then Keep in store in recursion stack from N to 2
	public static void solveReverse(int A) {
		if (A == 1) {
			System.out.println(1);
			return;
		}
		System.out.println(A);
		solveReverse(A - 1);
	}

	public static void main(String[] args) {
		solve(9);
		solveReverse(9);

	}
}

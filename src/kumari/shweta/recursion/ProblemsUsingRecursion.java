/**
 * @author Shweta Kumari
 *2023-03-25
 */
package kumari.shweta.recursion;

/* 1) Print 1 to N 1,2,3....N
 * 2) Print N to 1 N,N-1,N-2...3,2,1
 * 3) Print Nth fibonacci  
 * 4)Print factorial of N
 * 
 */
public class ProblemsUsingRecursion {
	// 1. First keep all N,N-1,N-2 N-3 ..3,2 in stack then print from stack
	public static void solve(int A) {
		if (A == 1) {
			System.out.print(1);
			return;
		}
		// System.out.println("**"+A);
		solve(A - 1);
		System.out.print(" " + A);

	}

	// 2 First print Element then create recursion stack for that element  from N to 2
	public static void solveReverse(int A) {
		if (A == 1) {
			System.out.print(""+1);
			return;
		}
		System.out.println(A);
		solveReverse(A - 1);
	}
	//3.Nth fibonacci 
	
	public static int FindNthfibonacci(int N) {
		if(N==1|| N==0) {
			return N;
		} 
		return FindNthfibonacci(N-1)+FindNthfibonacci(N-2);
	}
	//4. Factorial 
	public static int factorial(int N) {
		if(N==0||N==1) {
			return 1;
		} 
		return N*factorial(N-1);
	}
	//Check String Polindrom using recusrion 
	static int polindrom(String A) {
		int l = 0;
		int r = A.length() - 1;

		int result = isPol(A, l, r);
		return result;

	}

	static int isPol(String A, int l, int r) {
		if (l > r) {
			return 1;
		}
		if (A.charAt(l) != A.charAt(r)) {
			return 0;
		}
		return isPol(A, l + 1, r - 1);
	}

	public static void main(String[] args) {
		solve(9);
		System.out.println();
		solveReverse(9);
		int nthElement=FindNthfibonacci(4);
		System.out.println("Nth element of Fibnocii series is "+nthElement);
		int result=factorial(5);
		System.out.println("Recusrive factorial"+result);
		int isPol=polindrom("abbcbba");
		System.out.println("Is polindrom"+isPol);
		}
}

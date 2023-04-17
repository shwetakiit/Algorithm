/**
 * @author Shweta Kumari
 *2023-04-16
 */
package kumari.shweta.sorting;

/**
 * @author Shweta Kumari
 *
 */
/*Given two sorted away find no of pairs in such that A[i]>B[j]
 * Example : A[3 6 8 10 15] B[1 2 7 12 18] 
 * Possible pair should be (3,1),(6,1)(8,1),(10,1)...(3,2),(6,2)(8,2)...etc 
 */
public class FindNumberOfPairs {
	public static int noOfPairs(int A[],int B[]) {
		int i=0,j=0;
		int N=A.length,count=0;
		int M=B.length;
		while(i<N && j<M) {
			if(A[i]<=B[j]) {
				i++;
			} else {
				count=count+(N-i);
				j++;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		int A[]= {3,6, 8 ,10, 15};
		int B[]= {1,2,7,12,18};
		int noOfPossiblePair=noOfPairs(A, B);
		System.out.println("No of possible pairs is "+noOfPossiblePair);
	}

}

/**
 * @author Shweta Kumari
 *2023-04-14
 */
package kumari.shweta.sorting;


public class MergeTwoSortedArray {

static int[] mergeTwoSortedArray(int A[],int B[] ){
	int i=0,j=0,k=0;
	int c[]=new int[A.length+B.length];
	while(i<A.length && j<B.length) {
		if(A[i]<B[j]) {
			c[k]=A[i];
			k++;
			i++;
		} else {
			c[k]=B[j];
			k++;
			j++;
		}
	}
	while(i<A.length) {
		c[k]=A[i];
		k++;
		i++;
	}
	while(j<B.length) {
		c[k]=B[j];
		k++;
		j++;
	}
	return c;
}
public static void main(String[] args) {
	int A[]= {2,3,7,12,20,24,29};
	int B[]= {6,9,12,14,15,19};
	 int result[]=mergeTwoSortedArray(A,B);
	 for(int i=0;i<result.length;i++) {
		 System.out.print(result[i]+"\t");
	 }
}
}

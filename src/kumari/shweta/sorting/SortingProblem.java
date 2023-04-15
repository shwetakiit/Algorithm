/**
 * @author Shweta Kumari
 *2023-04-15
 */
package kumari.shweta.sorting;

/*Single array and three integers l,y,r ->Sort the sub array from l to r 
 * Given sub array from l to y-1 and sub array from y to r  if l=2 ,y=5,r=7
 * subarray1 2 to 4  subarray2 5 to 7 
 * arr[]={8,1,3,6,11,2,4,9,7,6}  and two subarray  [3,6,11][2,4,9]  --mergedsorted subarray[2,3,4,6,9,11]
 * Output [8,1,3,6,11,2,4,9,7,6]
 */
public class SortingProblem {

	static void sortSubArray(int A[],int l,int y,int r){
	int i=l,j=y;
	int k=0;
	//Sub array size r-l+1
	int c[] = new int [r-l+1];
	while(i<y && j<=r) {
		if(A[i]<A[j]) {
			c[k]=A[i];
			i++;
			k++;
		} else {
			c[k]=A[j];
			j++;
			k++;
		}
	}
	while(i<y) {
		c[k]=A[i];
		i++;k++;
	}
	while(j<=r) {
		c[k]=A[j];
		j++;k++;
	}
	int subIndex=0;
	for(i=l;i<=r;i++) {
		A[i]=c[subIndex];
		subIndex++;
	}
	 for(int i1=0;i1<A.length;i1++){
		 System.out.print(A[i1]+" ");
	 }
		
	}
	public static void main(String[] args) {
		int arr[]= {8,1,3,6,11,2,4,9,7,6};
	    sortSubArray(arr, 2, 5, 7);
		
	}
}

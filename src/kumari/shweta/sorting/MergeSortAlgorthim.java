/**
 * @author Shweta Kumari
 *2023-04-16
 */
package kumari.shweta.sorting;
/*Sort Array using merge sort Algorithm
 */
public class MergeSortAlgorthim {
	static void mergeSort(int[] arr,int l,int r,int N) {
		if(l==r) {  //base case 
			return;
		}
		int mid=(l+r)/2;
		mergeSort(arr, l, mid,N);
		mergeSort(arr,mid+1,r, N);
		mergeTwoSortedSubArray(arr,N,l,mid+1 ,r); // sub array l->y-1 and y->r  i.e l -> mid+1-1 and  mid+1->r
	}
	/**
	 * @param arr
	 * @param n
	 * @param l
	 * @param y
	 * @param r
	 */
	private static void mergeTwoSortedSubArray(int[] arr, int n, int l, int y, int r) {
	 int i=l ,j=y;
	 int k=0;
	 int c[]=new int [n];
		while(i<y && j<=r) {
			if(arr[i]<arr[j]) {
				c[k]=arr[i];
				k++;
				i++;
			} else {
				c[k]=arr[j];
				k++;
				j++;
			}
		}
		while(i<y) {
			c[k]=arr[i];
			i++;
			k++;
		}
		while(j<=r) {
			c[k]=arr[j];
			k++;
			j++;
		}
		//Sorted sub merge in original array
		int subIndex=0;
		for(int i1=l;i1<=r;i1++) {
		 arr[i1]=c[subIndex];
		 subIndex++;
		 
		}
	}
	public static void main(String[] args) {
		int arr[]= {3,10,6,8,15,-1,13,-4,-3};
		mergeSort( arr,0,arr.length-1,arr.length);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}

}

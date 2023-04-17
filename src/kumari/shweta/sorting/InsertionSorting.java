/**
 * @author Shweta Kumari
 *2023-04-16
 */
package kumari.shweta.sorting;

/**
 * @author Shweta Kumari
 *
 */

/*Worst case TC->O(n^2) Best case if Array is already Sorted only outer loop execute 
 */
public class InsertionSorting {
	
	static void insertionSort(int arr[]) {
		//Assume first element is always sorted 
		for(int i=1;i<arr.length;i++) {
			for(int j=i-1;j>=0;j--) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		for(int k=0;k<arr.length;k++) {
			System.out.print(arr[k]+" ");
		}
	}
	public static void main(String[] args) {
		int arr[]= {1,3,2,6,8,10,9,5};
		insertionSort(arr);
		
	}

}

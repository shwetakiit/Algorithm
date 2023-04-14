/**
 * @author Shweta Kumari
 *2023-04-14
 */
package kumari.shweta.sorting;

/**
 * @author Shweta Kumari
 *
 */
/*input A = [2, 1, 4, 3, 2] B=3 -->3rd smallest element
 * output ->2 
 * TC O(N^2);
 */
public class FindNthSamallestElement {
   public static int findSmallestElement(int A[],int B) {
	   for(int i=0;i<B;i++){
           int min_index=i;
           int min_element=A[i];
           for(int j=i;j<A.length;j++){
               if(A[j]<min_element){
                   min_element=A[j];
                   min_index=j;
               }
           }
          int  temp=A[i];
           A[i]=A[min_index];
           A[min_index]=temp;
       }
       return A[B-1]; 
   }
	public static void main(String[] args) {
		int arr[]= {2, 1, 4, 3, 2};
		int result=findSmallestElement(arr, 3);
       System.out.println("Nth samllest element is "+result);
	}
}

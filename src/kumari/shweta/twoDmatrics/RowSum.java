/**
 * @author Shweta Kumari
 *2023-03-15
 */
package kumari.shweta.twoDmatrics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*You are given a 2D integer matrix A, return a 1D integer array containing row-wise sums of original matrix.
		Input 1:[[1,2,3,4][5,6,7,8][9,2,3,4] ] Output [10,26,18]
		
*/
					
public class RowSum {
	public static List<Integer> rowWiseSum(List<List<Integer>> A){
		 List<Integer> result= new ArrayList<Integer>();
	        int noOfRow=A.size();
	        int noOfCol=A.get(0).size();
	        for(int i=0;i<noOfRow;i++){
	            int sum=0;
	            for(int j=0;j<noOfCol;j++){
	            sum+=A.get(i).get(j);
	            }
	            result.add(sum);
	        }
	        return result;
	}
	public static void main(String[] args) {
		List<List<Integer>> matrixList = Arrays.asList(
				new ArrayList<>(Arrays.asList(1, 2, 3, 4)),
				new ArrayList<>(Arrays.asList(5, 6, 7, 8)), 
				new ArrayList<>(Arrays.asList(9, 2, 3, 4)));
		List<Integer> result = rowWiseSum(matrixList);
		System.out.println("Column wise sum is " + result);
	}

}

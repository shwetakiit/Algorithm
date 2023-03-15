/**
 * @author Shweta Kumari
 *2023-03-15
 */
package kumari.shweta.twoDmatrics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*You are given a 2D integer matrix A, return a 1D integer array containing column-wise sums of original matrix.
  input[ [1,2,3,4] [5,6,7,8][9,2,3,4]]
  output[15,10,13,16]
  */
public class ColumnSum {
	public static List<Integer> columnWiseSum(List<List<Integer>> A) {
		List<Integer> result = new ArrayList<Integer>();
		int noOfRow = A.size();
		int noOfCol = A.get(0).size();
		for (int i = 0; i < noOfCol; i++) {
			int sum = 0;
			for (int j = 0; j < noOfRow; j++) {
				sum += A.get(j).get(i);

			}
			result.add(sum);
			sum = 0;
		}
		return result;
	}

	public static void main(String[] args) {
		List<List<Integer>> matrixList = Arrays.asList(
				new ArrayList<>(Arrays.asList(1, 2, 3, 4)),
				new ArrayList<>(Arrays.asList(5, 6, 7, 8)), 
				new ArrayList<>(Arrays.asList(9, 2, 3, 4)));
		List<Integer> result = columnWiseSum(matrixList);
		System.out.println("Column wise sum is " + result);
	}
}

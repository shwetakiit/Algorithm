/**
 * @author Shweta Kumari
 *2023-03-18
 */
package kumari.shweta.twoDmatrics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*Rotate matrix by 90 degree 
 *Input of n*m matrix 
 *[[1,3,4,2][2,9,6,-1][-3,12,8,7][10,-2,0,-9]]
 *
 *Output - [[10,-3,2,1][-2,12,9,3][0,8,6,4][-9,7,-12]] 
 */
public class RotateMatrixWithNinteyDegree {
	static List<List<Integer>> rotateMatrix(List<List<Integer>> A) {
		for (int i = 0; i < A.size(); i++) {
			for (int j = i + 1; j < A.size(); j++) {
				int temp = A.get(i).get(j);
				A.get(i).set(j, A.get(j).get(i));
				A.get(j).set(i, temp);
			}
		}
		for (int i = 0; i < A.size(); i++) {
			Collections.reverse(A.get(i));
		}
		return A;
	}

	public static void main(String[] args) {
		List<List<Integer>> matrixList = Arrays.asList(
				new ArrayList<>(Arrays.asList(1, 3, 4, 2)),
				new ArrayList<>(Arrays.asList(2, 9, 6, -1)),
				new ArrayList<>(Arrays.asList(-3, 12, 8, 7)),
				new ArrayList<>(Arrays.asList(10, -2, 0, -9)));
		List<List<Integer>> result = rotateMatrix(matrixList);
		System.out.println("90 degree rotated matrix " + result);

	}
}

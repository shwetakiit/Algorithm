/**
 * @author Shweta Kumari
 *2023-03-15
 */
package kumari.shweta.twoDmatrics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*1) Sum of Main Diagonal 
 * Input 1:[[1,2,3][5,6,7][9,2,3] ]  Output 9
 * 
 * 2) Sum of Minor Diaogonal output :18
 * 
 */
public class SumOfDiagonal {

	public static int sumOfMainDiagonal(List<List<Integer>> A) {
		int sum = 0;
		for (int i = 0; i < A.size(); i++) {
			sum = sum + A.get(i).get(i);
		}
		return sum;

	}

	public static int sumOfMinorDiagonal(List<List<Integer>> A) {

		// N*N so noOfRow=noOfCol
		int i = 0;
		int j = A.size() - 1;
		int sum = 0;
		while (i < A.size() && j >= 0) {
			sum += A.get(i).get(j);
			i++;
			j--;
		}
		return sum;
	}

	public static void main(String[] args) {
		List<List<Integer>> matrixList = Arrays.asList(
				new ArrayList<>(Arrays.asList(1, 2, 3, 4)),
				new ArrayList<>(Arrays.asList(5, 6, 7, 8)), 
				new ArrayList<>(Arrays.asList(9, 2, 3, 4)));

		System.out.println("Sum of main diagonal " + sumOfMainDiagonal(matrixList));
		System.out.println("Sum of Minor diagonal " + sumOfMinorDiagonal(matrixList));

	}
}


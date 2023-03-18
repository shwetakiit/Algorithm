/**
 * @author Shweta Kumari
 *2023-03-19
 */
package kumari.shweta.twoDmatrics;
/*
 * Product of two matrices 
 */
class MatrixProduct {
	static int[][] productMatrix(int m1[][], int m2[][]) {
		int result[][] = new int[m1.length][m2[0].length];
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m2[0].length; j++) {
				result[i][j] = 0;
				for (int k = 0; k < m1[0].length; k++) {
					result[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int m1[][] = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
		int m2[][] = { { 0, 1, 2 }, { 1, 0, 1 } };
		int[][] result = productMatrix(m1, m2);
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				System.out.print(result[i][j] + "\t");
			}
			System.out.println();
		}
	}
}

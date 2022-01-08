package kumari.shweta.LinkedList;

import java.util.Scanner;

public class ConvasProblem {

	public static void filledColor(int arr[][], int sourceRow, int sourceCol, int filledColor, int fillColor,
			int rowLength, int colLength) {
		if (sourceRow < 0 || sourceCol < 0 || sourceRow >= rowLength || sourceCol >= colLength)
			return;
		else if (arr[sourceRow][sourceCol] != filledColor) {
			return;
		} else {
			arr[sourceRow][sourceCol] = fillColor;
			filledColor(arr, sourceRow - 1, sourceCol, filledColor, fillColor, rowLength, colLength);
			filledColor(arr, sourceRow + 1, sourceCol, filledColor, fillColor, rowLength, colLength);
			filledColor(arr, sourceRow, sourceCol - 1, filledColor, fillColor, rowLength, colLength);
			filledColor(arr, sourceRow, sourceCol + 1, filledColor, fillColor, rowLength, colLength);
		}

	}

	public static void main(String[] args) {

		int arr[][] = { { 1, 1, 1, 1, 1, 1, 1, 2 }, { 1, 1, 1, 1, 1, 1, 0, 0 }, { 1, 0, 0, 1, 1, 0, 1, 1 },
				{ 1, 2, 2, 2, 2, 0, 1, 0 }, { 1, 1, 1, 2, 2, 0, 1, 0 }, { 1, 1, 1, 2, 2, 2, 2, 0 },
				{ 1, 1, 1, 1, 1, 2, 1, 1 }, { 1, 1, 1, 1, 1, 2, 2, 1 }, };

		System.out.println("Enter pixel point x ,y coordinate");
		Scanner sc = new java.util.Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		System.out.println("Enter filled Color and  newColor");

		int filledColor = sc.nextInt();
		int fillColor = sc.nextInt();
		int rowLength = arr.length;
		int colLength = arr[0].length;
		ConvasProblem.filledColor(arr, x, y, filledColor, fillColor, rowLength, colLength);

		for (int i = 0; i < rowLength; i++) {
			for (int j = 0; j < colLength; j++) {
				System.out.print(arr[i][j]);

			}
			System.out.println();
		}

	}
}

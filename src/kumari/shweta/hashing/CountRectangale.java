/**
 * @author Shweta Kumari
 *2024-09-22
 */
package kumari.shweta.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/*
 * Problem Description
Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents a unique point (x, y) in a 2-D Cartesian plane.

Find and return the number of unordered quadruplet (i, j, k, l) such that (A[i], B[i]), (A[j], B[j]), (A[k], B[k]) and (A[l], B[l]) form a rectangle with the rectangle having all the sides parallel to either x-axis or y-axis.

Problem Constraints
1 <= N <= 2000
0 <= A[i], B[i] <= 109
Input Format
The first argument given is the integer array A.
The second argument given is the integer array B.
Output Format
Return the number of unordered quadruplets that form a rectangle.
Example Input
Input 1: A = [1, 1, 2, 2]   B = [1, 2, 1, 2]
Input 2: A = [1, 1, 2, 2, 3, 3]  B = [1, 2, 1, 2, 1, 2]
Example Output
Output 1:  1 Output 2:  3
Example Explanation
Explanation 1:
 All four given points make a rectangle. So, the answer is 1.
Explanation 2: 3 
quadruplets which make a rectangle are:    (1, 1), (2, 1), (2, 2), (1, 2)
                                           (1, 1), (3, 1), (3, 2), (1, 2)
                                           (2, 1), (3, 1), (3, 2), (2, 2)

 */

public class CountRectangale {

	// TC --O(N^2) SC ->O(N)

	public int countRectrangle(List<Integer> xPoints, List<Integer> yPoints) {

		Set<List<Integer>> set = new HashSet<>(); // This set contains all x,y points given in input

		int count = 0;
		for (int i = 0; i < xPoints.size(); i++) {

			List<Integer> point = new ArrayList<>();
			point.add(xPoints.get(i));
			point.add(yPoints.get(i));
			set.add(point);

		}

		for (int i = 0; i < xPoints.size(); i++) {

			for (int j = 0; j < xPoints.size(); j++) {

				if (xPoints.get(i) < xPoints.get(j) && yPoints.get(i) < yPoints.get(j)

						&& set.contains(Arrays.asList(xPoints.get(i), yPoints.get(j)))

						&& set.contains(Arrays.asList(xPoints.get(j), yPoints.get(i)))) {

					count++;
				}
			}
		}

		return count;

	}

	public static void main(String[] args) {

		List<Integer> xPoints = Arrays.asList(1, 1, 2, 2, 3, 3);
		List<Integer> yPoints = Arrays.asList(1, 2, 1, 2, 1, 2);

		CountRectangale obj = new CountRectangale();
		int noOfRectangle = obj.countRectrangle(xPoints, yPoints);
		System.out.println("No of rectangle can be draw using given x and y points is " + noOfRectangle);

	}
}

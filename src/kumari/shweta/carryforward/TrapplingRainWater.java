/**
 * @author Shweta Kumari
 *2023-03-12
 */
package kumari.shweta.carryforward;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Given a vector A of non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * HeightOfBoundary [4,2,5,7,4,2,3,6,8,2,3]
 * O/P-16
 */
public class TrapplingRainWater {
	public static int trap(List<Integer> A) {

		List<Integer> leftmax = new ArrayList<Integer>(); // Left max element using CarryForward algo
		List<Integer> rightmax = new ArrayList<Integer>();// Right max element using CarryForward element
		int watercummulated = 0;
		int leftmaxelement = A.get(0);
		leftmax.add(leftmaxelement);
		int rightmaxelement = A.get(A.size() - 1);
		rightmax.add(rightmaxelement);
		for (int i = 1; i < A.size(); i++) {
			if (A.get(i) > leftmax.get(leftmax.size() - 1)) {
				leftmax.add(A.get(i));
			} else {
				leftmax.add(leftmax.get(leftmax.size() - 1));
			}
		}
		for (int i = A.size() - 2; i >= 0; i--) {
			if (A.get(i) > rightmax.get(rightmax.size() - 1)) {
				rightmax.add(A.get(i));
			} else {
				rightmax.add(rightmax.get(rightmax.size() - 1));
			}
		}
		for (int i = 0; i < A.size(); i++) {
			watercummulated = watercummulated + Math.min(leftmax.get(i), rightmax.get(A.size() - 1 - i)) - A.get(i);
		}
		return watercummulated;

	}

	public static void main(String[] args) {
		List<Integer> boundaryHeight = Arrays.asList(4, 2, 5, 7, 4, 2, 3, 6, 8, 2, 3);
		int trappedWater=trap(boundaryHeight);
		System.out.println("Total trapped water" + trappedWater);
	}
}

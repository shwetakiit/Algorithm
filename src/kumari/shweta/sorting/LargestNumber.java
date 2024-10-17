/**
 * @author Shweta Kumari
 *2024-10-17
 */
package kumari.shweta.sorting;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/*
Problem Description
Given an array A of non-negative integers, arrange them such that they form the largest number.
Note: The result may be very large, so you need to return a string instead of an integer.
Problem Constraints
1 <= len(A) <= 100000
0 <= A[i] <= 2*10^9
Input Format The first argument is an array of integers.
Output Format Return a string representing the largest number.
Example Input Input 1: A = [3, 30, 34, 5, 9]
Input 2: A = [2, 3, 9, 0]
Example Output Output 1: "9534330"
Output 2: "9320"
Example Explanation
Explanation 1:
Reorder the numbers to [9, 5, 34, 3, 30] to form the largest number.
Explanation 2:
Reorder the numbers to [9, 3, 2, 0] to form the largest number 9320.

*/
class MyComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {

		return ("" + o2 + o1).compareTo("" + o1 + o2);
	}

}

public class LargestNumber {

	public String findLargestNumber(List<Integer> list) {
		int count = 0;

		for (int i : list) {
			if (i == 0) {
				count++;
			}
		}
		if (count == list.size()) {
			return "0";
		}

		Collections.sort(list, new MyComparator());
		System.out.println(list);

		StringBuffer sb = new StringBuffer();
		for (int a : list) {
			sb.append(a);
		}
		return sb.toString();

	}

	public static void main(String[] args) {

		LargestNumber obj = new LargestNumber();

		// Test case 1
		List<Integer> list = Stream.of(3, 30, 34, 5, 9).collect(Collectors.toList());
		String largestNumber = obj.findLargestNumber(list);
		System.out.println(largestNumber);

		// Test case 2
		List<Integer> list1 = Stream.of(0, 0, 0).collect(Collectors.toList());
		String largestNumber2 = obj.findLargestNumber(list1);
		System.out.println(largestNumber2);
	}
}

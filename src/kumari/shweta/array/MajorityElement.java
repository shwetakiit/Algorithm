/**
 * @author Shweta Kumari
 *2024-10-12
 */
package kumari.shweta.array;

import java.security.PublicKey;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Problem Description

Given an array of size N, find the majority element. The majority element is the element that appears more than floor(n/2) times.
You may assume that the array is non-empty and the majority element always exists in the array.
Problem Constraints

1 <= N <= 5*10^5
1 <= num[i] <= 10^9
Input Format
Only argument is an integer array.
Output Format
Return an integer.
Example Input

Input 1: [2, 1, 2]
Input 2: [1, 1, 1]


Example Output Input 1:
2
Input 2:
1


Example Explanation

For Input 1:
2 occurs 2 times which is greater than 3/2.
For Input 2:
 1 is the only element in the array, so it is majority
 */
public class MajorityElement {

	// BF approach use HashMap TC -O(N) SC ->O(N)

	// TC --O(N) SC O(1)
	int findMajority(List<Integer> list) {

		int majority = list.get(0);
		int count = 1;

		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) == majority) {
				count++;
			} else if (count == 0) {
				majority = list.get(i);
			} else {
				count--;
			}
		}

		// We found best element now find frequency of this element this could be
		// majority or couldn't be

		final int mj = majority;
		int freq = (int) list.stream().filter(l -> l.equals(mj)).count();
		System.out.println("Frequency of Majorty count" + freq);

		if (freq > list.size() / 2) {
			return majority;
		}

		return -1;
	}

	public static void main(String[] args) {

		List<Integer> list = Stream.of(3, 4, 3, 6, 1, 3, 2, 5, 3, 3, 3).collect(Collectors.toList());
		MajorityElement obj = new MajorityElement();
		int majorityElement = obj.findMajority(list);

		System.out.println("Majority element is " + majorityElement);

	}

}

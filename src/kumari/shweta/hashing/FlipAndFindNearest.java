/**
 * @author Shweta Kumari
 *2024-09-16
 */
package kumari.shweta.hashing;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/* Flip and Find Nearest

Problem Description
Given a binary string A of size N. There are Q queries given by the 2-D array B of size Q x 2.
Each query has 2 integers :-
First integer denotes the type of query. Type of query can be either 1 or 2.
Second integer denotes index x.
If type = 1, Flip the value at index x.
If type = 2, Find the index of the nearest 1 to the left or right of index x in the array. If there are multiple indices has the same distance from x, return the index with the lower value. If there is no occurrence of 1 in the array, return -1.
Note :
We use 1-based indexing
Problem Constraints
1 <= N <= 105
1 <= Q <= 105
1 <= B[i][0] <= 2
1 <= B[i][1] <= N
Input Format
First argument A is a string.
Second argument B is a 2D array of integers describing the queries.
Output Format
Return an array of integers denoting the answers to each query of type 2.

Example Input
Input 1:
A = "10010"
B = [[1, 2]
     [2, 3]]
Input 2:
A = "010000100"
B = [[2, 5]
     [1, 7]
     [2, 9]]


Example Output
Output 1:
[2]
Output 2:
[7, 2]

Example Explanation
For Input 1:
After first query, A = "11010".
For second query, X = 3. Both index 2 and index 4 are at the same 
distance but we choose the lower index.
For Input 2:
For first query, the index 2 is at a distance 3 and index 7 is at a distance 2. So we choose
index 7.
After second query, A = "010000000"
For third query, the only index with '1' is 2.
Expected Output
Provide sample input and click run to see the correct output for the provided input. Use this to improve your problem understanding and test edge cases
Arg 1: A single String, For e.g 'anagram'
Enter Input Here
Arg 2: Multi Dimensional Array with Integers, For e.g [[2,3,6,7],[2,3,4,5]]
*/
public class FlipAndFindNearest {

	public List<Integer> flipAndFindNearest(String binary, List<ArrayList<Integer>> queries) {

		List<Integer> result = new ArrayList<>();
		int length = binary.length();
		TreeSet<Integer> set = new TreeSet<>();

		for (int i = 0; i < length; i++) {
			if (binary.charAt(i) == '1') {

				set.add(i + 1);
			}
		}

		for (ArrayList<Integer> query : queries) {

			Integer queryType = (Integer) query.get(0);
			Integer index = query.get(1);

			if (queryType == Integer.valueOf(1)) {
				if (set.contains(index)) {
					set.remove(index);
				} else {
					set.add(index);
				}

			} else {

				int nearestLeftIdx = Integer.MIN_VALUE;
				int nearestRightIdx = Integer.MAX_VALUE;

				if (set.ceiling(index) != null) {
					nearestRightIdx = set.ceiling(index);
				}
				if (set.floor(index) != null) {
					nearestLeftIdx = set.floor(index);
				}

				if (nearestLeftIdx == Integer.MIN_VALUE && nearestRightIdx == Integer.MAX_VALUE) {
					result.add(-1);
				} else if (nearestLeftIdx != Integer.MIN_VALUE
						&& (index - nearestLeftIdx) <= (nearestRightIdx - index)) {
					result.add(nearestLeftIdx);
				} else {
					result.add(nearestRightIdx);
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		FlipAndFindNearest obj = new FlipAndFindNearest();

		String string = "000010000";
		List<ArrayList<Integer>> list = new ArrayList<>();
		ArrayList<Integer> query1 = new ArrayList<>();
		query1.add(2);
		query1.add(5);
		ArrayList<Integer> query2 = new ArrayList<>();
		query2.add(1);
		query2.add(7);
		ArrayList<Integer> query3 = new ArrayList<>();
		query3.add(2);
		query3.add(9);
        list.add(query1);
		list.add(query2);
		list.add(query3);
		List<Integer> result = obj.flipAndFindNearest(string, list);
		System.out.println("Result is " + result);
	}
}

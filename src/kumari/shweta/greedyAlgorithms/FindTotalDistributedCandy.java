/**
 * @author Shweta Kumari
 *2023-10-02
 */
package kumari.shweta.greedyAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * Problem Description N children are standing in a line. Each child is assigned
 * a rating value. You are giving candies to these children subjected to the
 * following requirements: Each child must have at least one candy. Children
 * with a higher rating get more candies than their neighbors. What is the
 * minimum number of candies you must give?
 * 
 * Problem Constraints 1 <= N <= 10pow5  -10pow9 <= A[i] <= 10pow9
 * 
 * Input [1,6,3,1,10,12,20,5,2] output  -- Distributed candy [1,3,2,1,2,3,4,2,1]  total distributed candy 19
 **/

public class FindTotalDistributedCandy {

	public List<Integer> candy(List<Integer> scoreList) {
		List<Integer> candy = new ArrayList<>();
		scoreList.forEach(i -> candy.add(1));
		System.out.println(candy);

		// Compare with left side students score

		for (int i = 1; i < scoreList.size(); i++) {
			if (scoreList.get(i) > scoreList.get(i - 1)) {
				candy.set(i, candy.get(i - 1) + 1);
			}
		}

		// Compare with right side students score
		for (int i = scoreList.size() - 2; i >= 0; i--) {

			if (scoreList.get(i) > scoreList.get(i + 1) && candy.get(i) <= candy.get(i + 1)) {
				candy.set(i, candy.get(i + 1) + 1);
			}

		}
		return candy;
	}

	public static void main(String[] args) {

		FindTotalDistributedCandy obj = new FindTotalDistributedCandy();
		List<Integer> scores = Arrays.asList(1, 6, 3, 1, 10, 12, 20, 5, 2);
		List<Integer> distributedCandy = obj.candy(scores);
		System.out.println("Distributed candy for each students are" + distributedCandy);
		int total = distributedCandy.stream().reduce((x, y) -> x + y).get();
		System.out.println("Total disributed candy" + total);
	}
}

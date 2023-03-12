/**
 * @author Shweta Kumari
 *2023-03-12
 */
package kumari.shweta.carryforward;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an integer array A containing N distinct integers, you have to find all the leaders in array A. An element is a leader if it is strictly greater than all the elements to its right side
 * The rightmost element is always a leader.
 * 
 * Input -- A = [16, 17, 4, 3, 5, 2] O/p[17, 2, 5]
 */
public class FindLeaderElements {
	static List<Integer> listOFindLeaderElements(List<Integer> list) {
		List<Integer> result = new ArrayList<>();
     	int maxElement = list.get(list.size() - 1);
		result.add(maxElement);
		for (int i = list.size() - 2; i >= 0; i--) {
			if (list.get(i) > result.get(result.size() - 1)) {
				result.add(list.get(i));
			}
		}
		return result;
	}

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(10, 7, 9, 3, 2, 4);
		List<Integer> leaderElements = listOFindLeaderElements(list);
		System.out.println("Leader elements are" + leaderElements);
	}
}

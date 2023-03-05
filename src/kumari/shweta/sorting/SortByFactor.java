/**
 * @author Shweta Kumari
 *2023-03-06
 */
package kumari.shweta.sorting;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*You are given an array A of N elements. Sort the given array in increasing order of number of distinct factors of each element, i.e., element having the least number of factors should be the first to be displayed and the number having highest number of factors should be the last one. If 2 elements have same number of factors, then number with less value should come  first.
*Example [6, 8, 9] --Output [9, 6, 8]
*/

class SortByFactory implements Comparator<Integer> {
	Map<Integer, Integer> sortbyFactor;

	SortByFactory(Map<Integer, Integer> map) {
		sortbyFactor = map;
	}

	public int compare(Integer key1, Integer key2) {
		int factoryComp = sortbyFactor.get(key1).compareTo(sortbyFactor.get(key2));
		if (factoryComp == 0) {
			return key1.compareTo(key2);
		} else {
			return factoryComp;
		}
	}
}

public class SortByFactor {
	public static List<Integer> sortByFactor(List<Integer> A) {
		Map<Integer, Integer> countFactorMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < A.size(); i++) {
			if (!countFactorMap.containsKey(A.get(i))) {
				countFactorMap.put(A.get(i), countFactor(A.get(i)));
			}
		}
		// System.out.println(countFactor);
		Collections.sort(A, new SortByFactory(countFactorMap));
		return A;

	}

	public  static int countFactor(int element) {
		int count = 0;
		for (int i = 1; (i * i) <= element; i++) {
			if (element % i == 0) {
				if (i != element / i) {
					count = count + 2;
				} else {
					count++;
				}
			}
		}
		return count;

	}
	public static void main(String[] args) {
		List<Integer> list=Arrays.asList(2,4,7,7);
		List<Integer> result=sortByFactor(list);
		System.out.println("Sort by count factor"+result);
	}

}

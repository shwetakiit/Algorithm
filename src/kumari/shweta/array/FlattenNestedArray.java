/**
 * @author Shweta Kumari
 *2024-08-22
 */
package kumari.shweta.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Flatten the given nested array of integer. Input [1,2,[3,[4,5]]]; Output
 * [1,2,3,4,5]
 *
 */
public class FlattenNestedArray {

	public Integer[] flattenArray(Object arr[]) {

		List<Integer> flattenList = new ArrayList<>();
		for (Object element : arr) {
			if (element instanceof Integer) {
				flattenList.add((Integer) element);
			} else if (element instanceof Object[]) {
				flattenList.addAll(Arrays.asList(flattenArray((Object[]) element)));
			} else {
				throw new IllegalArgumentException("Input must be array of integer or nested array of integer");
			}
		}

		return flattenList.toArray(new Integer[flattenList.size()]);
	}

	public static void main(String[] args) {

		FlattenNestedArray obj = new FlattenNestedArray();

		Object arr1[] = { 4, 5 };
		Object arr2[] = { 3, arr1 };
		Object arr3[] = { 1, 2, arr2 };
		obj.flattenArray(arr3);
		Integer result[] = obj.flattenArray(arr3);

		for (Integer num : result) {
			System.out.print(num + " ");
		}
	}
}

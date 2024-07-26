/**
 * @author Shweta Kumari
 *2024-07-26
 */
package kumari.shweta.searching;


/*
 * Every element occurs twice except for one element ,find that unique element
 * Note : Duplicate are adjacent to each other.
 * 
 * {3,3,1,1,10,10,9,6,6,2,2,4,4} Output : 9
 */
public class FindUniqueElement {

	//TC- O(log2N) SC-O(1)
	public static int findUniqueElement(int arr[]) {

		int N = arr.length;

		if(N==1) {
			return arr[0];
		}
		if (arr[0] != arr[1]) { // arr[1] can be duplicate with adjacent arr[2] but arr[0]not possible to be
								// duplicated
			return arr[0];
		}

		if (arr[N - 1] != arr[N - 2]) { // arr[N-2] can be duplicated with adjacent element arr[N-3] but there is no
										// chance for arr[N-1] because it is last element.
			return arr[N - 1];
		}

		int left = 2;
		int right = N - 3;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (arr[mid - 1] != arr[mid] && arr[mid] != arr[mid + 1]) {

				return arr[mid]; // mid is unique
			}

			int firstOccurance = mid;
			if (arr[mid] == arr[mid - 1]) {
				firstOccurance = mid - 1;
			} else {
				firstOccurance = mid;
			}

			if (firstOccurance % 2 == 0) { // If FO at even index means unique element is right side

				left = firstOccurance + 2;
			} else {
				right = firstOccurance - 1; // If index of FO is odd It means unique element is left side.
			}

		}
		return -1 ;//If there is no unique element 
	}

	public static void main(String[] args) {
		int arr[] = { 3, 3, 1, 1, 10, 10, 9, 6, 6, 2, 2, 4, 4 };
		int uniqueElement = findUniqueElement(arr);
		System.out.println("Enque element is " + uniqueElement);

	}

}

/**
 * @author Shweta Kumari
 *2024-10-11
 */
package kumari.shweta.prefixSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/*
There is a car with no. of empty seats equal to the given capacity. The vehicle only drives in a particular direction (i.e., it cannot turn around and go to another direction). Given the integer capacity and an array of trips[] where trips[i] = [num_Passengers, start_loc, end_loc] indicates that the ith trip has num_Passengers (1 <= num_passengers <= 108) passengers and the locations to pick them up and drop them off are start_loc and end_loc
(0 <= start_loc, end_loc <= 103) respectively, the task is to return true if it is possible to pick up and drop off all passengers for all the given trips, or false otherwise.

Examples:


Input: trips[] = [[3, 2, 7], [3, 7, 9], [8, 3, 9]], capacity = 11 
Output: True
Explanation: First from locations 2 to 7 there will be three passengers in the car and after reaching 7 location they will take off, and then from 7 to 9 will be three passengers will travel in the car but the last trip from 3 to 9 will have 8 passengers and the capacity is 11. So, at 7 locations 3 passengers will take off according to the first trip and 7 to 9 new three passengers will travel. So, 8+3 = 11. The capacity of 11 will be maintained.


Input: trips[] = [[2, 1, 5], [3, 3, 7]], capacity = 5 
Output: True
Explanation: First from locations 1 to 5 there will be 2 passengers in the car and after reaching 5 locations they will take off, and then from 3 to 7 will be 3 passengers will travel in the car but at most there will be 5 passengers in the car between location 3 to 5. So, The capacity of 5 will be maintained.

*/

public class CarPooling {

	boolean possiblePickUpDrop(List<ArrayList<Integer>> trip2, int capacity) {

		// Create prefixsum array for capacity start location to end location
		int prefixSum[] = new int[1001];
		int maxDestination = Integer.MIN_VALUE; // This wll keep max dropping point to avoid the unnessary iteration of
												// prefix sum till 1001.

		for (ArrayList<Integer> trip : trip2) {

			prefixSum[trip.get(1)] += trip.get(0);
			prefixSum[trip.get(2)] -= trip.get(0);
			if (maxDestination < trip.get(2)) {
				maxDestination = trip.get(2);
			}

		}

		/*
		 * for (int i = 0; i <= maxDestination; i++) { System.out.println(prefixSum[i]);
		 * }
		 */

		for (int i = 0; i <= maxDestination; i++) {
			capacity = capacity - prefixSum[i];
			if (capacity < 0) {
				return false;
			}

		}

		return true;
	}

	public static void main(String[] args) {

		List<ArrayList<Integer>> trip = new ArrayList<>();
		int capacity = 11;
		List<Integer> l1 = Stream.of(3, 2, 7).collect(Collectors.toList());
		List<Integer> l2 = Stream.of(3, 7, 9).collect(Collectors.toList());
		List<Integer> l3 = Stream.of(8, 3, 9).collect(Collectors.toList());
		trip.add((ArrayList<Integer>) l1);
		trip.add((ArrayList<Integer>) l2);
		trip.add((ArrayList<Integer>) l3);

		CarPooling obj = new CarPooling();
		boolean value = obj.possiblePickUpDrop(trip, capacity);
		System.out.println("Is trip fisible " + value);
	}

}

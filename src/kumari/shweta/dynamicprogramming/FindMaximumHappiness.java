/**
 * @author Shweta Kumari
 *2023-11-04
 */
package kumari.shweta.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*Fractional Knapsack 
 * Given N cakes with the happiness and weight .Find the maximum total happiness that can be kept in a bag 
 * with capacity =w 
 * Note :Cakes can be divided
 * Input 
 * Happiness [4,8,10,2,5] Corresponding weight[4,4,20,8,16]  W=40 
 * 
 * 
 */
public class FindMaximumHappiness {

	public double maximumHapiness(List<Integer> h, List<Integer> w, int capacity) {
		double result = 0.0;
		List<Double> ratios = new ArrayList<>();
		List<Double> sortedRatio = new ArrayList<>();
		for (int i = 0; i < h.size(); i++) {
			if (w.get(i) <= capacity) {
				double ratio = (double) h.get(i) / (double) w.get(i);
				ratios.add(ratio);
				sortedRatio.add(ratio);
			}
		}

		Collections.sort(sortedRatio, Collections.reverseOrder());
		for (int i = 0; i < sortedRatio.size(); i++) {
			int index = ratios.indexOf(sortedRatio.get(i));
			if (w.get(index) <= capacity) {
				result = result + h.get(index);
				capacity = capacity - w.get(index);
			} else {
				result = result + ((double) h.get(index) / (double) w.get(index)) * capacity;
				break;
			}

		}
		return result;
	}

	public static void main(String[] args) {

		FindMaximumHappiness obj = new FindMaximumHappiness();
		List<Integer> happiness = Arrays.asList(4, 8, 10, 2, 5);
		List<Integer> weight = Arrays.asList(4, 4, 20, 8, 16);
		int capacity = 40;
		double maxHapiness = obj.maximumHapiness(happiness, weight, capacity);
		System.out.println("Maximum happiness is " + maxHapiness);
	}
}

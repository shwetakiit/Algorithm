/**
 * @author Shweta Kumari
 *2023-03-09
 */
package kumari.shweta.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*Given a collection of intervals, merge all overlapping intervals.
 * 1 <= Total number of intervals <= 100000.
 * Return the sorted list of intervals after merging all the overlapping intervals.
 * 
 * Eg --[1,3],[2,6],[8,10],[15,18]
 * Result[1,6],[8,10],[15,18]
 * 
 * Merge intervals [1,3] and [2,6] -> [1,6].
   so,the required answer after merging is [1,6],[8,10],[15,18].
  No more overlapping intervals present.
 */

class Interval {
	int start;
	int end;

	public Interval(int x, int y) {

		start = x;
		end = y;
	}

	@Override
	public String toString() {

		return "[" + start + "," + end + "]";
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

}

public class MergeOverlappingElement {

	public static List<Interval> mergeOverLappingElements(List<Interval> intervals) {
		List<Interval> result = new ArrayList<>();
		Comparator<Interval> com = (I1, I2) -> I1.getStart() > I2.getStart() ? 1
				: I1.getStart() < I2.getStart() ? -1 : 0;

		Collections.sort(intervals, com);
		System.out.println(intervals);
		Interval I1 = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval I2 = intervals.get(i);
			if (I2.getStart() > I1.getEnd()) { // Non overlapping case
				result.add(I1);
				I1 = I2;
			} else {  // Overlapping Case
				I1.start = Math.min(I1.start, I2.end);
				I1.end = Math.max(I1.end, I2.end);

			}

		}
		result.add(I1);
		return result;

	}

	public static void main(String[] args) {

		Interval i1 = new Interval(1, 3);
		Interval i2 = new Interval(2, 6);
		Interval i3 = new Interval(8, 10);
		Interval i4 = new Interval(15, 18);

		List<Interval> intervals = new ArrayList<>();
		intervals.add(i1);
		intervals.add(i2);
		intervals.add(i3);
		intervals.add(i4);

		System.out.println("Merged Overlapping" + mergeOverLappingElements(intervals));
		Interval ii1 = new Interval(2, 9);
		Interval ii2 = new Interval(1, 10);
		Interval ii3 = new Interval(3, 8);
		Interval ii4 = new Interval(4, 7);
		Interval ii5 = new Interval(5, 6);
		Interval ii6 = new Interval(6, 6);

		List<Interval> intervals2 = new ArrayList<>();
		intervals2.add(ii1);
		intervals2.add(ii2);
		intervals2.add(ii3);
		intervals2.add(ii4);
		intervals2.add(ii5);
		intervals2.add(ii6);

		System.out.println("Merged overlapping" + mergeOverLappingElements(intervals2));

	}

}

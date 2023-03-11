/**
 * @author Shweta Kumari
 *2023-03-11
 */
package kumari.shweta.array;

import java.util.ArrayList;
import java.util.List;

/*Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
  You may assume that the intervals were initially sorted according to their start times.

Given Interval [[1,5],[8,10],[11,14],[15,20],[20,24]] 
New Interval [[12,22]]
Out put [[1,5][8,10],[11,24]]

*/
public class InsertNewInterval {
	
	public static List<Interval> mergeNewIntervalInGivenIntervals(List<Interval> list,Interval newInterval){
		 //Assume given intervals are in sorted order based on Start in ascending order
		List<Interval> result = new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			Interval I1= list.get(i);
			if(I1.getEnd()<newInterval.getStart()) {
				result.add(I1);
			} else if(I1.getStart()>newInterval.getEnd()) {
				result.add(new Interval(newInterval.getStart(), newInterval.getEnd()));
				for(int j=i;j<list.size();j++) {
					result.add(list.get(j));
				}
				return result;
			} else {
				newInterval.start=Math.min(I1.start,newInterval.start);
				newInterval.end=Math.max(I1.end,newInterval.end);
			}
		}
		result.add(newInterval);
		
		return result;
	}
	
	public static void main(String[] args) {
		Interval i1= new Interval(1, 5);
		Interval i2= new Interval(8, 10);
		Interval i3= new Interval(11, 14);
		Interval i4= new Interval(15, 20);
		Interval i5= new Interval(20, 24);
		List<Interval> intervals= new ArrayList<>();
		intervals.add(i1);intervals.add(i2);intervals.add(i3);intervals.add(i4);intervals.add(i5);
		Interval newInterval= new Interval(12, 22);
		List<Interval> resultList=mergeNewIntervalInGivenIntervals(intervals, newInterval);
		System.out.println("Result after merging newInterval"+resultList);

		
	}

}

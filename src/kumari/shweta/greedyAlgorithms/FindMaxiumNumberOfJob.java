/**
 * @author Shweta Kumari
 *2023-10-04
 */
package kumari.shweta.greedyAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Problem Description
 * There are N jobs to be done, but you can do only one job at a time.
 * Given an array A denoting the start time of the jobs and an array B denoting the finish time of the jobs.
 * Your aim is to select jobs in such a way so that you can finish the maximum number of jobs.
 * Return the maximum number of jobs you can finish.
 * 
 *Problem Constraints 1 <= N <= 10pow5 1 <= A[i] < B[i] <= 10pow9
 *Input Format :---
 *The first argument is an integer array A of size N, denoting the start time of the jobs.
 *The second argument is an integer array B of size N, denoting the finish time of the jobs.
 *
 *Output Format
 *Return an integer denoting the maximum number of jobs you can finish.
 *
 *Input -- A = [1, 5, 7, 1]  B = [7, 8, 8, 8]  output ->2   
 *TC -O(NlogN)  SC->O(N)
 */
class Pair{
	int start;
	int end;
	public Pair(int start,int end) {
		this.start=start;
		this.end=end;
	}
}

public class FindMaxiumNumberOfJob {
	public int findMaxJob(List<Integer> startTime, List<Integer> endTime) {

		List<Pair> pairList = new ArrayList<>();
		for (int i = 0; i < startTime.size(); i++) {
			Pair pair = new Pair(startTime.get(i), endTime.get(i));
			pairList.add(pair);
		}

		// Sort pair on the basis of end time of job in ascending order

		Collections.sort(pairList, Comparator.comparingInt(a -> a.end));

		int result = 1; // Assume minimum 1 job can be done so result=1

		int lastEndTime = pairList.get(0).end; // Assume lastEndTime is end time of first job

		for (int i = 1; i < pairList.size(); i++) {
			if (pairList.get(i).start >= lastEndTime) {

				result++;
				lastEndTime = pairList.get(i).end;
			}

		}

		return result;
	}

	public static void main(String[] args) {

		FindMaxiumNumberOfJob obj = new FindMaxiumNumberOfJob();
		List<Integer> startTime = Arrays.asList(1, 5, 8, 7, 12, 13);
		List<Integer> endTime = Arrays.asList(2, 10, 10, 11, 20, 19);
		int maximumJob = obj.findMaxJob(startTime, endTime);
		System.out.println("Max job can be done is " + maximumJob);
	}
}

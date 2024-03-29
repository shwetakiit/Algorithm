/**
 * @author Shweta Kumari
 *2024-03-29
 */
package kumari.shweta.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
Problem Description
Given a graph with A nodes and C weighted edges. Cost of constructing the graph is the sum of weights of all the edges in the graph.
Find the minimum cost of constructing the graph by selecting some given edges such that we can reach every other node from the 1st node.
NOTE: Return the answer modulo 109+7 as the answer can be large.

Problem Constraints
1 <= A <= 100000
0 <= C <= 100000
1 <= B[i][0], B[i][1] <= N
1 <= B[i][2] <= 109

Input Format
First argument is an integer A.
Second argument is a 2-D integer array B of size C*3 denoting edges. B[i][0] and B[i][1] are connected by ith edge with weight B[i][2]

Output Format
Return an integer denoting the minimum construction cost.

Example Input :A = 3 B = [[1, 2, 14][2, 3, 7][3, 1, 2]] output :9 
Explanation :We can take only two edges (2 -> 3 and 3 -> 1) to construct the graph. we can reach the 1st node from 2nd and 3rd node using only these two edges.
So, the total cost of construction is 9.
*/

public class MiniumCostWithPrimsAlorithm {

	class Pair implements Comparable<Pair> {

		int node;
		int weight;

		Pair(int node, int weight) {
			this.node = node;
			this.weight = weight;

		}

		@Override
		public int compareTo(Pair o) {
			return this.weight - o.weight;
		}

		@Override
		public String toString() {

			return "[" + node + "," + weight + "]";
		}

	}

	public int findMimiumCostPrimsAlgorthm(int A, List<List<Integer>> B) {

		// Prepare Graph from given List of connected edges.
		ArrayList<Pair> ajacencyList[] = new ArrayList[A + 1];

		for (int i = 0; i <= A; i++) {
			ajacencyList[i] = new ArrayList<>();
		}
		/*
		 * Prepare adjacency List which is List of target node and Weight eg 1 -->
		 * [2,14],[3,2] where 2 3 are node and 14 and 2 is weight
		 */

		boolean[] visited = new boolean[A + 1]; // Mark true if node is already visited. Index is node

		PriorityQueue<Pair> minHeap = new PriorityQueue<>();

		for (List<Integer> edge : B) {

			int src = edge.get(0);
			int target = edge.get(1);
			int wt = edge.get(2);

			ajacencyList[src].add(new Pair(target, wt));
			ajacencyList[target].add(new Pair(src, wt));

		}

		for (int i = 0; i < ajacencyList.length; i++) {
			System.out.println(" :" + ajacencyList[i]);
		}

		int sum = 0;
		minHeap.add(new Pair(1, 0));

		while (minHeap.size() > 0) {

			Pair curr = minHeap.poll();
			if (visited[curr.node]) {
				continue;
			}
			sum = sum + curr.weight;
			visited[curr.node] = true;

			// Add neighbor node for curr node in minHeap.
			for (Pair nbr : ajacencyList[curr.node]) {
				if (!visited[nbr.node]) {
					minHeap.add(nbr);
				}
			}
		}
		return sum;

	}

	public static void main(String[] args) {

		// Test case 1
		int A = 3;
		List<Integer> list1 = Arrays.asList(1, 2, 14);
		List<Integer> list2 = Arrays.asList(2, 3, 7);
		List<Integer> list3 = Arrays.asList(3, 1, 2);
		List<List<Integer>> B = new ArrayList<>();
		B.add(list1);
		B.add(list2);
		B.add(list3);
		MiniumCostWithPrimsAlorithm obj = new MiniumCostWithPrimsAlorithm();
		int minCost = obj.findMimiumCostPrimsAlgorthm(A, B);
		System.out.println("Minimum cost of construction " + minCost);

		// Test case 2

		
		  List<Integer> list11 = Arrays.asList(1, 2, 20); List<Integer> list22 =
		  Arrays.asList(2, 3, 17);
		  
		  List<List<Integer>> BB = new ArrayList<>(); BB.add(list11); BB.add(list22);
		  int minCost1 = obj.findMimiumCostPrimsAlgorthm(A, BB);
		  System.out.println("Minimum cost of construction " + minCost1);
		 
	}

}

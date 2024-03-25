/**
 * @author Shweta Kumari
 *2024-03-24
 */
package kumari.shweta.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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
public class FindMiniumConstructionCost {
	static class Pair {
		int u;
		int v;
		int wt;

		public Pair(int u, int v, int wt) {
			this.u = u;
			this.v = v;
			this.wt = wt;
		}
	}

	/* Using Krushkla's Algorithm */

	public int findMimiumCostWithKrushkalsAlgorthm(int A, List<List<Integer>> B) {

		int minWeight = krushkals(A, B);
		return minWeight;

	}

	/**
	 * @param a
	 * @param b
	 * @return
	 */
	private int krushkals(int A, List<List<Integer>> B) {

		int[] parent = new int[A + 1];
		for (int i = 1; i <= A; i++) {
			parent[i] = i;
		}
		// Sort with respect to edge weight
		B.sort((e1, e2) -> e1.get(2).compareTo(e2.get(2)));

		int minCost = 0;
		for (int i = 0; i < B.size(); i++) {
			List<Integer> edge = B.get(i);
			int u = edge.get(0);
			int v = edge.get(1);
			int wt = edge.get(2);

			if (union(u, v, parent)) {
				minCost = minCost + wt;
			}

		}

		return minCost;
	}

	// Find root node of node
	private int findRootNode(int node, int[] parent) {
		while (parent[node] != node) {
			node = parent[node];
		}

		return node;
	}

	/**
	 * Check both u and v are in same set If not merge both node in one set
	 */
	private boolean union(int u, int v, int[] parent) {
		int uRoot = findRootNode(u, parent);
		int vRoot = findRootNode(v, parent);
		if (uRoot == vRoot) { // If both node has same root node It means both are in same set .Not required
								// to merge
			return false;
		}
		if (uRoot < vRoot) { // Merge both set
			parent[vRoot] = uRoot;
		} else {
			parent[uRoot] = vRoot;
		}

		return true;
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
		FindMiniumConstructionCost obj = new FindMiniumConstructionCost();
		int minCost = obj.findMimiumCostWithKrushkalsAlgorthm(A, B);
		System.out.println("Minimum cost of construction " + minCost);

		// Test case 2

		List<Integer> list11 = Arrays.asList(1, 2, 20);
		List<Integer> list22 = Arrays.asList(2, 3, 17);

		List<List<Integer>> BB = new ArrayList<>();
		BB.add(list11);
		BB.add(list22);
		int minCost1 = obj.findMimiumCostWithKrushkalsAlgorthm(A, BB);
		System.out.println("Minimum cost of construction " + minCost1);
	}
}

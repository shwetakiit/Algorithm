/**
 * @author Shweta Kumari
 *2024-03-16
 */
package kumari.shweta.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*Problem Description
Given an directed acyclic graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge uv, vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG.
Return the topological ordering of the graph and if it doesn't exist then return an empty array.
If there is a solution return the correct ordering. If there are multiple solutions print the lexographically smallest one.
Ordering (a, b, c) is said to be lexographically smaller than ordering (e, f, g) if a < e or if(a==e) then b < f and so on.

NOTE:
There are no self-loops in the graph.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global variables make sure to clear them.

Problem Constraints
2 <= A <= 104
1 <= M <= min(100000,A*(A-1))
1 <= B[i][0], B[i][1] <= A

Input Format
The first argument given is an integer A representing the number of nodes in the graph.
The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].

Output Format
Return a one-dimensional array denoting the topological ordering of the graph and it it doesn't exist then return empty array.

Example Input A = 6  B = [  [6, 3] [6, 1] [5, 1] [5, 2] [3, 4] [4, 2] ]
Output -> [5, 6, 1, 3, 4, 2] 

*/
public class TopologicalSort {

	int[] topologicalSorting(int A, List<List<Integer>> B) {

		Queue<Integer> queue = new PriorityQueue<Integer>();

		// Create graph -->Adjacency list --> Array of List
		ArrayList<Integer> adjecyList[] = new ArrayList[A + 1];

		for (int i = 0; i <= A; i++) {
			adjecyList[i] = new ArrayList<Integer>();

		}

		// Add Neighbor for source index
		for (List<Integer> edges : B) { // Prepare array of neighbor like -> 0-[1,3],1->[2,3],2->[4,5]
			int src = edges.get(0);
			adjecyList[src].add(edges.get(1));

		}

		// Find Indegree of All node

		int[] indegree = findIndegreeOfNodes(adjecyList, A);

		/*
		 * Enqueue all element in magic box that is Queue for which indegree is 0 to
		 * complete this course because there is no prerequisite course to complete this
		 * course .
		 */

		for (int i = 1; i <= A; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
			}
		}
		int index = 0;
		int[] sortedData = new int[A];
		while (!queue.isEmpty()) {
			int element = queue.poll();
			sortedData[index++] = element;
			List<Integer> neighborElements = adjecyList[element];// Get all neighbor element for this node and reduce
																	// indegree by 1 because one dependency is removed
																	// due to this course completion.
			for (int i = 0; i < neighborElements.size(); i++) {
				int neighbor = neighborElements.get(i);

				indegree[neighbor]--; // Decrease indegree by 1 .

				// After reducing degree by 1 If indegree turns to 0 then add this node in magic
				// box to finish this course
				if (indegree[neighbor] == 0) {
					queue.add(neighbor);
				}

			}

		}

		return sortedData;
	}

	/**
	 * @param adjecyList
	 * @param A
	 */
	private int[] findIndegreeOfNodes(ArrayList<Integer>[] adjecyList, int A) {
		int indegree[] = new int[A + 1];
		for (int i = 0; i <= A; i++) {
			List<Integer> edges = adjecyList[i];
			for (int neighbor : edges) {
				indegree[neighbor]++;
			}
		}

		return indegree;
	}

	public static void main(String[] args) {

		TopologicalSort obj = new TopologicalSort();
		// Test case 1
		int A = 6;
		List<Integer> e1 = Arrays.asList(6, 3);
		List<Integer> e2 = Arrays.asList(6, 1);
		List<Integer> e3 = Arrays.asList(5, 1);
		List<Integer> e4 = Arrays.asList(5, 2);
		List<Integer> e5 = Arrays.asList(3, 4);
		List<Integer> e6 = Arrays.asList(4, 2);

		List<List<Integer>> edgesList = new ArrayList<>();
		edgesList.add(e1);
		edgesList.add(e2);
		edgesList.add(e3);
		edgesList.add(e4);
		edgesList.add(e5);
		edgesList.add(e6);
		int topologicalSorted[] = obj.topologicalSorting(A, edgesList);
		for (int i = 0; i < topologicalSorted.length; i++) {
			System.out.print(topologicalSorted[i] + " ");
		}
	}

}

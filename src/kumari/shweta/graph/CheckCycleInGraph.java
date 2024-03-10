/**
 * @author Shweta Kumari
 *2024-03-11
 */
package kumari.shweta.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Problem Description
Given an directed graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.

NOTE:
The cycle must contain at least two nodes.
There are no self-loops in the graph.
There are no multiple edges between two nodes.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global variables make sure to clear them.


Problem Constraints
2 <= A <= 105

1 <= M <= min(200000,A*(A-1))

1 <= B[i][0], B[i][1] <= A

Input Format
The first argument given is an integer A representing the number of nodes in the graph.

The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].

Output Format
Return 1 if cycle is present else return 0.

Eg : Input ->A = 5 B = [  [1, 2]  [4, 1] [2, 4] [3, 4]  [5, 2] [1, 3] ] Output - True 
The given graph contain cycle 1 -> 3 -> 4 -> 1 or the cycle 1 -> 2 -> 4 -> 1
*
*/

public class CheckCycleInGraph {

	public boolean findCycleInGraph(int A, ArrayList<List<Integer>> B) {
		ArrayList<Integer> ajacencyList[] = new ArrayList[A + 1]; // Create Array of List

		/*
		 * Fill adjacency list with ArrayList which all are connected nodes with given
		 * source(Index of AjacencyList ) point that is index of adjacency List
		 */
		for (int i = 0; i <= A; i++) {
			ajacencyList[i] = new ArrayList<>();

		}
		for (List<Integer> edges : B) {
			int src = edges.get(0);
			ajacencyList[src].add(edges.get(1)); // Store Connected node for given source which is index of adjacency
													// list

		}

		boolean[] visisted = new boolean[A + 1]; // Size is A+1 because we are excluding 0th index because node is from
													// 1 to A.
		boolean[] path = new boolean[A + 1];// Size is A+1 because ,we are not going to fill 0th index because Adjacency
											// list is also filled from 1 to A index just because of node start from 1
											// to A.

		for (int i = 1; i <= A; i++) {
			if (visisted[i] == false && dfs(ajacencyList, i, visisted, path)) {

				return true;
			}
		}

		return false;

	}

	/**
	 * @param ajacencyList
	 * @param i
	 * @param visited
	 * @param path
	 * @return
	 */
	private boolean dfs(ArrayList<Integer>[] ajacencyList, int src, boolean[] visited, boolean[] path) {

		visited[src] = true; // Mark Visisted and path true for this src point.
		path[src] = true;

		ArrayList<Integer> connectedNodes = ajacencyList[src];

		for (int neghbour : connectedNodes) {

			if (path[neghbour] == true) {// If Visited path is repeating here It means there is cycle .
				return true;
			}
			if (visited[neghbour] == false && dfs(ajacencyList, neghbour, visited, path)) {
				return true;
			}
		}
		path[src] = false;// No cycle found .If above conditions are not true then remove this source from
							// current path .

		return false;
	}

	public static void main(String[] args) {
		CheckCycleInGraph obj = new CheckCycleInGraph();

		// Test case 1:
		int noOfNode = 5;
		List<Integer> e1 = Arrays.asList(1, 2);
		List<Integer> e2 = Arrays.asList(4, 1);
		List<Integer> e3 = Arrays.asList(2, 4);
		List<Integer> e4 = Arrays.asList(3, 4);
		List<Integer> e5 = Arrays.asList(5, 2);
		List<Integer> e6 = Arrays.asList(1, 3);

		ArrayList<List<Integer>> edgesList = new ArrayList<>();
		edgesList.add(e1);
		edgesList.add(e2);
		edgesList.add(e3);
		edgesList.add(e4);
		edgesList.add(e5);
		edgesList.add(e6);

		// Graph Input format is [[][][][]]
		boolean isCycleFound = obj.findCycleInGraph(noOfNode, edgesList);
		System.out.println("Is Cycle in given graph ?" + isCycleFound);

	}

}

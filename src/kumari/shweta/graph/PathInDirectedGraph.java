/**
 * @author Shweta Kumari
 *2024-03-18
 */
package kumari.shweta.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Problem Description
Given an directed graph having A nodes labelled from 1 to A containing M edges given by matrix B of size M x 2such that there is a edge directed from node
B[i][0] to node B[i][1].

Find whether a path exists from node 1 to node A.
Return true if path exists else return false.

NOTE:

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
Return true if path exists between node 1 to node A else return false.
Input example A = 5 B = [  [1, 2] [2, 3] [3, 4]  [4, 5] ]
Output :Path from node1 to node 5 is ( 1 -> 2 -> 3 -> 4 -> 5 ) so we will return 1.
*/
public class PathInDirectedGraph {

	public boolean IsPathExists(int A, List<List<Integer>> B) {

		// Prepare Graph from given List of connected edges.
		ArrayList<Integer> ajacencyList[] = new ArrayList[A + 1];

		for (int i = 0; i <= A; i++) {
			ajacencyList[i] = new ArrayList<>();
		}

		for (List<Integer> edges : B) {
			int src = edges.get(0);
			ajacencyList[src].add(edges.get(1)); // Store Connected node for given source which is index of adjacency
													// list
		}

		// Create visited array and mark true If node is visited
		boolean visited[] = new boolean[A + 1];
		int src = 1;// Need to Search path from 1 to A so start point is 1

		// DFS traversal with start point 1

		dfs(ajacencyList, visited, src);

		if (visited[A] == true) { // If visited array is true at A.It means node A is visited while DFS traversal and path is available between 1 to A
			return true;
		}
		return false;
	}

	/**
	 * @param ajacencyList
	 * @param visited
	 * @param src
	 */
	private void dfs(ArrayList<Integer>[] ajacencyList, boolean[] visited, int src) {
		List<Integer> neighbors = ajacencyList[src];
		for (int node : neighbors) {
			if (visited[node] == false) {
				visited[node] = true;
				dfs(ajacencyList, visited, node);
			}

		}
	}

	public static void main(String[] args) {
		PathInDirectedGraph obj = new PathInDirectedGraph();

		// Test case 1:
		int A = 5;
		List<Integer> e1 = Arrays.asList(1, 2);
		List<Integer> e2 = Arrays.asList(2, 3);
		List<Integer> e3 = Arrays.asList(3, 4);
		List<Integer> e4 = Arrays.asList(4, 5);

		ArrayList<List<Integer>> edgesList = new ArrayList<>();
		edgesList.add(e1);
		edgesList.add(e2);
		edgesList.add(e3);
		edgesList.add(e4);
		boolean isPathExist = obj.IsPathExists(A, edgesList);
		System.out.println("Is path exists between 1 to A ? " + isPathExist);
		
		//Test case 2 :
		
		int A1 = 5;
		List<Integer> e11 = Arrays.asList(1, 2);
		List<Integer> e22 = Arrays.asList(4, 1);
		List<Integer> e33 = Arrays.asList(2, 4);
		List<Integer> e44 = Arrays.asList(3, 4);
		List<Integer> e55 = Arrays.asList(5, 2);
		List<Integer> e66 = Arrays.asList(1, 3);
		

		ArrayList<List<Integer>> edges = new ArrayList<>();
		edgesList.add(e11);
		edgesList.add(e22);
		edgesList.add(e33);
		edgesList.add(e44);
		edgesList.add(e55);
		edgesList.add(e66);
		boolean isPathExist1 = obj.IsPathExists(A1, edges);
		System.out.println("Is path exists between 1 to A ? " + isPathExist1);
		
	}
}

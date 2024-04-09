/**
 * @author Shweta Kumari
 *2024-04-07
 */
package kumari.shweta.graph;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.PriorityQueue;


/*Problem Description
Given a weighted undirected graph having A nodes and M weighted edges, and a source node C.
You have to find an integer array D of size A such that:
D[i]: Shortest distance from the C node to node i.
If node i is not reachable from C then -1.
Note:
There are no self-loops in the graph.
There are no multiple edges between two pairs of vertices.
The graph may or may not be connected.
Nodes are numbered from 0 to A-1.
Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.

Problem Constraints
1 <= A <= 1e5
0 <= B[i][0],B[i][1] < A
0 <= B[i][2] <= 1e3
0 <= C < A

Input Format
The first argument is an integer A, representing the number of nodes in the graph.
The second argument is a matrix B of size M x 3, where each row represents an edge in the graph. The three columns of each row denote the source node B[i][0], the destination node B[i][1], and the weight of the edge B[i][2].
The third argument is an integer C, representing the source node for which the shortest distance to all other nodes needs to be found.

Output Format :Return the integer array D.
Input ->
A = 5
B = [   [0, 3, 4]
        [2, 3, 3] 
        [0, 1, 9] 
        [3, 4, 10] 
        [1, 3, 8]  ] 
C = 4

Output ->D = [14, 18, 13, 10, 0]
*/

public class DijkstraAlgorithm {

	class Pair implements Comparable<Pair> {
		int node;
		int weight;

		/**
		 * @param node
		 * @param weight
		 */
		public Pair(int node, int weight) {

			this.node = node;
			this.weight = weight;
		}

		@Override
		public int compareTo(Pair o) {

			return this.weight - o.weight;
		}
	}

	int[] shortestDistancefromEachNode(int A, int[][] B, int C) {

		// Create adjacencyList for each node --Array of ArrayList which contains node
		// and weight
		ArrayList<Pair>[] adjList = new ArrayList[A + 1];

		PriorityQueue<Pair> pq = new PriorityQueue<>();
		int[] ans = new int[A];
		boolean visited[] = new boolean[A];
		Arrays.fill(ans, Integer.MAX_VALUE);

		for (int i = 0; i <= A; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int[] edge : B) {

			int src = edge[0];
			int target = edge[1];
			int weight = edge[2];
			adjList[src].add(new Pair(target, weight));// In src node add target node and weight
			adjList[target].add(new Pair(src, weight));// In target node add src node and weight

		}
		ans[C] = 0; //For destination point assume weight is 0 .traversing from target to source in graph

		pq.add(new Pair(C, 0));// Node C with 0 weight first time .
		while (pq.size() > 0) {

			Pair current = pq.poll();
			if (visited[current.node]) { // If node is already visited ,Simply Ignore it .
				continue;
			}
			visited[current.node] = true; // Mark visited array as true at index node

			for (Pair pr : adjList[current.node]) {
				if (ans[pr.node] > pr.weight + ans[current.node]) {
					ans[pr.node] = pr.weight + ans[current.node];
					pq.add(new Pair(pr.node, ans[pr.node]));//Push new pair in minheap 
				}
			}
		}
		
		for(int i=0;i<ans.length;i++) { //If at any index where we have not reached while traversing initialize value would be infinity 
			if(ans[i]==Integer.MAX_VALUE) {
				ans[i]=-1;
			}
		}
		return ans;

	}

	public static void main(String[] args) {

		DijkstraAlgorithm obj = new DijkstraAlgorithm();
		int nodeNumber = 5;
		int DestNode = 4;
		int[][] edgeWithWieght = { { 0, 3, 4 }, { 2, 3, 3 }, { 0, 1, 9 }, { 3, 4, 10 }, { 1, 3, 8 } };
		int result[] = obj.shortestDistancefromEachNode(nodeNumber, edgeWithWieght, DestNode);
		for (int i = 0; i < result.length; i++) {
			System.out.println("Result is " + result[i]);
		}
	}
}

/**
 * @author Shweta Kumari
 *2024-03-17
 */
package kumari.shweta.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Problem Description
There are a total of A courses you have to take, labeled from 1 to A.
Some courses may have prerequisites, for example to take course 2 you have to first take course 1, which is expressed as a pair: [1,2].
So you are given two integer array B and C of same size where for each i (B[i], C[i]) denotes a pair.
Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
Return 1 if it is possible to finish all the courses, or 0 if it is not possible to finish all the courses.

Problem Constraints
1 <= A <= 6*104
1 <= length(B) = length(C) <= 105
1 <= B[i], C[i] <= A

Input Format
The first argument of input contains an integer A, representing the number of courses.
The second argument of input contains an integer array, B.
The third argument of input contains an integer array, C.
Output Format
Return 1 (true)if it is possible to finish all the courses, or 0(false) if it is not possible to finish all the courses.
*/

public class PossibiltyOfCourseFinishing {

	boolean isPossibleToFinishCousrse(int N, List<Integer> B, List<Integer> C) {

		List<List<Integer>> list = new ArrayList<>();
		
		//Prepare the list of edges 

		for (int i = 0; i < B.size(); i++) {
			List<Integer> edges = new ArrayList<>();
			edges.add(B.get(i));
			edges.add(C.get(i));
			list.add(edges);
		}
		//System.out.println(list);

		// Prepare Graph -> Adjacency list
		ArrayList<Integer> ajacencyList[] = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			ajacencyList[i] = new ArrayList<>();
		}

		for (List<Integer> neighbors : list) {

			int src = neighbors.get(0);
			ajacencyList[src].add(neighbors.get(1));
		}

		// Check is there cycle in graph .

		boolean isCyclic = isCyclicGraph(N, ajacencyList);

		// If Graph has cycle then impossible to finish course otherwise possible to
		// finish course .
		if (isCyclic) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Check Graph has Cycle or not
	 * 
	 * @param n
	 * @param ajacencyList
	 * @return
	 */
	private boolean isCyclicGraph(int N, ArrayList<Integer>[] ajacencyList) {
		boolean[] visisted = new boolean[N + 1];
		boolean[] path = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			if (visisted[i] == false && dfs(ajacencyList, i, visisted, path)) {

				return true;
			}
		}

		return false;
	}

	/**
	 * @param ajacencyList
	 * @param i
	 * @param visisted
	 * @param path
	 * @return
	 */
	private boolean dfs(ArrayList<Integer>[] ajacencyList, int src, boolean[] visited, boolean[] path) {
		visited[src] = true; // Mark Visited and path true for this src point.
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
		path[src] = false;// No cycle found .If above conditions are not true then remove this source from current path .

		return false;
	}

	public static void main(String[] args) {
		PossibiltyOfCourseFinishing obj = new PossibiltyOfCourseFinishing();

		int A = 3;
		List<Integer> e1 = Arrays.asList(1, 2);
		List<Integer> e2 = Arrays.asList(2, 3);
		boolean isPossibleToFinish = obj.isPossibleToFinishCousrse(A, e1, e2);
		System.out.println("Is possible to finish courses ? " + isPossibleToFinish);

	}

}

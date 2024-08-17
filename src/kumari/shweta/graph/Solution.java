/**
 * @author Shweta Kumari
 *2024-03-29
 */
package kumari.shweta.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Shweta Kumari
 *
 */
public class Solution {
	
	 public class Pair implements Comparable<Pair>
	    {
	        int wt, x;
	        Pair(int x, int wt){
	            this.wt = wt;
	            this.x = x;
	        }
	        public int compareTo(Pair pair){
	            return this.wt-pair.wt;
	        }
	        @Override
	        public String toString() {
	        // TODO Auto-generated method stub
	        return "["+x+","+wt+"]";
	        }
	    }
	    public int solve(int A, int[][] B) {
	        int mod = 1000000007;
	        ArrayList<Pair>[] adjList = new ArrayList[A+1];
	        boolean[] visited = new boolean[A+1];
	        PriorityQueue<Pair> minHeap = new PriorityQueue<>();

	        for(int i=0; i<=A; i++){
	            adjList[i] = new ArrayList<>();
	        }

	        for(int[] i : B){
	            int v = i[0];
	            int e = i[1];
	            int w = i[2];

	            adjList[e].add(new Pair(v, w));
	            adjList[v].add(new Pair(e, w));
	        }
	        
	        for(int i =0;i<adjList.length;i++) {
	        	System.out.println(adjList[i]);
	        }

	        int sum = 0;
	        minHeap.add(new Pair(1, 0));

	        while(minHeap.size() > 0){
	            Pair curr = minHeap.poll();
	            if(visited[curr.x]){
	                continue;
	            }
	            sum = (sum + curr.wt)%mod;
	            visited[curr.x] = true;

	            for(Pair nbr : adjList[curr.x]){
	                if(!visited[nbr.x]){
	                    minHeap.add(nbr);
	                }
	            }
	        }
	        return sum%mod;
	    }

	    
public static void main(String[] args) {
	int A = 3;
	int b[][]= {
			{1, 2, 14},{2, 3, 7},{3, 1, 2}
	};
	//List<Integer> list1 = Arrays.asList(1, 2, 14);
	//List<Integer> list2 = Arrays.asList(2, 3, 7);
	//List<Integer> list3 = Arrays.asList(3, 1, 2);
	//List<List<Integer>> B = new ArrayList<>();
	//B.add(list1);
	//B.add(list2);
	//B.add(list3);
	Solution obj = new Solution();
	int minCost = obj.solve(A,b);
	System.out.println("Minimum cost of construction " + minCost);

	
}
}

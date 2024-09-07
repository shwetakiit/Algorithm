/**
 * @author Shweta Kumari
 *2024-09-07
 */
package kumari.shweta.recursion;

import java.util.ArrayList;
import java.util.List;

/*Problem Description
 
In the classic problem of the Towers of Hanoi, 
you have 3 towers numbered from 1 to 3 (left to right) and A disks numbered from 1 to A (top to bottom) of different sizes which can slide onto any tower.
The puzzle starts with disks sorted in ascending order of size from top to bottom (i.e., each disk sits on top of an even larger one).
You have the following constraints:

Only one disk can be moved at a time.
A disk is slid off the top of one tower onto another tower.
A disk cannot be placed on top of a smaller disk.
You have to find the solution to the Tower of Hanoi problem.
You have to return a 2D array of dimensions M x 3, where M is the minimum number of moves needed to solve the problem.
In each row, there should be 3 integers (disk, start, end), where:

disk - number of the disk being moved
start - number of the tower from which the disk is being moved
end - number of the tower to which the disk is being moved


Problem Constraints
1 <= A <= 18


Input Format
The first argument is the integer A.


Output Format
Return a 2D array with dimensions M x 3 as mentioned above in the description.


Example Input
Input 1:
A = 2
Input 2:

A = 3
*/
public class TowerOfHanoi {
	
	//TC -O(2^N) sc ->O(N) 
	List<ArrayList<Integer>> towerOfHanoi(int noOfDisk) {

		List<ArrayList<Integer>> result = new ArrayList<>();
		towerOfHanoi(noOfDisk, 1, 3, 2, result);
		return result;
	}

	private void towerOfHanoi(int noOfDisk, int source, int destination, int helper, List<ArrayList<Integer>> result) {

		if (noOfDisk == 0) {
			return;
		}
		towerOfHanoi(noOfDisk - 1, source, helper, destination, result);
		ArrayList<Integer> subTower = new ArrayList<>();

		subTower.add(noOfDisk);
		subTower.add(source);
		subTower.add(destination);
		//subTower.add(helper);
		result.add(subTower);
		towerOfHanoi(noOfDisk - 1, helper, destination, source, result);
	}

	public static void main(String[] args) {

		TowerOfHanoi obj = new TowerOfHanoi();
		int noOfDisk = 3;
		List<ArrayList<Integer>> resIntegers = obj.towerOfHanoi(noOfDisk);
		System.out.println(resIntegers);
	}

}

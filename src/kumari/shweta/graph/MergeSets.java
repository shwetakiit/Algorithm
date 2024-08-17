/**
 * @author Shweta Kumari
 *2024-03-21
 */
package kumari.shweta.graph;

import java.util.Arrays;
import java.util.List;

public class MergeSets {
	
	public int mergeAllSet( int elements[],int parents[]){
	
		for(int element :elements) {
			while(parents[element]!=element) {
			   element=parents[element];
			}
			return element;
		}
		
	}
	
	public static void main(String[] args) {
		
	List<Integer> elements= Arrays.asList(1,2,3,4);
	List<Integer> parents = Arrays.asList(1,2,3,4); // Initially each node  has same node as parent.
	MergeSets obj = new MergeSets();
	obj.mergeAllSet(elements,parents);
	
	}

}

package kumari.shweta.LinkedList;

import java.util.HashSet;
import java.util.Iterator;



public class CustomDSWithOutDuplicate {
	
HashSet<Integer> set ;

	CustomDSWithOutDuplicate(){
		set=new HashSet<Integer>();
		
	}
	public boolean insert(int element) {
		return set.add(element);
	}
	
	public boolean remove(int element) {
		
		return set.remove(element);
	}
	
	public boolean search(int element) {
		return set.contains(element);
		
	}

	public static void main(String[] args) {
		
		CustomDSWithOutDuplicate obj = new CustomDSWithOutDuplicate();
		for(int i =0;i<5;i++) {
		boolean isInserted=	obj.insert(i);
		System.out.println(isInserted);
		}
	
		boolean isRemoved=obj.remove(4);
		System.out.println("Is removed "+isRemoved);
		
		HashSet<Integer> set = obj.set;
		Iterator<Integer> itr = set.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}

		
		
		
		
	}

}

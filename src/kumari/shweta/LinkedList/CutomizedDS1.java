package kumari.shweta.LinkedList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

//https://www.programcreek.com/2014/08/leetcode-insert-delete-getrandom-o1-java/

public class CutomizedDS1 {
	HashMap<Integer, HashSet<Integer>> map1;
    HashMap<Integer, Integer> map2;
    Random r;
  /** Initialize your data structure here. */
    public CutomizedDS1() {
            map1 = new HashMap<Integer, HashSet<Integer>>();
            map2 = new HashMap<Integer, Integer>();
            r = new Random();
    }
 
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        //add to map2
        int size2 = map2.size();
        map2.put(size2+1, val);
 
        if(map1.containsKey(val)){
            map1.get(val).add(size2+1); // Sadding another value in set eg [4,6]
            return false;
        }else{
            HashSet<Integer> set = new HashSet<Integer>();
            set.add(size2+1);
            map1.put(val, set);
            return true;
        }
    }
 
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(map1.containsKey(val)){
            HashSet<Integer> set = map1.get(val);
            int toRemove = set.iterator().next();
            //remove from set of map1
            set.remove(toRemove);
 
            if(set.size()==0){
                map1.remove(val);
            }
 
            if(toRemove == map2.size()){ //Check in which condition it will come herre ithink if we add duplicate for last element
                map2.remove(toRemove);   //if set vaue is last index eg 5,6 so 6 return insted of 5
                return true;
            }
 
            int size2 = map2.size();
            int key = map2.get(size2);
 
            HashSet<Integer> setChange = map1.get(key);
            setChange.remove(size2);
            setChange.add(toRemove);
            map2.remove(size2);
         //  map2.remove(toRemove);
           // map2.put(toRemove, key);
 
            return true;
        }
 
        return false;
    }
 
    /** Get a random element from the collection. */
    public int getRandom() {
        if(map2.size()==0)
            return -1;
 
         if(map2.size()==1){
            return map2.get(1);    
        }    
 
        return map2.get(r.nextInt(map2.size())+1); // nextInt() returns a random number in [0, n).
    }
    public static void main(String[] args) {
    	CutomizedDS1 cutomizedDS1 = new CutomizedDS1();
    	for(int i =0 ;i<5;i++) {
    	boolean isInserted=	cutomizedDS1.insert(i);
    	System.out.println(isInserted);}
    	boolean isInserted1=cutomizedDS1.insert(3);
    	System.out.println(isInserted1);
    	boolean isRemoved=cutomizedDS1.remove(3);
    	System.out.println("IS removed "+isRemoved);
    	int k =cutomizedDS1.getRandom();
    	System.out.println("Random value is "+k);
    	
    	
	}
}

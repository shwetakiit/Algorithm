/**
 * @author Shweta Kumari
 *2023-03-29
 */
package kumari.shweta.twoDmatrics;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author Shweta Kumari
 *
 */

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.*;
import java.lang.*;
public class HashMapPOC {
	
	public static void main(String[] args) {

    	Map<Integer, String[]> map= new HashMap<Integer, String[]>();
   		map.put(1,new String[] {"shweta"});
	map.put(2, new String[] {"kumari"});
	Map<Integer, String[]> im=Collections.unmodifiableMap(map);
//Map<Integer, String[]> im =Map.copyOf(map);
	System.out.println(im);
	
	im.get(1)[0]=	im.get(1)[0].substring(0,2);
  System.out.println(im);
  Set s= im.entrySet();
  Iterator it = s.iterator();
  while(it.hasNext()){
      Map.Entry<Integer,String[]> entry=(Map.Entry<Integer,String[]>)it.next();
      
      Integer key=entry.getKey();
      String[] value=entry.getValue();
      for(int i=0;i<value.length;i++){
          System.out.println("key "+key+" value "+ value[i]);
      }
      
  }
 
	
}
		
		
		
	}


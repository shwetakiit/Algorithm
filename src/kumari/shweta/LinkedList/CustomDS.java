package kumari.shweta.LinkedList;
/**
 * @author Shweta Kumari
 * @Email id shwetakumarikiit0729@gmail.com
 *
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class CustomDS {
	HashMap<Integer, HashSet<Integer>> map1;
	HashMap<Integer, Integer> map2;
	Random random;
	public CustomDS() {
		map1 = new HashMap<>();
		map2 = new HashMap<>();
		random = new Random();

	}
	public boolean insert(int element) {
		int size = map2.size();
		map2.put(size + 1, element);
		if (map1.containsKey(element)) {

			map1.get(element).add(size + 1);
			return false;

		} else {
			HashSet<Integer> set = new HashSet<>();
			set.add(size + 1);
			map1.put(element, set);
			return true;

		}
	}

	public boolean remove(int element) {

		if (map1.containsKey(element)) {
			HashSet<Integer> set = map1.get(element);
			int toRemove = set.iterator().next();
			set.remove(toRemove);
			if (toRemove == map2.size()) {
				map2.remove(toRemove);
				return true;
			}
			if (set.size() == 0) {
				map1.remove(element);
			}

			int size = map2.size();
			int key = map2.get(size);
			HashSet<Integer> setChange = map1.get(key);
			setChange.remove(size);
			setChange.add(toRemove);
			map2.remove(size);
			return true;
		}

		return false;

	}

	public int getRandom() {

		if (map2.size() == 0) {
			return -1;
		} else if (map2.size() == 1) {

			return map2.get(1);
		} else {
			return map2.get(random.nextInt(map2.size()) + 1);

		}

	}

	public static void main(String[] args) {
		CustomDS customDS = new CustomDS();
		for (int i = 0; i < 5; i++) {
			customDS.insert(i);
		}
		System.out.println(customDS.map1);
		System.out.println(customDS.map2);
        customDS.insert(3);
		System.out.println(customDS.map1);
		System.out.println(customDS.map2);
		System.out.println("Aftre removing");
		customDS.remove(3);
		System.out.println(customDS.map1);
		System.out.println(customDS.map2);
		System.out.println("Return random value ");
		int randomNumber = customDS.getRandom();
		System.out.println("Random number is " + randomNumber);
	}
}

/**
 * @author Shweta Kumari
 *2024-07-13
 */
package kumari.shweta.Queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*Problem Description
Imagine you're a teacher. You ask students to call out a letter one by one. After each letter, you jot down the very first letter that's only been called out once. If all letters have been repeated, you write "#".

Here's a scenario:

A student says "a". It's the first letter. You write "a".
Next, a student says "b", "a" is still unique, so you add "a". Now it's "aa".
A student says "a" again. Now, "b" is the unique one. You add "b", making it "aab".
A student says "b". All letters so far are repeated. You add "#". It becomes "aab#".
A student says "c". "c" is unique. You add "c". The final is "aab#c".
Your task? Given the sequence the students call out A, determine the string on the board.



Problem Constraints
1 <= |A| <= 100000


Input 1:

 A = "abadbc" Output- "aabbdd" 
 Input 2:

 A = "abcabc" output - "aaabc#"
*/

public class UniqueLetter {

	public static String printUniqueLetter(String str) {

		Map<Character, Integer> map = new HashMap<>();
		String result = "";
		Queue<Character> queue = new LinkedList<>();
		for (int i = 0; i < str.length(); i++) {
			Character character = str.charAt(i);
			queue.offer(character);
			if (map.containsKey(character)) {
				map.put(character, map.get(character) + 1);

			} else {
				map.put(character, 1);

			}

			while (!queue.isEmpty() && map.get(queue.peek()) > 1) {
				queue.poll();
			}
			if (!queue.isEmpty()) {
				result = result + queue.peek();
			} else {
				result = result + "#";
			}
		}
		return result;

	}

	public static void main(String[] args) {

		String input = "iergxwhddh";
		String genUniqueString = printUniqueLetter(input);
		System.out.println("Generated Unique string is " + genUniqueString);

	}
}

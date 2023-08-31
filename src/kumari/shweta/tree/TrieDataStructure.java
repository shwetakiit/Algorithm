/**
 * @author Shweta Kumari
 *2023-08-29
 */
package kumari.shweta.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Given an array of words A (dictionary) and another array B (which contain
 * some words). You have to return the binary array (of length |B|) as the
 * answer where 1 denotes that the word is present in the dictionary and 0
 * denotes it is not present. Formally, for each word in B, you need to return
 * "true" if it is present in Dictionary and "false" if not. Such problems can be
 * seen in real life when we work on any online editor (like Google Document),
 * if the word is not valid it is underlined by a red line.
 *  NOTE: Try to do this in O(n) time complexity.
 * 
 * Result should be like list of true/false for each word .valid word ->true
 * ,invalid word ->false
 *
 */

class Trie {
	char data;
	boolean eow;
	Trie[] childern;

	public Trie(char ch) {
		data = ch;
		childern = new Trie[26]; // child node which can be a to z so we are creating array of node .Which can
									// contain a to z on respective index
		eow = false; // end of word by default is false for each node (character of word)
	}
}

public class TrieDataStructure {

	public List<Boolean> searchWordInDictionary(List<String> dictionary, List<String> wordList) {

		/*
		 * Dummy node created which will root node of starting character of each word in
		 * given dictionary list
		 */
		Trie root = new Trie('1');

		// Prepare trie for each word available in dictionary
		for (int i = 0; i < dictionary.size(); i++) {
			insert(root, dictionary.get(i));
		}
		// Search given word in wordList in dictionary using with trie data structure

		List<Boolean> result = new ArrayList<>();
		for (int i = 0; i < wordList.size(); i++) {
			result.add(search(root, wordList.get(i)));
		}

		return result;
	}

	/**
	 * Prepare "trie data structure" for given word --> Insert all word in trie
	 * TC -O(length of word) sc ->O(length of word)
	 */
	private void insert(Trie root, String word) {
		Trie current = root;

		for (int i = 0; i < word.length(); i++) {
			int idx = word.charAt(i) - 'a'; // Calculate index for this character from word for storing in reference
											// node array
			if (current.childern[idx] == null) {
				current.childern[idx] = new Trie(word.charAt(i));
			}
			current = current.childern[idx];

		}
		current.eow = true; // Mark end of word character as true
	}

	public boolean search(Trie root, String word) {

		Trie current = root;
		for (int i = 0; i < word.length(); i++) {
			int idx = word.charAt(i) - 'a';
			if (current.childern[idx] == null) { // If char of this word is not available on this index , It means this
													// word is not available .return false
				return false;
			}
			current = current.childern[idx];
		}
		return current.eow; // If last character of word is eow i.e. true return true .If that is not eow It
							// means this word is prefix for some other word available in dictionary
	}
	
	/**
	 * Delete word from dictionary  TC -> O(length of word) SC -> O(1)
	 * @param dictionary
	 * @param word
	 * @return
	 */

	protected boolean deleteWordFromDisctionary(List<String> dictionary, String word) {

		Trie root = new Trie('1');

		for (int i = 0; i < dictionary.size(); i++) {
			insert(root, dictionary.get(i));
		}

		// Before deleting word check word is available or not in dictionary
		boolean isWordExist = search(root, word);
		if (!isWordExist) {
			System.out.println("Word doesn't exist in dictionary");
			return false;
		}

		Trie resultTrie = deleteWord(root, word);

		/*
		 * After deleting word from trie data structure (dictionary) search the word in
		 * trie data structure for printing result to check word deleted or not
		 */

		boolean isWordDeleted = search(resultTrie, word) == false ? true : false;

		return isWordDeleted;
	}

	protected Trie deleteWord(Trie root, String word) {

		Trie current = root;
		Trie temp = null;
		char nearestChar = '_';
		for (int i = 0; i < word.length(); i++) {
			int count = 0;
			for (int j = 0; j < 26; j++) {
				if (current.childern[j] != null) {
					count++;
				}
			}
			if (count > 1 || current.eow == true) {
				temp = current;
				nearestChar = word.charAt(i);
			}
			int idx = word.charAt(i) - 'a'; // find index of target character
			current = current.childern[idx];

		}
		current.eow = false;
		int count = 0;
		for (int j = 0; j < 26; j++) {
			if (current.childern[j] != null) {
				count++;
			}
		}
		if (count > 0) {
			return root;
		} else {
			temp.childern[nearestChar - 'a'] = null;
		}
		return root;

	}
	public static void main(String[] args) {

		TrieDataStructure obj = new TrieDataStructure();
		List<String> disctionary = Arrays.asList("try", "trime", "tree", "play", "trying", "plate", "cat", "care",
				"par", "trimmer", "pla", "trie");
		List<String> wordList = Arrays.asList("car", "tried", "try", "trie");
		List<Boolean> result = obj.searchWordInDictionary(disctionary, wordList);
		System.out.println("Find result of each word is found :true and  not found :false -->" + result);
       
		// Delete word from Dictionary list
		boolean isWordDeleted = obj.deleteWordFromDisctionary(disctionary, "try");
		System.out.println("Word deleted?  " + isWordDeleted);

	}

}

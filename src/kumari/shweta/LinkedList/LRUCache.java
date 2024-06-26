/**
 * @author Shweta Kumari
 *  2024-06-26
 */


package kumari.shweta.LinkedList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following
   The LRUCache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum
   number of unique keys it can hold at a time.
   Definition of "least recently used" : item is the one with the oldest access time.
*/

public class LRUCache {

	Map<Integer, DoublyNode> map = new HashMap<>();

	// Create two dummy node head and tail 
	DoublyNode head = new DoublyNode(-1);
	DoublyNode tail = new DoublyNode(-1);

	int capacity;

	public LRUCache(int capacity) {
		
		System.out.println("LRU maximum capacity is "+capacity);
		this.capacity = capacity;
		head.next = tail;
		tail.prev = head;
	}

	public DoublyNode addToCache(int data) {

		if (map.containsKey(data)) {

			DoublyNode cureNode = map.get(data);
			deleteNode(cureNode);
			// Traverse to check the current LRU cache
			System.out
					.println("\n Now add new data " + data + " in LRU cache. This data is already available in cache");
			System.out.println(
					" \n Deleting the data which is already in cache and add in tail of LRU to maintain Least recently added order");
			traversal();
			System.out.println("\n Adding the data which was deleted from cache " + data);
			insertAtTail(cureNode);
			traversal();

		} else {
			if (map.size() == capacity) {

				DoublyNode toRemove = head.next;
				System.out.println("LRU cache is full with maxium cacpacity Please delete least recently added data "
						+ data + "\n");
				deleteNode(toRemove);

				System.out.println(
						"After deleteing Least recently added data to make space for adding new data in cache");
				traversal();
			}

			DoublyNode newNode = new DoublyNode(data);
			System.out.println("\n Now add new data in cache \n");
			insertAtTail(newNode);
			System.out.println("After adding new data " + data + " in tail of LRU cache \n ");
			traversal();
			map.put(data, newNode);

		}
		return head;
	}

	public void traversal() {

		DoublyNode temp = head;
		while (temp != null) {
			if (temp.data != -1)
				System.out.print(temp.data + " ");
			temp = temp.next;

		}
	}

	private DoublyNode insertAtTail(DoublyNode node) {

		node.next = tail;
		node.prev = tail.prev;
		tail.prev = node;
		node.prev.next = node;
		return head;

	}

	private DoublyNode deleteNode(DoublyNode node) {

		node.prev.next = node.next;
		node.next.prev = node.prev;
		return head;

	}

	public static void main(String[] args) {

		LRUCache lruCache = new LRUCache(5);
		List<Integer> elements = Arrays.asList(10, 15, 19, 20, 15, 18, 23, 20, 19);
		for (Integer data : elements) {
			lruCache.addToCache(data);
		}
	}
}

/**
 * @author Shweta Kumari
 *2024-07-02
 */
package kumari.shweta.Queue;

import java.util.Scanner;

/**
 * Circular queue implementation using array. 
 */
public class CircularQueueImplemention {

	int capacity;
	int queue[];
	int front = -1;
	int rear = -1;
	int size;

	CircularQueueImplemention(int capacity) {

		this.capacity = capacity;
		this.queue = new int[capacity];
		size = 0;
	}

	public void enqueue(int element) {

		if (isFull()) {
			System.out.println("Queue is full");
			return;

		}

		size++;
		rear = (rear + 1) % capacity;
		queue[rear] = element;

	}

	public Integer dequeue() {

		if (front == rear && size == 0) {
			System.out.println("Queue is empty");
			return null;

		}
		front = (front + 1) % capacity;
		size--;
		return queue[front];

	}

	public Integer peek() {

		if (isEmpty()) {
			System.out.println("Queue is empty");
		}
		int index = (front + 1) % capacity;
		return queue[index];

	}

	public boolean isFull() {

		if ((front == 0 && rear == capacity - 1) || (front == rear && size == capacity)) {
			return true;

		} else {
			return false;
		}
	}

	public boolean isEmpty() {

		if (front == rear && size != capacity) {
			return true;
		} else {
			return false;
		}
	}

	public void display() {

		if (isEmpty()) {
			System.out.println("Queue is empty");

			return;
		}

		int i = front + 1;
		if (front + 1 <= rear) {

			while (i <= rear) {
				System.out.print(queue[i] + " ");
				i++;
			}
		} else {

			while (i < capacity) {
				System.out.print(queue[i] + "");
				i++;
			}
			i = 0;
			while (i <= rear) {

				System.out.println(queue[i] + " ");
				i++;
			}
		}

	}

	public static void main(String[] args) {

		int choice = 5;
		int capacity = 5;
		CircularQueueImplemention obj = new CircularQueueImplemention(capacity);
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Enter the choice");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Entere the item to be pushed");
				Integer element = scanner.nextInt();
				obj.enqueue(element);
				obj.display();
				break;
			case 2:
				System.out.println("Delete the element");
				element = obj.dequeue();
				if (element != null) {
					System.out.println("Deleted item is " + element + "\n");
				}
				obj.display();
				break;

			case 3:
				System.out.println("Print front element" + obj.peek());
				break;
			case 4:
				obj.display();
				break;

			case 5:
				System.exit(0);

			default:
				System.out.println("Wrong choice");
			}

		}

	}
}

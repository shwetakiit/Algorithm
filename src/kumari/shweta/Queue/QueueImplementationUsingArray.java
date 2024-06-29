/**
 * @author Shweta Kumari
 *2024-06-29
 */
package kumari.shweta.Queue;

import java.util.Scanner;

/* Queue implementation using Array*/
public class QueueImplementationUsingArray {

	int capacity;
	int queue[];
	int front = -1;
	int rear = -1;

	QueueImplementationUsingArray(int capacity) {

		this.capacity = capacity;
		this.queue = new int[capacity];

	}

	public void enqueue(int element) {
		if (rear == capacity - 1) {
			System.out.println("Queue is full");
		} else {
			rear++;
			queue[rear] = element;
		}

	}

	public Integer dequeue() {

		if (front == rear) {
			System.out.println("Queue is empty");
			return null;

		}
		front = front + 1;

		return queue[front];

	}

	public Integer peek() {

		if (front == rear) {
			System.out.println("Queue is empty");
			return null;
		}

		return queue[front + 1];

	}

	public void display() {
		if (front == rear) {
			System.out.println("Queue is empty");
		}
		for (int i = front + 1; i <= rear; i++) {
			System.out.print(queue[i] + " ");
		}
	}

	public static void main(String[] args) {
		int choice = 5;
		int capacity = 5;
		QueueImplementationUsingArray obj = new QueueImplementationUsingArray(capacity);
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

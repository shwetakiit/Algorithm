/**
 * @author Shweta Kumari
 *2024-07-04
 */
package kumari.shweta.Queue;

import java.util.Scanner;
import java.util.Stack;

/**
 * Implement Queue using stack Queue feature delete from front and Insert from
 * rear
 *
 */
public class QueueImplementationUsingStack {

	Stack<Integer> stack1;
	Stack<Integer> stack2;

	QueueImplementationUsingStack() {
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}

//TC ->O(1)
	private void enqueue(Integer element) {

		stack1.push(element);
	}

	private void display() {

		// First print all element of stack 2
		while (!stack2.isEmpty()) {
			System.out.println(stack2.pop() + " ");

		}

		// Put all element of stack 1 to stack2 to maintain the order
		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}

		// Again print the stack2 element
		while (!stack2.isEmpty()) {
			System.out.println(stack2.pop() + " ");
		}
	}

//TC ->O(1)
	private Integer dequeue() {
		if (stack2.isEmpty()) {

			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}

	private Integer peek() {
		if (!stack2.isEmpty()) {
			return stack2.peek();
		} else {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}

		if (stack2.isEmpty()) {
			return null;
		}
		return stack2.peek();

	}

	public static void main(String[] args) {

		QueueImplementationUsingStack obj = new QueueImplementationUsingStack();

		Scanner scanner = new Scanner(System.in);

		while (true) {

			System.out.println("1. Enqueue");
			System.out.println("2.Dequeue");
			System.out.println("3.Peek");
			System.out.println("4.Display");
			System.out.println("5.Quit");
			System.out.println("Enter the choice.");

			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Entere the item to be pushed");
				Integer element = scanner.nextInt();
				obj.enqueue(element);
				break;
			case 2:
				System.out.println("Delete the element");
				element = obj.dequeue();
				System.out.println("Deleted element from front of queue is" + element);
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

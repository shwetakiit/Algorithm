/**
 * 
 */
package kumari.shweta.LinkedList;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Shweta kumari
 *
 */
public class CreateStackUsingQueue {

	static class Stack {
		static Queue<Integer> q1 = new LinkedList<Integer>();
		static Queue<Integer> q2 = new LinkedList<Integer>();
		static int currentSize = 0;

		public void push(int x) {
			// Removing data from q1 and adding in q2
			while (!q1.isEmpty()) {
				q2.add(q1.peek());
				q1.remove();
			}

			// added x in q1
			q1.add(x);
			// now adding removed data from q2 to 1
			while (!q2.isEmpty()) {
				q1.add(q2.peek());
				q2.remove();

			}
		}

		public void pop() {
			if (q1.isEmpty()) {
				System.out.println("Stack underflow ");
			} else {
				while (!q1.isEmpty()) {
					q1.remove();
				}

			}
		}

		public int top() {
			if (q1.isEmpty()) {
				return -1;
			} else {
				return q1.peek();
			}
		}

	}
	
	//Using pop operation
	static class StackWithPop{
		static Queue<Integer> q1= new LinkedList<Integer>();
		static Queue<Integer> q2 = new LinkedList<Integer>();
		
		public void push(int x) {
			q1.add(x);
		}

		public void pop() {

			if (q1.isEmpty()) {
				System.out.println("Stack underflow");
			} else {
				while (q1.size() != 1) {
					q2.add(q1.peek());
					q1.remove();
				}
				q1.remove();
				while (!q2.isEmpty()) {
					q1.add(q2.peek());
					q2.remove();
				}
			}

		}
		
		public int top() {
			if(q1.isEmpty()) {
				return -1;
			} else {
				
				while(q1.size()!=1) {
					q2.add(q1.peek());
					q1.remove();
				}
				int temp=q1.peek();
				q1.remove();
				q2.add(temp);
				return temp;
				
			}
			
		}
		
		
		
	}
	

	public static void main(String[] args) {
		
		//Stack using push operation in Queue 
       /*
		Stack stack = new Stack();
		for (int i = 0; i <= 5; i++) {
			stack.push(i);
		}
		System.out.println(stack.q1);
		int topelement = stack.top();
		System.out.println("Top element is " + topelement);
		stack.pop();
		*/
		
		//Stack using pop operation in Queue
		
		StackWithPop stackWithPop= new StackWithPop();
		for(int i =0;i<=5;i++) {
		stackWithPop.push(i);
			
		}
		System.out.println(stackWithPop.q1);
		int topelement=stackWithPop.top();
		System.out.println("Top element is "+topelement);
	
		
		System.out.println("After pop");
		System.out.println(stackWithPop.q1);
		int topelement1=stackWithPop.top();
		System.out.println("Top element is "+topelement1);
		
	}

}

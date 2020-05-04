package semester2;
/**
 * Ex2 
 * @author Jessica Blau
 * 
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ex2 {
	public static void main (String[]args) {
		Stack<Integer> s1 = new Stack<Integer>(); // creating a stack 
		s1.push(1);// pushing each digit in to the stack
		s1.push(4);
		s1.push(11);
		s1.push(9);
		s1.push(13);
		s1.push(4);
		s1.push(8);
		s1.push(2);
		System.out.println(maxsum(s1));// printing the result of function maxsum
		Stack<Integer> s2 = new Stack<Integer>();
		s2.push(7);// pushing each digit in to the stack
		s2.push(6);
		s2.push(14);
		s2.push(8);
		s2.push(12);
		s2.push(9);
		s2.push(7);
		Stack<Integer> s3 = new Stack<Integer>();// creating a stack 
		s3.push(11);
		s3.push(9);
		s3.push(1);
		s3.push(4);
		s3.push(13);
		s3.push(4);
		s3.push(8);
		s3.push(2);
		System.out.println(topbig(s3 , s2));// printing the result of the function topbig
		Stack<Integer> s4 = new Stack<Integer>();
		s4.push(0);
		s4.push(1);
		s4.push(3);
		s4.push(5);
		s4.push(8);
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		func2(q, s4);
	}
	// Question 1 - A
	public static int maxsum(Stack<Integer> s) {
		int maxsum = 0;
		Stack<Integer> s2 = new Stack<Integer>();
		s2.push(s.pop());
		while (!s.empty()) {
			int sum = s.peek() + s2.peek();
			if (sum > maxsum) {
				maxsum = sum;
			}
			s2.push(s.pop());
		}
		while (!s2.empty()) {
			s.push(s2.pop());
		}
		return maxsum;// returning the largest sum
	}
	// Question 1 - B
	public static int topbig(Stack<Integer> s2, Stack<Integer> s1) {
		int maxS2 = maxsum(s2);// finding the maxsum of s1
		int sum = 0;
		while(!s1.empty()) {
			sum = s1.pop() + s1.peek();
			if (sum > maxS2) {
				return sum;
			}
		}
		return 0;
	}
	// Question 2
	public static void func2(Queue<Integer> q, Stack<Integer> s) {
		Stack<Integer> s1 = new Stack<Integer>();// creating a empty stack
		while (!s.empty()) {
			s1.push(s.pop());
		}
		while (!q.isEmpty() && s1.empty()) {
			s.push(q.remove());
		}
		while (!s1.empty() && !q.isEmpty()) {
			if (s1.peek() > q.peek()) {
				s.push(q.remove());
			}
			else
				s.push(s1.pop());
		}
		while (!s1.empty() && q.isEmpty()) {
				s.push(s1.pop());
		}
		System.out.println(s.toString());// prints the orginial stack with all the digits organized by value 
	}
}

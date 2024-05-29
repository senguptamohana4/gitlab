package com.assignments;
import java.util.Stack;

public class StackSorter {
	public static void sortStack(Stack<Integer> stack) {
		Stack<Integer> tempStack = new Stack<>();
		
		while(!stack.isEmpty()) {
			int current = stack.pop();
			
			while(!tempStack.isEmpty() && tempStack.peek() > current) {
				stack.push(tempStack.pop());
			}
			tempStack.push(current);
		}
		while(!tempStack.isEmpty()) {
			stack.push(tempStack.pop());
		}
	}
	
	public static void main(String args[]) {
		Stack <Integer> stack = new Stack<>();
		stack.push(34);
		stack.push(30);
		stack.add(3);
		stack.add(98);
		stack.add(92);
		stack.add(99);
		
		System.out.println("Original stack: " + stack);
		sortStack(stack);
		System.out.println("Sorted stack: " + stack);
	}

}

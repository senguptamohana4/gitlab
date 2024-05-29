package com.assignments;

import java.util.Stack;

public class SequenceInStack {
	
	public static boolean isSequencePresent(Stack<Integer> stack , int[] sequence) {
		if(sequence.length == 0) {
			return true;
			
		}
		int seqIndex = 0;
		Stack<Integer> tempStack = new Stack<>();
		
		while(!stack.isEmpty()) {
			int element = stack.pop();
			tempStack.push(element);
			
			if(element == sequence[seqIndex]) {
				seqIndex++;
				
				if(seqIndex == sequence.length) {
					break;
				}
				
			} else {
				seqIndex = 0;
			}
		}
		while(!tempStack.isEmpty()) {
			stack.push(tempStack.pop());
		}
		return seqIndex == sequence.length;
	}
	public static void main(String args[]) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		int [] sequence = {3,4,5};
		
		boolean result = isSequencePresent(stack, sequence);
		System.out.println("Is the sequence present?" + result);
	}

}

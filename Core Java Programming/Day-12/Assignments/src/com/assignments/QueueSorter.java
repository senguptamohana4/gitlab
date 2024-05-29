package com.assignments;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueSorter {
	
	public static void sortQueue(Queue<Integer> queue) {
		Stack<Integer> stack = new Stack<>();		
		for(int i=0; i<queue.size(); i++) {
			int minIndex = -1;
			int minValue = Integer.MAX_VALUE;
			int queueSize = queue.size();
			
			for(int j=0; j < queue.size(); j++) {
				int current = queue.poll();
				if(current < minValue && j < queueSize -i) {
					minValue = current;
					minIndex = j;
				}
				
				queue.add(current);
			}
			for(int j=0; j<queueSize; j++) {
				int current = queue.poll();
				if(j != minIndex) {
					stack.push(current);
				}
			}
				
				queue.add(minValue);
				
				while(!stack.isEmpty()) {
					queue.add(stack.pop());
				}
			}
			
		}
		public static void main (String[] args) {
			Queue<Integer> queue = new LinkedList<>();
			queue.add(3);
			queue.add(1);
			queue.add(4);
			queue.add(1);
			queue.add(5);
			queue.add(9);
			queue.add(2);
			queue.add(6);
			
			System.out.println("Original queue: " + queue);
			sortQueue(queue);
			System.out.println("Sorted queue: " + queue);
			
			
		
	}

}

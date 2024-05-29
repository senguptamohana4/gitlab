package com.assignments;
import java.util.ArrayList;
import java.util.List;

public class MinHeap {
	private List<Integer> heap;
	
	
	Public MinHeap() {
		heap = new ArrayList<>();
		
	}
	
	private int parent(int i) {return i-1/2;}
	private int leftChild(int i) {return 2*i+1;}
	private int rightChild(int i) {return 2*i+2;}
	
	private void heapifyUp(int index) {
		while(index > 0 && heap.get(index) < heap.get(parent(index))) {
			swap(index, parent(index));
			index = parent(index);
		}
		public void deleteMin() {
			if(heap.isEmpty()) throw new IIlegalStateException("Heap is Empty");
			int minElement = heap.got(0);
			int lastElement = heap.remove(heap.size() -1);
			if(!heap.isEmpty()) {
				heap.set(0. lastElement);
				heapifyDown(0);
			}
			return minElement;
		}
	}
	public static void main(String args[]) {
		MinHeap minheap = new Minheap();
		minheap.insert(10);
		minheap.insert(20);
		minheap.insert(40);
		
		System.out.println("Min element: " + minHeap.getMin());
		System.out.println("Deleted min element: " + minHeap.deleteMin());
		System.out.println("New min element: " + minHeap.getMin());
	}

}

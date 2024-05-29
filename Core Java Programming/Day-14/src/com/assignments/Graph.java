package com.assignments;
import java.util.*;

public class Graph {
	private int numVertices;
	private LinkedList<Integer>[] adjacencyList;
	
	Graph(int numVertices) {
		this.numVertices = numVertices;
		adjacencyList = new LinkedList [numVertices];
		for(int i=0; i<numVertices; i++) {
			adjacencyList[i] = new LinkedList<>();
		}
	}
	void addEdge(int src, int dest) {
		adjacencyList[src].add(dest);
		adjacencyList[dest].add(src);
	}
	void BFS(int startNode) {
		boolean [] visited = new boolean[numVertices];
		LinkedList<Integer> queue = new LinkedList<>();
		visited[startNode] = true;
		queue.add(startNode);
		
		while(queue.size() != 0) {
			startNode = queue.poll();
			System.out.println(startNode +" ");
			
			Iterator<Integer> i = adjacencyList[startNode].listIterator();
			while(i.hasNext()) {
				int node = i.next();
				if(!visited[node]) {
					visited[node] = true;
					queue.add(node);
					
				}
			}
		}
	}
	  public static void main(String args[]) {
		  Graph graph = new Graph(6);
		  
		  graph.addEdge(0, 1);
		  graph.addEdge(0, 2);
		  graph.addEdge(1, 3);
		  graph.addEdge(1, 4);
		  graph.addEdge(2, 4);
		  graph.addEdge(3, 4);
		  graph.addEdge(3, 5);
		  graph.addEdge(4, 5);
	  }
	}

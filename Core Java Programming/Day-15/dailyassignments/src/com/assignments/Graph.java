package com.assignments;
import java.util.*;

public class Graph {
	private int vertices;
	private LinkedList<Edge>[] adjacencyList;
	
	static class Edge {
		int target;
		int weight;
		
		Edge(int target, int weight){
			this.target = target;
			this.weight = weight;
		}
	}
	public Graph(int vertices) {
		this.vertices = vertices;
		adjacencyList = new LinkedList[vertices];
		for(int i=0; i<vertices; i++) {
			adjacencyList[i] = new LinkedList<>();
		}
	}
	public void addEdge(int source, int target, int weight) {
		adjacencyList[source].add(new Edge(target, weight));
		adjacencyList[target].add(new Edge(source, weight));
	}
	 public void dijkstra(int start) {
		 PriorityQueue<Edge> pq = new PriorityQueue<> (Comparator.comparingInt(edge -> edge.weight));
		 int [] distances = new int[vertices];
		 Arrays.fill(distances,Integer.MAX_VALUE);
		 distances[start] = 0;
		 pq.add(new Edge(start, 0));
		 
		 while(!pq.isEmpty()) {
			 Edge edge = pq.poll();
			 int currentNode = edge.target;
			 
			 for(Edge neighbor : adjacencyList[currentNode]) {
				 int newDist = distances[currentNode] + neighbor.weight;
				 if(newDist < distances[neighbor.target]) {
					 distances[neighbor.target] = newDist;
					 pq.add(new Edge(neighbor.target, newDist));
				 }
			 }
		 }
		 printShortestPaths(distances);
	 } 
	 private void printShortestPaths(int [] distances) {
		 System.out.println("Shortest paths from start node:");
		 for(int i=0; i<distances.length; i++) {
			 System.out.println("Node " + i + "is at distance" + distances [i]);
		 }
	 }
	  public static void main(String args[]) {
		  Graph graph = new Graph(6);
		  graph.addEdge(0, 1, 4);
		  graph.addEdge(0, 2, 1);
		  graph.addEdge(2, 1, 2);
		  graph.addEdge(1, 3, 1);
		  graph.addEdge(2, 3, 5);
		  graph.addEdge(3, 4, 3);
		  graph.addEdge(4, 5, 1);
		  graph.addEdge(3, 5, 2);
		  
		  graph.dijkstra(0);
	  }

}

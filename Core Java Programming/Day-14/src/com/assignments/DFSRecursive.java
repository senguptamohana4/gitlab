package com.assignments;

import java.util.*;

class Graph {
	private Map<Integer, List<Integer>> adjList;
	
	public Graph() {
		adjList = new HashMap<>();
	}
	public void addEdge(int v, int w) {
		adjList.computeIfAbsent(v,  k -> new LinkedList<>()).add(w);
		adjList.computeIfAbsent(w,  k -> new LinkedList<>()).add(v);
	}
	public List<Integer> getNeighbors(int v){
		 return adjList.getOrDefault(v, new LinkedList<>());
	}
	public Set<Integer> getVertices(){
		return adjList.keySet();
	}
}

public class DFSRecursive {
	private Set <Integer> visited;
	
	public DFSRecursive() {
		visited = new HashSet<>();
	}
	
	public void dfs(Graph graph, int v) {
		visited.add(v);
		System.out.println(v);
		
		for(int neighbor : graph.getNeighbors(v)) {
			if(!visited.contains(neighbor)) {
				dfs(graph, neighbor);
			}
			
		}
	}
	 public static void main(String args[]) {
		 Graph graph = new Graph();
		 
		 graph.addEdge(0, 1);
		 graph.addEdge(0, 2);
		 graph.addEdge(1, 2);
		 graph.addEdge(2, 0);
		 graph.addEdge(2, 3);
		 graph.addEdge(3, 3);
	 }

}

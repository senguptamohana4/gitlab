package com.assignments;
import java.util.*;

public class DirectedGraph {
	
	private Map<Integer, List<Integer>> graph = new HashMap<>();
	
	public boolean addEdge(int u, int v) {
		graph.putIfAbsent(u,  new ArrayList<>());
		graph.putIfAbsent(v,  new ArrayList<>());
		
		graph.get(u).add(v);
		
		if(isCyclic()) {
			graph.get(u).remove((Integer) v);
			return false;
			
		}
		return true;
	}
	private boolean isCyclic() {
		Set<Integer> visited = new HashSet<>();
		Set<Integer> recStack = new HashSet<>();
		
		for(Integer node : graph.keySet()) {
			if(isCyclicUtil(node, visited, recStack)) {
				return true;
			}
		}
		return false;
	}
	private boolean isCyclicUtil(int node, Set<Integer> visited, Set<Integer> recStack) {
		if(recStack.contains(node)) {
			return true;
		}
		if(visited.contains(node)) {
			return false;
		}
		visited.add(node);
		recStack.add(node);
		
		for(Integer neighbor : graph.get(node)) {
			if(isCyclicUtil(neighbor, visited, recStack)) {
				return true;
				
			}
		}
		recStack.remove(node);
		return false;
		
	}
	public static void main(String args[]) {
		DirectedGraph graph = new DirectedGraph();
		System.out.println(graph.addEdge(0, 1));
		System.out.println(graph.addEdge(1,  2));
		System.out.println(graph.addEdge(2,  0));
		System.out.println(graph.addEdge(2,  3));
		
	}

}

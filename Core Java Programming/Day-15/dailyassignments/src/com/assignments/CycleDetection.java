package com.assignments;
import java.util.*;


class UnionFind {
	private int[] parent;
	private int [] rank;
	
	public UnionFind(int size) {
		parent = new int[size];
		rank = new int[size];
		
		for(int i=0; i<size; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
	}
	public int find (int p) {
		if(parent[p] != p) {
			parent[p] = find (parent[p]);
		}
		return parent[p];
		
	}
	public void union(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		
		if(rootP != rootQ) {
			if(rank[rootP] > rank[rootQ]) {
				parent[rootQ] = rootP;
			} else if (rank[rootP] < rank[rootQ]) {
				parent[rootP] = rootQ;
			} else {
				parent[rootQ] = rootP;
				rank[rootP]++;
		
			}
		}
	}
}
public class CycleDetection {
	public static boolean hasCycle (int [][] edges, int numNodes) {
		UnionFind uf = new UnionFind(numNodes);
		
		for(int [] edge : edges) {
			int u = edge[0];
			int v = edge[1];
			
			if(uf.find(u) == uf.find(v)) {
				return true;
			} else {
				uf.union(u, v);
			}
		}
		return false;
		
	}
	 public static void main(String args[]) {
		 int [][] edges = {
				 {0,1},
				 {1,2},
				 {2,3},
				 {3,0}
		 };
		 int numNodes = 4;
		 if(hasCycle(edges, numNodes)) {
			 System.out.println("The graph has a cycle.");
				 
		 } else {
			 System.out.println("The graph doesnot have a cycle.");
		 }
	 }

}

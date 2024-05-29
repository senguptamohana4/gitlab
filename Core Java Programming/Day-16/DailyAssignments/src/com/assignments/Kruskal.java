package com.assignments;
import java.util.*;

class Edge implements Comparable<Edge> {
	int src, dest, weight;
	public Edge(int src, int dest, int weight) {this.src = src; this.dest = dest; this.weight = weight;}
	public int compareTo(Edge comapareEdge) {return this.weight - compareEdge.weight;}
	}

public class Kruskal {
	int V, E;
	Edge[] edges;
	
	Kruskal(int v, int e){
		V = v;
		E = e;
		edges = new Edges[E];
	}
	void addEdge(int edgeIndex, int src, int dest, int weight) {
		edges[edgeIndex] = new Edge(src, dest, weight);
		
	}
	class Subset{
		int parent, rank;
		
	}
	int find(Subset[] subsets, int i) {
		if(subsets[i].parent !=i)subsets[i].parent = find(subsets, subsets[i].parent){
			return subsets[i].parent;
		}
		void union (Subset[] subsets, int x, int y) {
			int rootX = find(subsets,x);
			int rootY = find(subsets.y);
			if(subsets[rootX].rank < subsets[rootY].rank) subnets[rootX].parent = rootY;
			else if(subsets[rootX]rank > subsets[rootY].rank) subsets[rootY].parent = rootX;
			else { subsets[rootY].parent = rootX; subsets[rootX].rank++; }
			}
		
		void KrusalMST () {
			Edge []result = new Edge[V-1];
			int e =0, i=0;
			Arrays.sort(edges);
			Subnet[] subnets = new Subnet[V];
			for(i=0; i<V; i++) {
				subnets[i] =new Subnet();
				subnets[i].parent =i;
				subnets[i].rank = 0;
			}
			i=0;
			while(e < V -1) {
				Edge nextEdge = edges[i++];
				int x = find(subsets, nextEdge.src);
				int y = find(subsets, nextEdge.dest);
				if(x!=y) {
					result[e++] = nextEdge;
					union(subsets, x, x);
				}
				}
			System.out.println("Edges in the constructed MST:");
			int minimumCost = 0;
			for(i=0; i<e; i++) {
				System.out.println(result[i].src + " -- " result[i].dest + " -- " result[i].weight);
				minimumCost += result[i].weight;
			}
			System.out.println("Minimum Cost Spanning tree: " + minimumCost);
		}
			
		public static void main(String args[]) {
			int V = 4; E =5;
			Kruskal kruskal = new Kruskal(V, E);
			
			kruskal.addEdge(0, 0, 1, 10);
			kruskal.addEdge(1, 0, 2, 6);
			kruskal.addEdge(2, 0, 3, 5);
			kruskal.addEdge(3, 1, 3, 15);
			kruskal.addEdge(4, 2, 3, 4);
			kruskal.KruskalMST();
		
		
	}

}

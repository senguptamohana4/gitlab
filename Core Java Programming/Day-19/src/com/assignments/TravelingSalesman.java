package com.assignments;
import java.util.Arrays;

public class TravelingSalesman {
	
	private static final int INF = Integer.MAX_VALUE/2;
	
	public static int FindMinCost(int [][] graph) {
		int n = graph.length;
		int [][] dp =new int [1 << n][n];
		
		for(int [] row : dp) {
			Arrays.fill(row,  INF);
		}
		
		dp[1][0] = 0;
		
		for(int mask =1; mask < (1 << n); mask ++) {
			for(int u=0; u < n; u++) {
				if((mask &(1 << u)) == 0) continue;
				for(int v =0; v < n; v++) {
					if((mask & (1 << v)) !=0) continue;
					dp[mask | (1 << v)][v] = Math.min(dp[mask | (1<< v)][v], dp[mask][u] + graph[u][v]);
				}
			}
		}
		int minCost = INF;
		for(int u = 1; u <n; u++) {
			minCost = Math.min(minCost,  dp[(1 << n) - 1][u] + graph[u][0]);
		}
		return minCost;
	}
	public static void main(String args[]) {
		int [][] graph = {
				{0,10,15,20},
				{10,0,35,25},
				{15,35,0,30},
				{20,25,30,0}
		};
		
		int minCost = FindMinCost(graph);
		System.out.println("The minimum cost to visit all cities & return to the starting city is: " + minCost);
		}

}

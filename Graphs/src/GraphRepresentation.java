import java.util.*;
import java.io.*;

public class GraphRepresentation {
	static int[][] adjmatrix;
	static ArrayList<Pair>[] adjlist;
	static Triple[] edgelist;

	static class Pair {
		int to;
		int cost;

		Pair(int t, int c) {
			to = t;
			cost = c;
		}
	}

	static class Triple {
		int to;
		int from;
		int cost;

		Triple(int t, int f, int c) {
			to = t;
			from = f;
			cost = c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); 
		int e = sc.nextInt();
		
		adjmatrix = new int[n][n];
		
		adjlist=new ArrayList[n];
		for(int i=0; i<adjlist.length; i++)
			adjlist[i]=new ArrayList<Pair>();
		
		edgelist = new Triple[e];
		
		for(int i=0; i<e; i++){
			int u = sc.nextInt();
			int v = sc.nextInt();
			int cost = sc.nextInt();
			
			adjmatrix[u][v]=cost;
			adjlist[u].add(new Pair(v,cost));
			edgelist[i]= new Triple(u,v,cost);
		}
		
  	}
}

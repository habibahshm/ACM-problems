import java.io.*;
import java.util.*;
import java.util.LinkedList;

public class LongestPath {
	static ArrayList<Integer>[]graph;
	static int[]dist;
	static Queue<Integer>layer;
	
	public static void bfs(int source){
		layer.add(source);
		dist[source]=0;
		while(!layer.isEmpty()){
			int u = layer.poll();
			for(int i=0; i<graph[u].size(); i++){
				int v = graph[u].get(i);
				if(dist[v]==-1){
					dist[v]=dist[u]+1;
					layer.add(v);
			}
		}
	 }
	}
 public static void main(String[]args)throws IOException{
	 BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	 StringTokenizer st;
	 int n = Integer.parseInt(bf.readLine());
	 graph = new ArrayList[n];
	 for(int i=0; i<n; i++)
		 graph[i]=new ArrayList<Integer>();
	 
	 dist = new int[n];
	 Arrays.fill(dist, -1);
	 for(int i=0; i<n-1; i++){
		 st = new StringTokenizer(bf.readLine());
		 int source = Integer.parseInt(st.nextToken())-1;
		 int dest = Integer.parseInt(st.nextToken())-1;
		 graph[source].add(dest);
		 graph[dest].add(source);
	 }
	 layer =  new LinkedList<Integer>();
	 bfs(0);
	 int max = -1;
	 int idx = -1;
	 for(int i=0; i<n; i++){
		 if(dist[i]>max){
			 max=dist[i];
			 idx=i;
		 }
	 }
	 Arrays.fill(dist, -1);
	 bfs(idx);
	 max = -1;
	 for(int i=0; i<n; i++){
		 if(dist[i]>max){
			 max=dist[i];
		 }
	 }
	 System.out.println(max);
 }
}

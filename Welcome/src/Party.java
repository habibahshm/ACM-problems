import java.io.*;
import java.util.*;

public class Party {
	static ArrayList<Integer>[] adjlist;
	static int[] distance;
	static int groups;
	static int max;

	public static void bfs(int s) {
		Queue<Integer> layer = new LinkedList<Integer>();
		Arrays.fill(distance, -1);
		distance[s] = 0;
		layer.add(s);
		while (!layer.isEmpty()) {
			int u = layer.poll();
			for (int i = 0; i < adjlist[u].size(); i++) {
				int v = adjlist[u].get(i);
				if (distance[v] == -1) {
					distance[v] = distance[u] + 1;
					max = Math.max(max, distance[v]);
					layer.add(v);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int v = Integer.parseInt(bf.readLine());
		adjlist = new ArrayList[v + 1];
		distance = new int[v + 1];
		for (int i = 0; i < v + 1; i++)
			adjlist[i] = new ArrayList<Integer>();
		ArrayList<Integer> startpoints = new ArrayList<Integer>();
		for (int i = 1; v-- > 0; i++) {
			int u = Integer.parseInt(bf.readLine());
			if (u != -1)
				adjlist[u].add(i);
			else 
				startpoints.add(i);
		}
		groups = 1;
		max = 0;
		for(int i=0; i<startpoints.size(); i++)
			bfs(startpoints.get(i));
		
		System.out.println(max + 1);
	}
}

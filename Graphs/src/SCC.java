//tarjan's algorithm.
import java.util.*;

public class SCC {
	static ArrayList<Integer>[] adjlist;
	static int V, counter, SCC, dfs_num[], dfs_low[];//dfs_num = 0, means not visited yet.
	
	static boolean[] inSCC;
	static Stack<Integer> stack;

	static void tarjanSCC()	 	//O(V + E)
	{
		for(int i = 0; i < V; ++i)
			if(dfs_num[i] == 0)
				tarjan(i);
	}
	
	public static void tarjan(int u) {
		dfs_num[u] = dfs_low[u] = ++counter;
		stack.push(u);
		for (int v : adjlist[u]) {
			if (dfs_num[v] == 0)
				tarjan(v);
			if (!inSCC[v])
				dfs_low[u] = Math.min(dfs_low[v], dfs_low[u]);
		}

		if (dfs_num[u] == dfs_low[u]) {
			// SCC found
			while (true) {
				int v = stack.pop();
				inSCC[v] = true;
				System.out.print(v + " ");
				if (v == u)
					break;
			}
			SCC++;
		}

	}
}

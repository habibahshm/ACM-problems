
public class FloydWarshall {
	static int[][] adjmatrix;
	static int[][] p;
	static int INF = (int) 1e9;
	static int V;

	// APSP
	public static void Floyd() {
		// adjMatrix contains: directed edges, zero for i=j, INF (1B) otherwise
		p = new int[V][V];
		for (int i = 0; i < V; i++)
			for (int j = 0; j < V; j++)
				p[i][j] = i;

		for (int k = 0; k < V; k++)
			for (int i = 0; i < V; i++)
				for (int j = 0; j < V; j++)
					if (adjmatrix[i][k] + adjmatrix[k][j] < adjmatrix[i][j]) {
						adjmatrix[i][j] = adjmatrix[i][k] + adjmatrix[k][j];
						p[i][j] = p[k][j];
					}
	}

	static void printPath(int i, int j) {
		if (i != j)
			printPath(i, p[i][j]);
		System.out.println(j + " ");
	}

}

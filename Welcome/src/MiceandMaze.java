import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MiceandMaze {
	static int[][] adjmatrix;
	static int INF = (int) 1e9;
	static int V;

	// APSP
	public static void Floyd() {
		// adjMatrix contains: directed edges, zero for i=j, INF (1B) otherwise
		for (int k = 0; k < V; k++)
			for (int i = 0; i < V; i++)
				for (int j = 0; j < V; j++)
					if (adjmatrix[i][k] + adjmatrix[k][j] < adjmatrix[i][j])
						adjmatrix[i][j] = adjmatrix[i][k] + adjmatrix[k][j];

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int c = Integer.parseInt(bf.readLine());
		while (c-- > 0) {
			bf.readLine();
			V = Integer.parseInt(bf.readLine());
			adjmatrix = new int[V][V];
			for (int i = 0; i < V; i++) {
				Arrays.fill(adjmatrix[i], INF);
				adjmatrix[i][i] = 0;
			}
			int exit = Integer.parseInt(bf.readLine())-1;
			int time = Integer.parseInt(bf.readLine());
			int m = Integer.parseInt(bf.readLine());
			while (m-- > 0) {
				st = new StringTokenizer(bf.readLine());
				int from = Integer.parseInt(st.nextToken()) - 1;
				int to = Integer.parseInt(st.nextToken()) - 1;
				int cost = Integer.parseInt(st.nextToken());
				adjmatrix[from][to] = cost;
			}
			Floyd();
			int cost = 0;
			for (int i = 0; i < V; i++)
				if (adjmatrix[i][exit] <= time)
					cost++;
			System.out.println(cost);
			if (c > 0)
				System.out.println();
		}
	}

}

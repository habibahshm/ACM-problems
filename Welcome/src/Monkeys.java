import java.io.*;
import java.util.*;

public class Monkeys {
	static ArrayList<ArrayList<String>> graph;
	static boolean[][] visited;
	static int[] dx = { 1, 0, -1, 0, 1, -1, 1, -1 };
	static int[] dy = { 0, -1, 0, 1, 1, -1, -1, 1 };
	static int max_r;
	static int max_c;
	static int[][] output;

	public static boolean isValid(int i, int j) {
		return i >= 0 && i < max_r && j >= 0 && j < max_c
				&& !visited[i][j];
	}

	public static void dfs(int i, int j, int colour) {
		String u = graph.get(i).get(j);
		output[i][j] = colour;
		visited[i][j]=true;
		for (int k = 0; k < 8; k++) {
			if (isValid(i + dy[k], j + dx[k])) {
				String v = graph.get(i + dy[k]).get(j + dx[k]);
				if (v.equals(u))
					dfs(i + dy[k], j + dx[k], colour);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		graph = new ArrayList<ArrayList<String>>();
		int i;
		String o;
		while(true){
		o= bf.readLine();
		graph = new ArrayList<ArrayList<String>>();
		for (i = 0; !o.equals("%") && o.length()>0 && !o.equals(null); i++) {
			st = new StringTokenizer(o);
			graph.add(new ArrayList<String>());
			while(st.hasMoreTokens()) {
				graph.get(i).add(st.nextToken());
			}
			o = bf.readLine();
		}
		max_r = graph.size();
		max_c = graph.get(i-1).size();
		output = new int[max_r][max_c];
		visited = new boolean[max_r][max_c];
		int colour = 1;
		for (int l = 0; l < max_r; l++) {
			for (int m = 0; m < max_c; m++) {
				if (!visited[l][m]) {
					dfs(l, m, colour);
					colour++;
				}
			}
		}
		for (int l = 0; l < max_r; l++) {
			for (int m = 0; m < max_c; m++) {
				System.out.print(output[l][m]);
				if(m!=max_c-1)
					System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println("%");
      
	}
  }
}

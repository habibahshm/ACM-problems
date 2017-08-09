import java.io.*;
import java.util.*;

public class Dominator {
	static boolean[][]graph;
	  static boolean[]visited;
	  
	  public static void dfs(int node, int mesh3ayzaha){
		  visited[node]=true;
		  for(int i=0; i<graph[node].length; i++){
			  if(graph[node][i] && i != mesh3ayzaha)
				  if(!visited[i])
					  dfs(i, mesh3ayzaha);	  
		  }
	  }
	  public static void main(String[]args)throws IOException{
		  BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		  PrintWriter out = new PrintWriter(System.out);
		  int n = Integer.parseInt(bf.readLine());
		  for(int u=1; u<=n; u++){
			  int nodes =  Integer.parseInt(bf.readLine());
			  graph = new boolean[nodes][nodes];
			  visited = new boolean[nodes];
			  
			  for(int i=0; i<nodes; i++){
				  StringTokenizer st = new StringTokenizer(bf.readLine());
				  for(int j=0; st.hasMoreTokens(); j++){
					  int d = Integer.parseInt(st.nextToken());
					  if(d==1)
						  graph[i][j]=true;
				  }
			  }
			  char[][]output= new char[nodes][nodes];
			  for(int i=0; i<output.length; i++)
				  Arrays.fill(output[i], 'N');
			  
			  
			  dfs(0,-1);
			  boolean[]vis= new boolean[nodes];
			  for(int i=0; i<visited.length; i++){
				  if(visited[i]){
					output[0][i]='Y';
					output[i][i]='Y';
				  }
				  vis[i]=visited[i];
			  }
			  
			  for(int node=1; node<nodes; node++){
				  Arrays.fill(visited, false);
				  dfs(0,node);
				  
				  for(int j=0; j<nodes; j++){
					  if(!visited[j] && vis[j])
						  output[node][j]='Y';
				  }
			  }
			  out.println("Case "+u+":");
			  int lim = (2*nodes)-1;
			  for(int i=0; i<nodes; i++){
				  
				  out.print("+");
				  for(int k=0; k<lim; k++){
					  out.print("-");
				  }
				  out.print("+");
				  out.println();
				  
				  out.print("|");
				  for(int j=0; j<nodes; j++){
					 
					  out.print(output[i][j]+"|");
				  }
				  out.println();
			  }
			  out.print("+");
			  for(int k=0; k<lim; k++){
				  out.print("-");
			  }
			  out.print("+");
			  out.println();
		  }
		  
		  out.flush();
		  out.close();
	  }
	
}

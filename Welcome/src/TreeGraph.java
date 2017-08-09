import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class TreeGraph {
	static ArrayList<Integer>[]graph;
	static boolean[]visited;
	public static void isTree(int node){
		visited[node]=true;
		for(int i=0; i<graph[node].size(); i++){
			int des = graph[node].get(i);
			if(visited[des])
				continue;
			isTree(des);
		}
	}
  public static void main(String[]args)throws IOException{
	  BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	  StringTokenizer st = new StringTokenizer(bf.readLine());
	  int nodes = Integer.parseInt(st.nextToken());
	  int edges = Integer.parseInt(st.nextToken());
	  if(edges!=nodes-1)
		  System.out.println("NO");
	  else{
	  graph = new ArrayList[nodes];
	  for(int i=0; i<nodes; i++)
	  	graph[i]=new ArrayList<>();
      
	  int head=0;
	  for(int i=0; i<edges; i++){
	  	st = new StringTokenizer(bf.readLine());
	  	int source = Integer.parseInt(st.nextToken());
	  	if(i==0)
	  		head=source;
	  	int destination = Integer.parseInt(st.nextToken());
	  	source--; destination--;
	  	graph[source].add(destination);
	  	graph[destination].add(source);
	  }
	  visited=new boolean[nodes];
	  isTree(head);
	  boolean tree = true;
	  for(int i=0; i<visited.length; i++){
		  if(!visited[i]){
			  tree=false;
			  break;
		  }
	  }
	  if(tree)
		  System.out.println("YES");
	  else
		  System.out.println("NO");
	  } 
  }
}

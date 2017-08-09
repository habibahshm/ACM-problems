import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Graph {
	static ArrayList<Integer>[]graph;
 public static void main(String[]args)throws IOException{
BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
StringTokenizer st = new StringTokenizer(bf.readLine());
int nodes = Integer.parseInt(st.nextToken());
int edges= Integer.parseInt(st.nextToken());
graph = new ArrayList[nodes];
for(int i=0; i<nodes; i++)
	graph[i]=new ArrayList<>();

for(int i=0; i<nodes; i++){
	st = new StringTokenizer(bf.readLine());
	int source = Integer.parseInt(st.nextToken());
	int destination = Integer.parseInt(st.nextToken());
	source--; destination--;
	graph[source].add(destination);
	graph[destination].add(source);
}
 }
}

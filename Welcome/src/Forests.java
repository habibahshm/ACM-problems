import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Forests {
 static class DisjointSets{
	 int[]representitves;
	 int[]rank;
	 int size;
	 public DisjointSets(int n){
		 representitves=new int[n];
		 rank = new int[n];
		 size=n;
		 for(int i=0; i<n; i++){
			 representitves[i]=i;
		 }
		 Arrays.fill(rank,1);
	 }
	 int findRepresentitve(int x){
		 if(representitves[x]==x)
			 return x;
		 return representitves[x]=findRepresentitve(representitves[x]);
	 }
	 void union(int x,int y){
		 int x1=findRepresentitve(x);
		 int y1=findRepresentitve(y);
		 if(x1!=y1){
			 if(rank[x1]>rank[y1])
				 representitves[y1]=x1;
			 else
				 if(rank[y1]>rank[x1])
					 representitves[x1]=y1;
				 else{
					 representitves[x1]=y1;
					 rank[y1]++;
				 }
		 size--;
		 }
					 
	 }
 }
 public static boolean sameOpinion(int p1, int p2, boolean[][]s){
	 for(int k=0; k<s[p1].length; k++){
		 if(s[p1][k]!=s[p2][k])
			 return false;
	 }
	 return true;
 }
 public static void main(String[]args)throws IOException{
	 BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	 int n = Integer.parseInt(bf.readLine());
	 bf.readLine();
	 while(n-->0){
		 String s = bf.readLine();
		 StringTokenizer st = new StringTokenizer(s);
		 int p = Integer.parseInt(st.nextToken());
		 int t = Integer.parseInt(st.nextToken());
		 boolean[][] opinions = new boolean[p][t];
		 String o;
		 while((o = bf.readLine()) != null && o.length() != 0){
			 st=new StringTokenizer(o);
			 int cp = Integer.parseInt(st.nextToken());
			 int ct = Integer.parseInt(st.nextToken());
			 opinions[cp-1][ct-1]=true;
		 }
		 DisjointSets ds = new DisjointSets(p); 
		 for(int i=0; i<p; i++){
			 for(int j=i+1; j<p; j++){
				 if(sameOpinion(i,j,opinions))
					 ds.union(i, j);
			 }
		 }
		 System.out.println(ds.size);
	 }
	 
 }
}

import java.util.*;
import java.io.*;

public class VirtualFriends {
  static class DisjointSets{
	  int[]representitves;
	  int[]rank;
	  int[]size;
	  public DisjointSets(int n){
		  representitves=new int[n];
		  rank=new int[n];
		  size=new int[n];
		  for(int i=0; i<n; i++)
			  representitves[i]=i;
		  Arrays.fill(rank,1);
		  Arrays.fill(size,1);
	  }
	  int findRepresentitve(int i){
		  if(representitves[i]==i)
			  return i;
		  return representitves[i]=findRepresentitve(representitves[i]);
	  }
	  void union(int x, int y){
		  int x1=findRepresentitve(x);
		  int y1=findRepresentitve(y);
		  if(x1!=y1){
			  if(rank[x1]>rank[y1]){
				  representitves[y1]=x1;
				  size[x1]+=size[y1];
			  }else{
				  if(rank[y1]>rank[x1]){
					  representitves[x1]=y1;
					  size[y1]+=size[x1];
				  }else{
					  representitves[x1]=y1;
					  rank[y1]++;
					  size[y1]+=size[x1];
				  }
					  
			  }
				  
		  }
	  }
  }
  public static void main(String[]args)throws IOException{
	  BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	  int n = Integer.parseInt(bf.readLine());
	  while(n-->0){
		  int i=0;
		  int r = Integer.parseInt(bf.readLine());
		  TreeMap<String,Integer> tm=new TreeMap <String,Integer>();
		  DisjointSets ds = new DisjointSets(r<<1);
		  while(r-->0){
		  String in = bf.readLine();
		  StringTokenizer st = new StringTokenizer(in);
		  String f1=st.nextToken();
		  String f2=st.nextToken();
		  if(!tm.containsKey(f1)){
			  tm.put(f1, i);
			  i++;
		  }
		if(!tm.containsKey(f2)){
		  tm.put(f2, i);
			i++;}
		  
		  ds.union(tm.get(f1),tm.get(f2));
		  if(ds.size[ds.representitves[tm.get(f1)]]>ds.size[ds.representitves[tm.get(f2)]])
			  System.out.println(ds.size[ds.representitves[tm.get(f1)]]);
		  else
			  System.out.println(ds.size[ds.representitves[tm.get(f2)]]);
		 
		  }
		 }
		 
		  
	}
  }


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Identifyingtea {
  public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	while(bf.ready()){
		int c = Integer.parseInt(bf.readLine());
		int[] cont = new int[5];
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<5; i++)
			cont[i] = Integer.parseInt(st.nextToken());
		int ans=0;
		for(int i=0; i<5; i++)
			if(cont[i]==c)
				ans++;
		System.out.println(ans);
	}
}
}

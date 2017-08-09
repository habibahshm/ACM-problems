import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SergeyAndreduction {
		public static void main(String[] args) throws IOException
		{
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st;
			st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[]a = new int[n];
			st = new StringTokenizer(bf.readLine());
			for(int i=0; i<n; i++)
				a[i]= Integer.parseInt(st.nextToken());
			while(m-->0){
				st = new StringTokenizer(bf.readLine());
				if(Integer.parseInt(st.nextToken())==0){
					int l = Integer.parseInt(st.nextToken())-1;
					int r = Integer.parseInt(st.nextToken())-1;
					int e = Integer.parseInt(st.nextToken());
					for(int i=l; i<=r; i++)
						a[i]-=e;
				}else{
					int l = Integer.parseInt(st.nextToken())-1;
					int r = Integer.parseInt(st.nextToken())-1;
					int ans=0;
					for(int i=l; i<=r; i++){
						if(a[i]<=0)
							ans++;
					}
					System.out.println(ans);
				}
			}
		}
	}


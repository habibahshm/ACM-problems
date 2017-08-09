import java.io.*;
import java.util.*;

public class DivingForGold {
	static int d[], v[], dp[][], timeTaken[], n,path[][];
	static String output;

	public static int state(int idx, int remT) {
		if(remT<0)
			return -1000000;
		if (idx == n || remT == 0)
			return 0;
		if (dp[idx][remT] != -1)
			return dp[idx][remT];
		int take = state(idx + 1, remT - timeTaken[idx]) + v[idx];
		int leave = state(idx + 1, remT);
		int max;
		if(take>=leave){
			max=take;
			path[idx][remT]=remT-timeTaken[idx];
		}else{
			max=leave;
			path[idx][remT]=remT;
		}
		return dp[idx][remT]=max;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int k=0;
		while (bf.ready()) {
			if(k==0)
				k=1;
			else{
				System.out.println();
				bf.readLine();
			}
			st = new StringTokenizer(bf.readLine());
			int t = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(bf.readLine());
			d = new int[n];
			v = new int[n];
			timeTaken = new int[n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(bf.readLine());
				d[i] = Integer.parseInt(st.nextToken());
				v[i] = Integer.parseInt(st.nextToken());
				timeTaken[i] = (w * d[i]) + (2 * w * d[i]);
			}
			dp = new int[n][t+1];
			path = new int[n][t+1];
			for (int i = 0; i < n; i++)
				Arrays.fill(dp[i], -1);
			int ans = state(0, t);
			ArrayList<Integer>taken = new ArrayList<Integer>();
			int remT=t;
			for(int i=0; i<n; i++){
				if(path[i][remT]!=remT)
					taken.add(i);
				remT=path[i][remT];
			}
			System.out.println(ans);
			System.out.println(taken.size());
			for(int i: taken)
				System.out.println(d[i]+" "+v[i]);
			taken.clear();
		}
	}
}

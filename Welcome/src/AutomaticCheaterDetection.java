import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class AutomaticCheaterDetection {

	public static class Triple implements Comparable<Triple> {
		int diff;
		int status;
		char result;

		public Triple(int d, int s, char r) {
			diff = d;
			status = s;
			result = r;
		}

		public int compareTo(Triple a) {
			return diff - a.diff;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(bf.readLine());
		while (t-- > 0) {
			int q = Integer.parseInt(bf.readLine());
			ArrayList<Triple> io = new ArrayList<>();
			ArrayList<Triple>lc = new ArrayList<>();
			while(q-->0){
				st = new StringTokenizer(bf.readLine());
				int d = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				char r = st.nextToken().charAt(0);
				if(s==0 && r=='i')
					io.add(new Triple(d,s,r));
				else
					if(s==1 && r=='c')
						lc.add(new Triple(d,s,r));
			}
			Collections.sort(io);
			Collections.sort(lc);
			int ans=0;
			int j=0; 
			for(int i=0; i<io.size(); i++){
				
				while(j<lc.size() && lc.get(j).diff<=io.get(i).diff )
					j++;
				
				if(j>=lc.size())
					break;
				ans+=(lc.size()-j);
			}
			System.out.println(ans);
		}
	}
}

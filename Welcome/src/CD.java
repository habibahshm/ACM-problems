import java.io.*;
import java.util.*;

public class CD {
	static int target;
	static int[] tracks;
	static int max;
	static boolean[]candidate;

	public static void backtrack(int idx, int sum, boolean[]t) {
		if (sum > target)
			return;
		
		if(sum>max){
    		max=sum;
    		candidate=t.clone();
    	}
		
        if(idx==tracks.length)
        	return;
       
		t[idx] = true;
		backtrack(idx + 1, sum + tracks[idx],t);

		t[idx] = false;
		backtrack(idx + 1, sum,t);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (bf.ready()) {
			st = new StringTokenizer(bf.readLine());
			target = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			tracks = new int[l];
			for (int i = 0; st.hasMoreTokens(); i++)
				tracks[i] = Integer.parseInt(st.nextToken());
			
			boolean[]taken = new boolean[l];
			candidate = new boolean[l];
			max = -1;
			backtrack(0, 0,taken);
			for(int i=0; i<l; i++)
				if(candidate[i])
					System.out.print(tracks[i]+" ");
			System.out.print("sum:"+max);
			System.out.println();
		}
	}
}

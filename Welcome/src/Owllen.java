import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Owllen {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		for (int i = 1; i <= t; i++) {
			String s = bf.readLine();
			int[] freq = new int[26];
			for (int j = 0; j < s.length(); j++)
				freq[s.charAt(j) - 'a']++;
            int min =1000000;
            for(int j=0; j<freq.length; j++)
            	if(freq[j]<min)
            		min=freq[j];
            System.out.println("Case "+i+": "+min);
		}
	}
}

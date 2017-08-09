import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class SequenceEquation {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		TreeMap<Integer, Integer> index_value = new TreeMap<>();
		TreeMap<Integer, Integer> value_index = new TreeMap<>();
		for(int i=1; st.hasMoreTokens(); i++){
			int v = Integer.parseInt(st.nextToken());
			index_value.put(i,v);
			value_index.put(v, i);
		}
		for(int i=1; i<=n; i++){
			int indx = value_index.get(i);
			System.out.println(value_index.get(indx));
		}
	}
}

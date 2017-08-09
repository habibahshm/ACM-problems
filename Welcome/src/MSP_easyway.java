import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class MSP_easyway {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while (bf.ready()) {
			ArrayList<String> numbers = new ArrayList<String>();
			st = new StringTokenizer(bf.readLine());
			int l = st.countTokens()-1;
			int n=l;
			while(l-->0)
				numbers.add(st.nextToken());
			
			BigInteger max = new BigInteger(numbers.get(0));

			for (int i = 1; i < l; i++) {
				BigInteger product = BigInteger.ONE;
				for (int j = i; j < l; j++) {
					product = product.multiply(new BigInteger(numbers.get(j)));
					if (product.compareTo(max) == 1)
						max = product;
				}
			}
			System.out.println(max);
		}
	}
}

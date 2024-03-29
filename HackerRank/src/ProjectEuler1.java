import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

public class ProjectEuler1 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		while (t-- > 0) {
			long n = Integer.parseInt(bf.readLine());
			long nthree;
			if(n%3==0)
				nthree =n-3;
			else
				nthree = n-(n%3);
			BigInteger threesum = new BigInteger(((nthree/3)*(3+nthree))/2+"");
			
			long nfive;
			if(n%5==0)
				nfive =n-5;
			else
				nfive = n-(n%5);
			BigInteger fivesum = new BigInteger(((nfive/5)*(5+nfive))/2 +"");
			
			long nfifteen;
			if(n%15==0)
				nfifteen =n-15;
			else
				nfifteen = n-(n%15);
			BigInteger fifteensum = new BigInteger(((nfifteen/15)*(15+nfifteen))/2+"");
			
			BigInteger ans = threesum.add(fivesum).subtract(fifteensum);
			System.out.println(ans);
		}
	}
}

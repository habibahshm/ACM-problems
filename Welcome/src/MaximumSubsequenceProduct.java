import java.io.*;
import java.util.*;
import java.math.*;

public class MaximumSubsequenceProduct {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(bf.ready()){
		st = new StringTokenizer(bf.readLine());
		ArrayList<String> numbers = new ArrayList<String>();
		int l = st.countTokens()-1;
		while(l-->0){
			numbers.add(st.nextToken());
		}
		
		BigInteger max_product = BigInteger.ONE;
		BigInteger min_product = BigInteger.ONE;
		BigInteger global = new BigInteger("-999999");
		for (int i = 0; i < numbers.size(); i++) {
			BigInteger v = new BigInteger(numbers.get(i));
			BigInteger temp_max = max_product.multiply(v);
			BigInteger temp_min = min_product.multiply(v);
			
			if ((temp_max.compareTo(v)==1 || temp_max.compareTo(v)==0 )&& (temp_max.compareTo(temp_min)==1 || temp_max.compareTo(temp_min)==0) ) 
				max_product = new BigInteger(temp_max.toString());
			else
				if((v.compareTo(temp_max)==1 || v.compareTo(temp_max)==0) && (v.compareTo(temp_min)==1 || v.compareTo(temp_min)==0) )
					max_product = new BigInteger(v.toString());
				else
					if((temp_min.compareTo(temp_max)==1 || temp_min.compareTo(temp_max)==0 )&& (temp_min.compareTo(v)==1 || temp_min.compareTo(v)==0))
						max_product = new BigInteger(temp_min.toString());
			
			if((temp_min.compareTo(temp_max)==-1 || temp_min.compareTo(temp_max)==0 )&& (temp_min.compareTo(v)==-1 || temp_min.compareTo(v)==0))
				min_product = new BigInteger(temp_min.toString());
			else
				if ((temp_max.compareTo(temp_min) == -1 || temp_max.compareTo(temp_min) == 0)&& (temp_max.compareTo(v) == -1 || temp_max.compareTo(v) == 0)) 
					min_product = new BigInteger(temp_max.toString());
				else
					if(( v.compareTo(temp_min)==-1 ||  v.compareTo(temp_min)==0) &&  (v.compareTo(temp_max)==-1 || v.compareTo(temp_max)==-1))
						min_product = new BigInteger(v.toString());
			
			
			if(max_product.compareTo(global)==1)
				global = new BigInteger(max_product.toString());
			
			if(max_product.equals(BigInteger.ZERO))
				max_product = BigInteger.ONE;
			
			if(min_product.equals(BigInteger.ZERO))
				min_product = BigInteger.ONE;
			}
		
		System.out.println(global);
		}
	}
}

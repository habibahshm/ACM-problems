import java.io.*;
import java.util.*;

public class IQtest {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int l = Integer.parseInt(bf.readLine());
		int[] num = new int[l];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < l; i++)
			num[i] = Integer.parseInt(st.nextToken());
		String majority = "";
		for (int i = 0; i < 3; i++)
			majority += num[i] % 2;
		int m = Integer.parseInt(majority,2);
		if (m == 3 || m > 4)
			m = 1;
		else
			m = 0;
		for (int i = 0; i < l; i++)
			if (num[i]%2 != m) {
				System.out.println(i + 1);
				break;
			}

	}
}

import java.io.*;

public class Magnets {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine())-1;
		int count = 1;
		String a = "";
		String b = bf.readLine();
		while (n-- > 0) {
			a = b;
			b = bf.readLine();
			if (!a.equals(b))
				count++;
		}
		System.out.println(count);
	}
}

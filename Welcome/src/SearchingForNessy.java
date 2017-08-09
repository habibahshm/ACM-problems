import java.io.*;

public class SearchingForNessy {
	
	static int boxno(int r, int c) {
		int n = r / 3;
		int m = c / 3;
		return n * m;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		int n = Integer.parseInt(s);
		
		for (int i = 1; i <= n; i++) {
			String t = bf.readLine();
			String[] a = t.split("\\s");
			int r = Integer.parseInt(a[0]);
			int c = Integer.parseInt(a[1]);
			System.out.println(boxno(r, c));
		}
	}

}

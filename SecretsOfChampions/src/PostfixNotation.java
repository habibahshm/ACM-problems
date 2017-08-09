import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PostfixNotation {
	public static class Stack1 {
		int[] stackarr;
		int top;

		public Stack1(int n) {
			stackarr = new int[n];
			top = -1;
		}

		public boolean isEmpty() {
			return (top == -1);
		}

		public void push(int i) {
			stackarr[++top] = i;
		}

		public int pop() {
			return stackarr[top--];
		}

		public int peak() {
			return stackarr[top];
		}

	}

	public static void main(String[] args) throws IOException {
	   BufferedReader bf = new BufferedReader(new FileReader("postfix.in"));
		//BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new FileWriter("postfix.out"));
		String s = bf.readLine();
		StringTokenizer st = new StringTokenizer(s);
		Stack1 q = new Stack1(s.length());
		q.push(Integer.parseInt(st.nextToken()));
		if (st.hasMoreTokens())
			q.push(Integer.parseInt(st.nextToken()));
		while (st.hasMoreTokens()) {
			String curr = st.nextToken();
			if (curr.equals("+")) {
				int b = q.pop();
				int a = q.pop();
				q.push(a + b);
			} else if (curr.equals("-")) {
				int b = q.pop();
				int a = q.pop();
				q.push(a - b);
			} else if (curr.equals("*")) {
				int b = q.pop();
				int a = q.pop();
				q.push(a * b);
			} else
				q.push(Integer.parseInt(curr));
			
		}

		out.println(q.pop());
		out.flush();
		out.close();
	}
}

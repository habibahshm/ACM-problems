import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class week2p2_Stack {
	static class Queues {
		int[] qarr;
		int front = 0;
		int rear = -1;

		public Queues(int n) {
			qarr = new int[n];
		}

		public void push(int x) {
			if (rear == qarr.length - 1)
				rear = -1;
			qarr[++rear] = x;
		}

		public int pop() {
			int tmp = qarr[front++];
			if (front == qarr.length)
				front = 0;
			return tmp;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader("queue.in"));
		PrintWriter out = new PrintWriter(new FileWriter("queue.out"));
		StringTokenizer st;
		int n = Integer.parseInt(bf.readLine());
		Queues s = new Queues(n);
		while (n-- > 0) {
			st = new StringTokenizer(bf.readLine());
			String sign = st.nextToken();
			if (sign.equals("-"))
				out.println(s.pop());
			else {
				int x = Integer.parseInt(st.nextToken());
				s.push(x);
			}

		}
		out.flush();
		out.close();
	}
}

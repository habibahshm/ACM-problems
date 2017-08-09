import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class QueuewithMinimum {
	
//	Push operation
//
//	1.If the queue is empty, just push the element on both, the queue and the deque.
//	2.If the queue is not empty, push the element on the queue, going from the back of the deque delete all elements that are strictly less than the one we are now pushing (they will surly not be the max, since the pushed element is larger and will last on the queue for longer) and push the current element on the back of the deque
//	
//	Remove operation
//
//	1.If the front of the deque is equal to the front of the queue then pop both (deque from the front)
//	2.If the front of the deque is not equal to the front of the queue then pop just the queue, the poped element surely is not the largest one.
//	
//	Get max
//
//	It is just the first element of the deque.
	
	//The min versions is done analogically.
	
	static public class MyDeqeueu {
		int[] dqarr;
		int front = 0;
		int rear = -1;
		int n = 0;

		public MyDeqeueu(int n) {
			dqarr = new int[n];
		}

		public void pushRaer(int x) {
			if (rear == dqarr.length - 1)
				rear = -1;
			dqarr[++rear] = x;
			n++;
		}

		public void pushFront(int x) {
			front--;
			if (front < 0)
				front = dqarr.length - 1;
			dqarr[front] = x;
			n++;
		}

		public int popRear() {
			n--;
			return dqarr[rear--];
		}

		public int popfront() {
			n--;
			return dqarr[front++];
		}

		public int peekRear() {
			return dqarr[rear];
		}

		public int peekFront() {
			return dqarr[front];
		}

		public boolean isEmpty() {
			return (n == 0);
		}
	}

	static class Queues {
		int[] qarr;
		int front = 0;
		int rear = -1;
		int n = 0;
		MyDeqeueu min;

		public Queues(int n) {
			qarr = new int[n];
			min = new MyDeqeueu(n);
		}

		public void push(int x) {
			if (rear == qarr.length - 1)
				rear = -1;
			if (n == 0) {
				qarr[++rear] = x;
				n++;
				min.pushRaer(x);
			} else {
				qarr[++rear] = x;
				n++;
				int curr = min.peekRear();
				while (curr > x) {
					min.popRear();
					if (!min.isEmpty())
						curr = min.peekRear();
					else
						break;
				}
				min.pushRaer(x);
			}

		}

		public int pop() {
			int tmp = qarr[front++];
			if (front == qarr.length)
				front = 0;
			n--;
			if (tmp == min.peekFront())
				min.popfront();
			return tmp;
		}

		public int getMin() {
			return min.peekFront();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader("queuemin.in"));
		PrintWriter out = new PrintWriter(new FileWriter("queuemin.out"));
		StringTokenizer st;
		int n = Integer.parseInt(bf.readLine());
		Queues s = new Queues(n);
		while (n-- > 0) {
			st = new StringTokenizer(bf.readLine());
			String sign = st.nextToken();
			if (sign.equals("-"))
				s.pop();
			else {
				if (sign.equals("+")) {
					int x = Integer.parseInt(st.nextToken());
					s.push(x);
				} else
					out.println(s.getMin());
			}

		}
		out.flush();
		out.close();
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class AnagramsbyStack {
	static String target;
	static String start;

	public static void search(String ans, String popped, String stack, int currIdx) {

		if (popped.length() > 0 && !popped.equals(target.substring(0, popped.length())))
			return;
		
		if (currIdx == start.length()) {
			while (stack.length() > 0) {
				popped += stack.charAt(stack.length() - 1);
				stack = stack.substring(0, stack.length() - 1);
				if (stack.length() > 0)
					ans += "o ";
				else
					ans += "o";
			}
			// System.out.println("base condition: " + popped);
			if (popped.equals(target))
				System.out.println(ans);
			return;
		}

		// System.out.println(
		// "entering push, ans: " + ans + ", popped: " + popped + ", stack: " +
		// stack + ", currIdx: " + currIdx);
		search(ans + "i ", popped, stack + start.charAt(currIdx), currIdx + 1);

		if (stack.length() > 0) {
			// System.out.println("entering pop, ans: " + ans + ", popped: " +
			// popped + ", stack: " + stack + ", currIdx: "
			// + currIdx);
			search(ans + "o ", popped + stack.charAt(stack.length() - 1), stack.substring(0, stack.length() - 1),
					currIdx);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while (bf.ready()) {
			start = bf.readLine();
			target = bf.readLine();
			System.out.println("[");
			if (start.length() == target.length())
				search("", "", "", 0);
			System.out.println("]");
		}
	}
}

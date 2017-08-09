
public class SuffixTrie {

	static class Node {
		Node[] next = new Node[26];
		int cnt = 0;
	}

	Node root = new Node();

	SuffixTrie(String s) {
		for (int i = 0; i < s.length(); i++)
			put(s, i);
	}

	void put(String s, int indx) {
		Node cur = root;
		cur.cnt++;
		while (indx < s.length()) {
			Node nxt = cur.next[s.charAt(indx) - 'a'];
			if (nxt == null)
				cur.next[s.charAt(indx) - 'a'] = nxt = new Node();
			cur = nxt;
			cur.cnt++;
			indx++;
		}
	}

	boolean search(String p) {
		Node cur = root;
		for (int i = 0; i < p.length(); i++) {
			Node nxt = cur.next[p.charAt(i) - 'a'];
			if (nxt == null)
				return false;
			cur = nxt;
		}
		return true;
	}

	int findOcc(String p) {
		Node cur = root;
		for (int i = 0; i < p.length(); i++) {
			Node nxt = cur.next[p.charAt(i) - 'a'];
			if (nxt == null)
				return 0;
			cur = nxt;
		}
		return cur.cnt;
	}

}

import java.util.*;
import java.io.*;

public class TreesOnTheLevel {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TreeMap<String, Integer> tm = new TreeMap<String, Integer>();
		int max = 0;
		String r;
		int root = -1;
		ArrayList<String>[] p = new ArrayList[256];
		for (int i = 1; i < 256; i++)
			p[i] = new ArrayList<String>();
		boolean complete = true;
		while (sc.hasNext()) {
			while (!(r = sc.next()).equals("()")) {
				String n = r.substring(1, r.length() - 1);
				String[] comp = n.split(",");
				int val = Integer.parseInt(comp[0]);
				if (comp.length == 1) {
					root = val;
					continue;
				} 
				String path = comp[1];
				if(tm.containsKey(path)){
					complete = false;
					continue;
				}
				tm.put(path, val);
				int i = path.length();
				max = Math.max(i, max);
				p[i].add(path);
			}
			if (complete)
				for (int i = 1; i <= max; i++) {
					if (p[i].size() == 0)
						complete = false;
				}
			if (complete && root != -1) {
				System.out.print(root);
				for (int i = 1; i <= max; i++) {
					Collections.sort(p[i]);
					for (int j = 0; j < p[i].size(); j++)
						System.out.print(" " + tm.get(p[i].get(j)));
				}
				System.out.println();
			} else
				System.out.println("not complete");

			tm.clear();
			for (int i = 1; i <= max; i++)
				p[i].clear();
			max = 0;
			root = -1;
			complete = true;
		}
	}
}

import java.util.*;
import java.io.*;

public class MutantFlatWorldExplorer {
	static int[][] map;
	static char direction;
	static int px;
	static int py;
	static int x;
	static int y;

	public static void changeDirection(char command, char current) {
		if (command == 'L') {
			switch (current) {
			case 'N':
				direction = 'W';
				break;
			case 'E':
				direction = 'N';
				break;
			case 'S':
				direction = 'E';
				break;
			case 'W':
				direction = 'S';
				break;
			}
		} else
			switch (current) {
			case 'N':
				direction = 'E';
				break;
			case 'E':
				direction = 'S';
				break;
			case 'S':
				direction = 'W';
				break;
			case 'W':
				direction = 'N';
				break;
			}

	}

	public static void move(char direction) {
		switch (direction) {
		case 'N':
			py--;
			break;
		case 'E':
			px++;
			break;
		case 'S':
			py++;
			break;
		case 'W':
			px--;
			break;
		}
	}

	public static boolean lost(int a, int b) {
		return a < 0 || a >= x || b < 0 || b >= y;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		x = Integer.parseInt(st.nextToken()) + 1;
		y = Integer.parseInt(st.nextToken()) + 1;
		boolean br = false;
		map = new int[y][x];
		String s;
		while ((s=bf.readLine())!=null && s.length()!=0) {
			st = new StringTokenizer(s);
			px = Integer.parseInt(st.nextToken());
			py = y - 1 - Integer.parseInt(st.nextToken());
			direction = st.nextToken().charAt(0);
			String commands = bf.readLine();
			for (int i = 0; i < commands.length(); i++) {
				char c = commands.charAt(i);
				switch (c) {
				case 'L':
				case 'R':
					changeDirection(c, direction);
					break;
				case 'F':
					int prevx = px;
					int prevy = py;
					move(direction);
					if (lost(px, py) && map[prevy][prevx] == 0) {
						System.out.println(prevx + " " + (y-1-prevy) + " "
								+ direction + " LOST");
						map[prevy][prevx] = 1;
						br = true;
					} else if (lost(px, py) && map[prevy][prevx] == 1) {
						px = prevx;
						py = prevy;
					}
                    break;
				}
				if(br)
					break;
			}
			if(!br)
			System.out.println(px + " " + (y-1-py) + " " + direction);
			br = false;
		}
	}
}


public class Permutations {
	public static boolean isNext(int[] arr) {
		int len = arr.length;
		int prev = arr[len - 1];
		for (int i = len - 2; i >= 0; i--) {
			if (arr[i] < prev)
				return true;
			prev = arr[i];
		}
		return false;
	}

	public static int[] nextPerm(int[] arr) {
		int len = arr.length;
		int prev = arr[len - 1];
		int i;
		for (i = len - 2; i >= 0; i--) {
			if (arr[i] < prev)
				break;
			prev = arr[i];
		}
		for (int j = len - 1; j > i; j--) {
			if (arr[j] > arr[i]) {
				int tmp = arr[j];
				arr[j] = arr[i];
				arr[i] = tmp;
				break;
			}
		}
		int s = i + 1;
		int e = len - 1;
		while (s < e) {
			int tmp = arr[s];
			arr[s] = arr[e];
			arr[e] = tmp;
			s++;
			e--;
		}
		return arr;
	}
}

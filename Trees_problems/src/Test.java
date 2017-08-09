import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Test {
 public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	ArrayList<Integer> a = new ArrayList<>();
	a.add(1);
	a.add(2);
	ArrayList<Integer> b = new ArrayList<>();
	b.add(5);
	a.addAll(b);
	for(int i:a)
		System.out.println(i);
}
}

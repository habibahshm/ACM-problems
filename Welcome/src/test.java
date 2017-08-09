import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class test {

	public static void main(String[] args)throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader("princess.in"));
		PrintWriter out = new PrintWriter(new FileWriter("princess.out"));
		for (int i = 0; i < 3; i++) {
		 out.println(bf.readLine());	
		}
		out.flush();
		out.close();
	}

}

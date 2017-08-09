import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.BufferUnderflowException;
import java.text.DecimalFormat;

public class TroubleWithAPentagon {

	static double degToRad(double d) {
		return d * Math.PI / 180.0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			double f = Double.parseDouble(bf.readLine());
			double ans = (Math.sin(degToRad(108)) / Math.sin(degToRad(63))) * f;
			DecimalFormat formatter = new DecimalFormat("0.0000000000");
			System.out.println(formatter.format(ans));
		}
	}
}

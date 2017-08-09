import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProficiencyTest {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		
//		char answer[] = new char[6];
//		
//		char model[] = new char[6];
		int counter = 0;
		
		for (int i = 0; i < str1.length() && counter< 3; i++) {
			if( Character.isLowerCase(str1.charAt(i)) ){
				if(str1.charAt(i) != Character.toLowerCase(str2.charAt(i)))
					counter++;
					
			}
		}
		if(counter >= 3)
			System.out.println("Remove");
		else
			System.out.println("Kafo");
	}

}

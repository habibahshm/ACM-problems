
public class Test {
	static void swap(String[] s1, String []s2){
	    String []temp = s1;
	    s1=s2;
	    s2=temp;
	    System.out.println(s1[0]+" "+s2[0]);
	}

		
	public static void main(String[] args) {
	    String []s1 = {"1"}, s2 = {"world"};
	    swap(s1, s2);
	    System.out.println(s1[0]+" "+s2[0]);
	}
}

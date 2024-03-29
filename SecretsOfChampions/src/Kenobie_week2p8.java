import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Kenobie_week2p8 {
	public static void main(String[] args) throws IOException {
		//BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader bf = new BufferedReader(new FileReader("kenobi.in"));
		PrintWriter out = new PrintWriter(new FileWriter("kenobi.out"));
		int n = Integer.parseInt(bf.readLine());
        Deque<Integer> left = new ArrayDeque<>();
        Deque<Integer> right = new ArrayDeque<>();
        int size =0;
        StringTokenizer st;
        while(n-- >0){
        	st = new StringTokenizer(bf.readLine());
        	String a = st.nextToken();
        	if(a.equals("add")){
        		int b = Integer.parseInt(st.nextToken());
        		size++;
        		if(right.isEmpty() && left.isEmpty())
        			left.addFirst(b);
        		else{
        			int leftsize = size/2;
        			if(left.size()<leftsize){
        				left.addLast(right.removeFirst());
        				right.addLast(b);
        			}else
        				right.addLast(b);
        		}
        	}else if(a.equals("take")){
        		size--;
        		right.removeLast();
        		if(left.size()>(size/2))
        			right.addFirst(left.removeLast());
        	}else{
        		Deque<Integer> tmp = left;
        		left = right;
        		right = tmp;
        		if(left.size()>(size/2))
        			right.addFirst(left.removeLast());
        	}
        }
        left.addAll(right);
        out.println(size);
        for(Integer i: left){
        	out.print(i+" ");
        }
        
        out.println();
        out.flush();
        out.close();
	}
}

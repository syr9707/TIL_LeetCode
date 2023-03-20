import java.util.*;
import java.io.*;

public class Main {
	
	static String S, T;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		S = br.readLine();
		T = br.readLine();
		
		if(solve(T)) System.out.println(1);
		else System.out.println(0);

	}
	
	static boolean solve(String str) {
		if(str.length() == S.length()) {
			if(str.equals(S)) return true;
			return false;
		}
		
		if(str.charAt(str.length() - 1) == 'A') {
			if(solve(str.substring(0, str.length() - 1))) return true;
		}
		
		if(str.charAt(0) == 'B') {
			StringBuilder sb = new StringBuilder(str.substring(1, str.length()));
			if(solve(sb.reverse().toString())) return true;
		}
		
		return false;
	}

}

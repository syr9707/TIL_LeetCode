import java.util.*;
import java.io.*;

public class Main {
	
	static int L, C;
	static char[] list;
	static char[] code;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		list = new char[C];
		code = new char[L];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < C; i++) {
			list[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(list);
		
		makeCode(0, 0);

	}
	
	public static void makeCode(int x, int idx) {
		
		if(idx == L) {
			if(isValid()) {
				System.out.println(code);
			}
			return;
		}
		
		for(int i = x; i < C; i++) {
			code[idx] = list[i];
			makeCode(i + 1, idx + 1);
		}
		
	}
	
	public static boolean isValid() {
		int mo = 0;
		int ja = 0;
		
		for(char c : code) {
			if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') mo++;
			else ja++;
		}
		
		if(mo >= 1 && ja >= 2) {
			return true;
		}
		return false;
	}

}

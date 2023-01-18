import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = Integer.MAX_VALUE;
		
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");
		
		while(st.hasMoreTokens()) {
			
			int sum = 0;
			
			StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+");
			
			while(st2.hasMoreTokens()) {
				sum += Integer.parseInt(st2.nextToken());
			}
			
			if(answer == Integer.MAX_VALUE) {
				answer = sum;
			} else {
				answer -= sum;
			}
			
		}
		
		System.out.println(answer);

	}

}

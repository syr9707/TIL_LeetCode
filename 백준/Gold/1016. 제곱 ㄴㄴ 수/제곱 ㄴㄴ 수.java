import java.util.*;
import java.io.*;

public class Main {
    
	public static void main(String args[]) throws IOException {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long min = Long.valueOf(st.nextToken());
		long max = Long.valueOf(st.nextToken());
		
		int result = (int) (max - min + 1);
		int sqrt = ((int) Math.sqrt(max));
		
		boolean[] checks = new boolean[result]; 
		long[] num = new long[result];
		
		for(long i = 2; i <= sqrt; i++) { 
				long squared = i * i;
				long start = min % squared == 0 ? min / squared : (min / squared) + 1;
				for(long j = start; j * squared <= max; j ++) {	
					checks[(int) ( (j * squared) - min)] = true;
				}
		}
		
		int count = 0;
		for(int i = 0; i < result; i++) {
			if(!checks[i])
				count++;
		}
		
		System.out.println(count);
	}
}
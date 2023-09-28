import java.util.*;
import java.io.*;

public class Main {
    
	static int cnt = 0;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int N = Integer.parseInt(br.readLine());
		int divNumber = 1000000000;
		
		long[] dp = new long[Math.max(3,N+1)];
		dp[2] = 1L;
		for (int i = 3; i <= N; i++) {
			dp[i] = ((i - 1) * (dp[i - 1] + dp[i - 2])) % divNumber;
		}
        
		System.out.println(dp[N]);
		
	}
}	
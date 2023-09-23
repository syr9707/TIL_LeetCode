import java.io.*;

public class Main {
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		long[] dp = new long[5001];
		dp[0] =1; dp[2] = 1;
		
		for(int i=2; i<2501; i++) {
			for(int j=0; j<i; j++) {
				dp[i*2] += (dp[j*2]*dp[(i-1-j)*2]);
				dp[i*2] %= 1000000007L;
			}
		}
		
		for(int i=0; i<t; i++) {
			int a = Integer.parseInt(br.readLine());
			System.out.println(dp[a]);
		}
	}
}
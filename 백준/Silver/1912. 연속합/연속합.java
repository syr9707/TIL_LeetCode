import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] arr = new int[N];
        int[] dp = new int[N];
        int max;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        dp[0] = arr[0];
        max = arr[0];
        for(int i=1; i<N; i++){
            dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
            
            max = Math.max(max, dp[i]);
        }
        
        System.out.println(max);

	}

}
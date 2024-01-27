import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int c = 0; c < t; c++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n+1];
            int[] dp = new int[n+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int max = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                dp[i] = dp[i-1] + arr[i];
                max = Math.max(max, Math.max(arr[i],dp[i]));
            }
            for (int i = 1; i <= n; i++) {
                for (int j = n; j > i; j--) {
                    max = Math.max(max, dp[j]-dp[i]);
                }
            }
            sb.append(max + "\n");
        }
        
        System.out.print(sb);
    }
}
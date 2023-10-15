import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n + 1][3];
        Arrays.fill(dp[1], 1);

        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;

            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;

            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
        }
        
        System.out.println((dp[n][0] + dp[n][1] + dp[n][2]) % 9901);
    }
}
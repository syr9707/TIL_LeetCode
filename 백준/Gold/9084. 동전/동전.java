import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int [] coins = new int[N];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }
            
            int M = Integer.parseInt(br.readLine());
            int [] dp = new int[M + 1];
            dp[0] = 1;
            for (int coin : coins) {
                for (int i = coin; i <= M; i++) {
                    dp[i] += dp[i - coin];
                }
            }

            sb.append(dp[M]).append("\n");
        }
        
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}
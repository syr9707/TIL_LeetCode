import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] dp = new int[N+1];
        int[] arr = new int[N+1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                    if (arr[i] > arr[j])
                        dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int[] dpRL = new int[N+1];
        for (int i = N; i >= 1; i--) {
            dpRL[i] = 1;
            for (int j = N; j >= 1; j--) {
                if (arr[i] > arr[j])
                    dpRL[i] = Math.max(dpRL[i], dpRL[j]+1);
            }
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(dp[i] + dpRL[i], max);
        }
        
        System.out.println(max-1);

    }
}
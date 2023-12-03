import java.io.*;
import java.util.*;

public class Main {
    
    static int n;
    static int map[][];
    static long dp[][];
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new long[n][n];
        
        for(int i=0; i<n; i++) {
            String[] t = br.readLine().split(" ");
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(t[j]);
            }
        }
        
        dp[0][0]=1;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i==n-1 && j==n-1) {
                    continue;
                }
                if(i+map[i][j]<n) {
                    dp[i+map[i][j]][j] += dp[i][j];
                }
                if(j+map[i][j]<n) {
                    dp[i][map[i][j]+j]+=dp[i][j];
                }
            }
        }
        
        System.out.println(dp[n-1][n-1]);
    }
}
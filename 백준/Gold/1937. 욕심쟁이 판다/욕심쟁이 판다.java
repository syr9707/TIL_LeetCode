import java.util.*;
import java.io.*;

public class Main{
    
    static int n;
    static int res = 0;
    static int[][] req = new int[501][501];
    static int[][] dp = new int[501][501];
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                req[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int ans = dfs(i,j);
                if(res < ans) res = ans;
            }
        }

        System.out.println(res);
    }
    
    static int dfs(int y, int x){
        if(dp[y][x] != 0) return dp[y][x];
        else {
            dp[y][x] = 1;

            for(int i=0;i<4;i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny<0 || ny>=n || nx<0 || nx>=n) continue;

                if(req[ny][nx] > req[y][x]){
                    dp[y][x] = Math.max(dp[y][x], dfs(ny,nx)+1);
                }
            }

            return dp[y][x];
        }
    }
}
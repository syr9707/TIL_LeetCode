import java.io.*;
import java.util.*;

public class Main {
    
    public static int n;
    public static int[][] map;
    public static int[][] pipeCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        pipeCnt = new int[n][n];
        
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        dfs(0,1,0);
        
        System.out.println(pipeCnt[n-1][n-1]);
    }
    
    public static void dfs(int r, int c, int rotate) {
        if (r>=n || c>=n || map[r][c]==1) return;
        
        if (rotate==0) {
            dfs(r,c+1,0);
            dfs(r+1,c+1,1);
        } else if (rotate==1) {
            if (map[r-1][c]==1 || map[r][c-1]==1) return;
            dfs(r,c+1,0);
            dfs(r+1,c+1,1);
            dfs(r+1,c,2);
        } else {
            dfs(r+1,c+1,1);
            dfs(r+1,c,2);
        }
        pipeCnt[r][c]++;
    }
}

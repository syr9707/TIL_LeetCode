import java.util.*;
import java.io.*;

public class Main {
	
	static int[][] map;
	static int M, N;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		// DFS + DP : 내리막 길
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		dp = new int[M][N];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		
		System.out.println(dfs(0, 0));

	}
	
	public static int dfs(int startY, int startX) {
		
		if(startY == M - 1 && startX == N - 1) return 1;
		
		if(dp[startY][startX] != -1) {
			// -1이 아닌 경우, 이미 방문했음
			return dp[startY][startX];
		} else {
			// -1인 경우만 방문
			dp[startY][startX] = 0;
			
			for(int i = 0; i < 4; i++) {
				int x = startX + dx[i];
				int y = startY + dy[i];
				
				if(x < 0 || x >= N || y < 0 || y >= M) continue;
				
				if(map[y][x] < map[startY][startX]) {
					dp[startY][startX] += dfs(y, x);
				}
			}
		}
		
		return dp[startY][startX];
	}

}

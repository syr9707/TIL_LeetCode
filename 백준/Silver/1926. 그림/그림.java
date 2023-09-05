import java.util.*;
import java.io.*;

public class Main {
	
	static int n, m;
	static int[][] map;
	static int count = 0;
	static int maxWide = 0;
	static int[] X = {-1, 1, 0, 0};
	static int[] Y = {0, 0, -1, 1};
	static boolean[][] check;
	static int sum = 0;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		check = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 1 && check[i][j] == false) {
					dfs(i, j);
					count++;
					sum = 0;
				}
			}
		}
		
		System.out.println(count + "\n" + maxWide);

	}
	
	public static void dfs(int startY, int startX) {
		check[startY][startX] = true;
		
		sum++;
		if(sum > maxWide) {
			maxWide = sum;
		}
		
		for(int i = 0; i < 4; i++) {
			int x = startX + X[i];
			int y = startY + Y[i];
			
			if(x < 0 || x >= m || y < 0 || y >= n) continue;
			
			if(map[y][x] == 1 && check[y][x] == false) dfs(y, x);
			
		}
	}

}

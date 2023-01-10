import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int[][] arr;
	static int max;
	static int maxHeight;
	static boolean[][] check;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		maxHeight = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] >= maxHeight) maxHeight = arr[i][j];
			}
		}
		
		max = 0;
		for(int height = 0; height <= maxHeight; height++) {
			check = new boolean[N][N];
			int count = 0;
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < N; k++) {
					if(arr[j][k] > height && check[j][k] == false) {
						dfs(j, k, height);
						count++;
					}
				}
			}
			max = Math.max(max, count);
		}
		
		System.out.println(max);

	}
	
	public static void dfs(int startX, int startY, int height) {
		check[startX][startY] = true;
		
		int[] X = {-1, 1, 0, 0};
		int[] Y = {0, 0, -1, 1};
		
		for(int i = 0; i < 4; i++) {
			int x = startX + X[i];
			int y = startY + Y[i];
			
			if(x < 0 || x >= N || y < 0 || y >= N) continue;
			
			if(arr[x][y] > height && !check[x][y]) dfs(x, y, height);
		}
	}

}

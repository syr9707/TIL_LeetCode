import java.util.*;
import java.io.*;

public class Main {
	
	static int[][] map;
	static int N, M;
	static int answer = 0;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[][] check;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		int[][] arr = new int[N][M];
		check = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				arr[i][j] = map[i][j];
			}
		}
		
		while(true) {
			int count = 0;
			
			int[][] arr2 = new int[N][M];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] ==  0) continue;
					map[i][j] -= ice(i, j, arr);
					if(map[i][j] < 0) map[i][j] = 0;
					arr2[i][j] = map[i][j];
				}
			}
			arr = arr2;
			
			check = new boolean[N][M];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] != 0 && !check[i][j]) {
						dfs(i, j);
						
						count++;
					}
				}
			}
			
			if(count == 0) {
				answer = 0;
				break;
			}
			
			answer++;
			if(count >= 2) break;
		}
		
		System.out.println(answer);

	}
	
	public static int ice(int startY, int startX, int[][] arr) {
		int count = 0;
		
		for(int i = 0; i < 4; i++) {
			int x = startX + dx[i];
			int y = startY + dy[i];
			
			if(x < 0 || x >= M || y < 0 || y >= N) continue;
			
			if(arr[y][x] == 0) count++;
		}
		
		return count;
	}
	
	public static void dfs(int startY, int startX) {
		check[startY][startX] = true;
		
		for(int i = 0; i < 4; i++) {
			int x = startX + dx[i];
			int y = startY + dy[i];
			
			if(x < 0 || x >= M || y < 0 || y >= N) continue;
			
			if(map[y][x] != 0 && !check[y][x]) dfs(y, x);
		}
	}
}

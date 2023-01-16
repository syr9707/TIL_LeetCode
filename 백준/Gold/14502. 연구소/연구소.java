import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static int[][] arr;
	static int[][] virusMap;
	static int[] X = {-1, 1, 0, 0};
	static int[] Y = {0, 0, -1, 1};
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0);
		
		System.out.println(max);

	}
	
	public static void dfs(int wall) {
		if(wall == 3) {
			bfs();
			return ;
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(arr[i][j] == 0) {
					arr[i][j] = 1;
					dfs(wall + 1);
					arr[i][j] = 0;
				}
			}
		}
	}
	
	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		virusMap = new int[N][M];
        
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				virusMap[i][j] = arr[i][j];
				if(virusMap[i][j] == 2) {
					q.add(new int[] {i, j});
				}
			}
		}
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			int x = poll[0];
			int y = poll[1];
			
			for(int i = 0; i < 4; i++) {
				int nx = x + X[i];
				int ny = y + Y[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M && virusMap[nx][ny] == 0) {
					virusMap[nx][ny] = 2;
					q.add(new int[] {nx, ny});
				}
			}
		}
		
		int count = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(virusMap[i][j] == 0) {
					count++;
				}
			}
		}
		
		max = Math.max(max, count);
	
	}

}

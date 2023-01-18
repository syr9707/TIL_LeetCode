import java.util.*;
import java.io.*;

public class Main {
	
	static int M, N;
	static int[][] tomato;
	static boolean[] check;
	static Queue<int[]> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		tomato = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(tomato[i][j] == 1) {
					queue.add(new int[] {i, j});
				}
			}
		}
		
		System.out.println(bfs());

	}
	
	public static int bfs() {
		
		int[] X = {-1, 1, 0, 0};
		int[] Y = {0, 0, -1, 1};
		
		while(!queue.isEmpty()) {
			int[] poll = queue.poll();
			int x = poll[0];
			int y = poll[1];
			
			for(int i = 0; i < 4; i++) {
				int nx = x + X[i];
				int ny = y + Y[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if(tomato[nx][ny] == 0) {
						tomato[nx][ny] = tomato[x][y] + 1; // depth
						queue.add(new int[] {nx, ny});
					}
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		if(checkZero()) return -1;
		else {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(max < tomato[i][j]) max = tomato[i][j];
				}
			}
			return max - 1;
		}
		
	}
	
	public static boolean checkZero() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(tomato[i][j] == 0) return true;
			}
		}
		return false;
	}

}

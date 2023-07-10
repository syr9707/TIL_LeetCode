import java.util.*;
import java.io.*;

public class Main {
	
	static int M, N; 
	static int[][] arr;
	static boolean[][] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine()); 
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			arr = new int[M][N];
			check = new boolean[M][N];
			
			for(int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr[x][y] = 1; 
			}
			int count = 0;
			
			
			for(int j = 0; j < M; j++) {
				for(int k = 0; k < N; k++) {
					if(arr[j][k] == 1 && !check[j][k]) {
						bfs(j, k);
						count++;
					}
				}
			}
			
			System.out.println(count);
		}
		
	}
	
	public static void bfs(int startX, int startY) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {startX, startY}); 
		int[] X = {0, 0, -1, 1};
		int[] Y = {-1, 1, 0, 0};
		 
		while(!queue.isEmpty()) {
			int[] poll = queue.poll(); 
			for(int i = 0; i < 4; i++) {
				int x = poll[0] + X[i];
				int y = poll[1] + Y[i];
				if(x < 0 || x >= M || y < 0 || y >= N) {
					continue;
				}
				if(arr[x][y] == 1 && !check[x][y]) {
					queue.add(new int[] {x, y}); 
					check[x][y] = true; 
				}
			}
		}
		
	}

}
import java.util.*;
import java.io.*;

public class Main {
	
	static int M, N, H;
	static int[][][] tomato;
	static Queue<int[]> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		tomato = new int[H][N][M];
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k < M; k++) {
					tomato[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < M; k++) {
					if(tomato[i][j][k] == 1) {
						queue.add(new int[] {i, j, k});
					}
				}
			}
		}
		
		System.out.println(bfs());

	}
	
	public static int bfs() {
		int[] X = {-1, 1, 0, 0, 0, 0};
		int[] Y = {0, 0, -1, 1, 0, 0};
		int[] Z = {0, 0, 0, 0, -1, 1};
		
		while(!queue.isEmpty()) {
			int[] poll = queue.poll();
			int x = poll[1];
			int y = poll[2];
			int z = poll[0];
			
			for(int i = 0; i < 6; i++) {
				int nx = x + X[i];
				int ny = y + Y[i];
				int nz = z + Z[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M && nz >= 0 && nz < H) {
					if(tomato[nz][nx][ny] == 0) {
						tomato[nz][nx][ny] = tomato[z][x][y] + 1;
						queue.add(new int[] {nz, nx, ny});
					}
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		if(checkZero()) return -1;
		else {
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < N; j++) {
					for(int k = 0; k < M; k++) {
						if(max < tomato[i][j][k]) max = tomato[i][j][k];
					}
				}
			}
			return max - 1;
		}
		
	}
	
	public static boolean checkZero() {
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < M; k++) {
					if(tomato[i][j][k] == 0) return true;
				}
			}
		}
		return false;
	}

}

import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static int r, c, d;
	static int[][] map;
	static int count = 0;
	static int[] dr = {-1, 0, 1, 0}; 
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		clean(r, c, d);
		
		System.out.println(count);

	}
	
	public static void clean(int row, int col, int direction) {
		
		if(map[row][col] == 0) {
			map[row][col] = 2;
			count++;
		}
		
		boolean flag = false;
		int origin = direction;
		for(int i = 0; i < 4; i++) {
			int next_d = (direction + 3) % 4;
			int next_r = row + dr[next_d];
			int next_c = col + dc[next_d];
			
			if(next_r > 0 && next_c > 0 && next_r < N && next_c < M) {
				if(map[next_r][next_c] == 0) { 
					clean(next_r, next_c, next_d);
					flag = true;
					break;
				}
			}
			direction = (direction + 3) % 4;
		}
		
		if(!flag) {
			int next_d = (origin + 2) % 4;
			int next_br = row + dr[next_d];
			int next_bc = col + dc[next_d];
			
			if(next_br > 0 && next_bc > 0 && next_br < N && next_bc < M) {
				if(map[next_br][next_bc] != 1) {
					clean(next_br, next_bc, origin); 
				}
			}
		}
		
	}

}

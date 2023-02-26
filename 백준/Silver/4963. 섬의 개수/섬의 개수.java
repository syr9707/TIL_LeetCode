import java.util.*;
import java.io.*;

public class Main {
	
	static int w, h;
	static int[][] arr;
	static boolean[][] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0) {
				break;
			}
			
			arr = new int[h][w];
			check = new boolean[h][w];
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int count = 0;
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(arr[i][j] == 1 && check[i][j] == false) {
						dfs(i, j);
						
						count++;
					}
				}
			}
			
			System.out.println(count);
		}

	}
	
	public static void dfs(int startY, int startX) {
		check[startY][startX] = true;
		int[] X = {0, 0, -1, 1, 1, 1, -1, -1};
		int[] Y = {-1, 1, 0, 0, 1, -1, 1, -1};
		
		for(int i = 0; i < 8; i++) {
			int x = startX + X[i];
			int y = startY + Y[i];
			
			if(x < 0 || x >= w || y < 0 || y >= h) {
				continue;
			}
			
			if(arr[y][x] == 1 && check[y][x] == false) {
				dfs(y, x);
			}
		}
		
	}

}
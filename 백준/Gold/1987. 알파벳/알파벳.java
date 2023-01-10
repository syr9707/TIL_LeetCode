import java.util.*;
import java.io.*;

public class Main {
	
	static int R, C;
	static int[][] arr;
	static boolean[] check = new boolean[26];
	static int max = 0;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[R][C];
		
		for(int i = 0; i < R; i++) {
			String str = br.readLine();
			for(int j = 0; j < C; j++) {
				arr[i][j] = str.charAt(j) - 'A';
			}
		}
		
		dfs(0, 0, 0);
		
		System.out.println(max);

	}
	
	public static void dfs(int startX, int startY, int count) {
		int[] X = {-1, 1, 0, 0};
		int[] Y = {0, 0, -1, 1};
		
		if(check[arr[startY][startX]]) {
			max = Math.max(max, count);
			return ;
		} else {
			check[arr[startY][startX]] = true;
			
			for(int i = 0; i < 4; i++) {
				int x = startX + X[i];
				int y = startY + Y[i];
				
				if(x >= 0 && y >= 0 && x < C && y < R) {
					dfs(x, y, count + 1);
				}
			}
			check[arr[startY][startX]] = false;
		}
	}

}

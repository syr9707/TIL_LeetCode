import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static char[][] arr;
	static boolean[][] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		check = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		int count = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				char c = arr[i][j];
				if(arr[i][j] == c && check[i][j] == false) {
					dfs(i, j, c);
					count++;
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(arr[i][j] == 'G') arr[i][j] = 'R';
			}
		}
		
		check = new boolean[N][N];
		int count2 = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				char c = arr[i][j];
				if(arr[i][j] == c && check[i][j] == false) {
					dfs(i, j, c);
					count2++;
				}
			}
		}
		
		System.out.println(count + " " + count2);

	}
	
	public static void dfs(int startY, int startX, char c) {
		check[startY][startX] = true;
		
		int[] X = {0, 0, -1, 1};
		int[] Y = {-1, 1, 0, 0};
		
		for(int i = 0; i < 4; i++) {
			int x = startX + X[i];
			int y = startY + Y[i];
			
			if(x < 0 || x >= N || y < 0 || y >= N) continue;
			
			if(arr[y][x] == c && check[y][x] == false) dfs(y, x, c); 
		}
	}

}
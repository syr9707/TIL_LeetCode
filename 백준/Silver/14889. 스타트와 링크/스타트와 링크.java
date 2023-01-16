import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int[][] arr;
	static boolean[] visit;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visit = new boolean[N];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
		System.out.println(min);

	}
	
	public static void dfs(int depth, int a) {
		
		if(depth == N / 2) {
			diff();
			return ;
		}
		
		for(int i = a; i < N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				dfs(depth + 1, i + 1);
				visit[i] = false;
			}
		}
	}
	
	public static void diff() {
		int start = 0;
		int link = 0;
		for(int i = 0; i < N - 1; i++) {
			for(int j = i + 1; j < N; j++) {
				if(visit[i] == true && visit[j] == true) {
					start += arr[i][j];
					start += arr[j][i];
				} else if(visit[i] == false && visit[j] == false) {
					link += arr[i][j];
					link += arr[j][i];
				}
			}
		}
		
		int val = Math.abs(start - link);
		
		if(val == 0) {
			System.out.println(val);
			System.exit(0);
		}
		
		min = Math.min(min, val);
	}

}

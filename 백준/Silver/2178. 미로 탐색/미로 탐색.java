import java.util.*;
import java.io.*;

public class Main {

	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		
		String s;
		char c;
		for (int i = 0; i < N; i++) {
			s = br.readLine();
			for (int j = 0; j < M; j++) {
				c = s.charAt(j);
				arr[i][j] = c - '0';
			}
		}
		
		visited[0][0] = true;
		bfs(0, 0);
		System.out.println(arr[N - 1][M - 1]);

	}
	
	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		
		while(!q.isEmpty()) {
			int now[] = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			
			for(int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
					continue;
				}
				if(visited[nextX][nextY] || arr[nextX][nextY] == 0) {
					continue;
				}
				q.add(new int[] {nextX, nextY});
				arr[nextX][nextY] = arr[nowX][nowY] + 1;
				visited[nextX][nextY] = true;
			}
		}
	}

}
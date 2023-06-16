import java.io.*;
import java.util.*;

public class Main {
    
	static int N, M, answer;
	static char[][] map;
	static Queue<int[]> queue = new LinkedList<int[]>();
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for(int i = 0 ; i < N ; i++) {
			String tmp = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(map[i][j] == 'L') {
					bfs(i,j);
				}
			}
		}
		System.out.println(answer);
	}
	
	private static void bfs(int x, int y) {
		int[][] visited = new int[N][M];
		for(int i = 0 ; i< N ; i++) {
			for(int j=0 ; j < M ; j++) {
				visited[i][j] = -1;
			}
		}
		
		visited[x][y] = 0;
		queue.offer(new int[] {x, y});
		
		while(! queue.isEmpty()) {
			int[] cur = queue.poll();
			int curX = cur[0];
			int curY = cur[1];
			
			for(int i = 0 ; i < 4 ; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				
				if(map[nx][ny] == 'L' && visited[nx][ny] == -1) {
					visited[nx][ny] = visited[curX][curY] + 1;
					queue.offer(new int[] {nx, ny});
					answer = Math.max(answer, visited[nx][ny]);
				}
			}
		}
	}
}
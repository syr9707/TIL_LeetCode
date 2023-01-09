import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int[][] maps;
	static boolean[][] visited;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	static int total = 0;
	static int count;
	static List<Integer> counts = new ArrayList<>(); 
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		maps = new int[N][N];
		visited = new boolean[N][N];
		
		String s;
		char c;
		for(int i = 0; i < N; i++) {
			s = br.readLine();
			for(int j = 0; j < N; j++) {
				c = s.charAt(j);
				maps[i][j] = c - '0';
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				count = 0;
				if(maps[i][j] == 1 && !visited[i][j]) {
					total++;
					count++;
					dfs(i, j);
					counts.add(count);
				}
			}
		}
		System.out.println(total);
		Collections.sort(counts);
		for(int i = 0; i < counts.size(); i++) {
			System.out.println(counts.get(i));
		}

	}
	
	public static void dfs(int cx, int cy) {
		visited[cx][cy] = true;
		
		int ny, nx;
		for(int i = 0; i < 4; i++) {
			ny = cy + dy[i];
			nx = cx + dx[i];
			
			if(ny >= 0 && ny < N && nx >= 0 && nx < N) {
				if(!visited[nx][ny] && maps[nx][ny] == 1) {
					count++;
					dfs(nx, ny);
				}
			}
		}
	}

}
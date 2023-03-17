import java.util.*;
import java.io.*;

public class Main {
	
	static int R, C, N;
	static char[][] map;
	static Queue<int[]> q = new LinkedList<>();
    static int[] dx = {-1, 0, 1, 0}; 
    static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for(int i = 0; i < R; i++) {
			String s = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		for(int i = 2; i <= N; i++) {
			if(i % 2 == 1) {
				// 폭탄위치 저장하기
				for(int j = 0; j < R; j++) {
					for(int k = 0; k < C; k++) {
						if(map[j][k] == 'O') {
							q.add(new int[] {j, k});
						}
					}
				}
				for(char[] m : map) {
					Arrays.fill(m, 'O');
				}
				bfs();
			}
		}
		
		if(N % 2 == 0) {
			for(char[] m : map) {
				Arrays.fill(m, 'O');
			}
		}
		
		for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

	}
	
	static void bfs() {
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			int x = poll[0];
			int y = poll[1];
			map[x][y] = '.';
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >= 0 && nx < R && ny >= 0 && ny < C) {
					if(map[nx][ny] == 'O') {
						map[nx][ny] = '.';
					}
				}
			}
		}
	}

}
